import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import sun.audio.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Beats");
        add (new GameScreen());

    }

    public static void main(String[] args) throws Exception{

        AudioPlayer MGP = AudioPlayer.player;
        String gongFile = "wiiMusic.wav";
        InputStream in = new FileInputStream(gongFile);

        // create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(in);

        // play the audio clip with the audioplayer class

        AudioPlayer.player.start(audioStream);
        JFrame yes = new MainFrame();
        yes.setSize(500,500);
        yes.setLocationRelativeTo(null);
        yes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        yes.setVisible(true);
    }
}

class GameScreen extends JPanel {
    int sec;
    int msec;
    int x, y;
    String ssec;
    boolean end = false;
    ArrayList<Integer> xList = new ArrayList<>();
    ArrayList<Integer> yList = new ArrayList<>();
    ArrayList<Integer> hList = new ArrayList<>();
    ArrayList<Integer> wList = new ArrayList<>();
    ArrayList<Integer> xaList = new ArrayList<>();
    ArrayList<Integer> yaList = new ArrayList<>();
    ArrayList<Color> cList = new ArrayList<>();


    Timer timer = new Timer(50, new TimerListener());

    public GameScreen() {
        mouse gs = new mouse();
        this.addMouseListener(gs);
        this.addMouseMotionListener(gs);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font font = new Font("Times New Roman",Font.BOLD,getHeight()/9);
        FontMetrics fm = g.getFontMetrics(font);
        ssec = String.valueOf(sec);
        if (!end) {
            drawObstacles(g);
        }
        else {
            g.setColor(Color.WHITE);
            g.fillRect(0,0,getWidth(),getHeight());
            g.setColor(Color.black);
            g.setFont(font);
            g.drawString("Game Over", (getWidth() / 2) - (fm.stringWidth("Game Over") / 2),getHeight() / 2 - fm.getAscent() / 2);
            g.drawString("You survived " + ssec + " seconds", (getWidth() / 2) - (fm.stringWidth("You survived " + ssec + " seconds") / 2),getHeight() / 2 + fm.getAscent() / 2);
        }
    }


    public void drawObstacles(Graphics g) {

        for (int i = 0; i < xList.size(); i++) {
            g.setColor(cList.get(i));
            g.fillRect(xList.get(i), yList.get(i), wList.get(i), hList.get(i));

        }
    }



    class mouse extends MouseAdapter {

        @Override
        public void mouseDragged(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            for (int i = 0; i < xList.size(); i++) {
                if (x < xList.get(i) + wList.get(i) && x > xList.get(i) && y < yList.get(i) + hList.get(i) && y  > yList.get(i)) {
                        end = true;
                }
            }

            repaint();

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            for (int i = 0; i < xList.size(); i++) {
                if (x < xList.get(i) + wList.get(i) && x > xList.get(i) && y < yList.get(i) + hList.get(i) && y > yList.get(i)) {
                    end = true;
                }
            }
            repaint();
        }
        @Override
        public void mouseEntered(MouseEvent e){
            timer.start();
            repaint();
        }
        @Override
        public void mouseExited(MouseEvent e){
            end = true;
            repaint();
        }

    }


    public class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!end) {

                Random boi = new Random();
                int obX = boi.nextInt(500);
                int obY = boi.nextInt(500);
                int obH = boi.nextInt(30) + 20;
                int obW = boi.nextInt(30) + 20;
                int obXa = boi.nextInt(10)-5;
                int obYa = boi.nextInt(10)-5;
                if (x < obX + obW + 20 && x > obX-20 && y < obY + obH + 20 && y > obY-20) {
                    obX = boi.nextInt(500);
                    obY = boi.nextInt(500);
                }
                Color colour = new Color(boi.nextInt(255), boi.nextInt(255), boi.nextInt(255));


                xList.add(obX);
                yList.add(obY);
                hList.add(obH);
                wList.add(obW);
                xaList.add(obXa);
                yaList.add(obYa);
                cList.add(colour);

                for (int d = 0; d < xList.size(); d++) {
                    yList.set(d, yList.get(d) + yaList.get(d));
                    xList.set(d, xList.get(d) + xaList.get(d));

                }
                msec+=1;
                if (msec%20==0){
                    sec +=1;
                }
            }


            repaint();


        }
    }
}
