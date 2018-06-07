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
        yes.setSize(500, 500);
        yes.setLocationRelativeTo(null);
        yes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        yes.setVisible(true);
    }
}

class GameScreen extends JPanel {
    int x, y;
    ArrayList<Integer> xList = new ArrayList<>();
    ArrayList<Integer> yList = new ArrayList<>();
    ArrayList<Integer> hList = new ArrayList<>();
    ArrayList<Integer> wList = new ArrayList<>();

    Random boi = new Random();
    int obX = boi.nextInt(500);
    int obY = 0;
    int obH = boi.nextInt(30) + 20;
    int obW = boi.nextInt(30) + 20;
    Color colour = new Color(boi.nextInt(255), boi.nextInt(255), boi.nextInt(255));

    Timer timer = new Timer(50, new TimerListener());

    public GameScreen() {
        mouse gs = new mouse();
        this.addMouseListener(gs);
        this.addMouseMotionListener(gs);

        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(x, y, 20, 20);

        drawObstacles(g);

    }


    public void drawObstacles(Graphics g) {

        for (int i = 0; i < xList.size(); i++) {
            g.setColor(colour);
            g.fillRect(xList.get(i), yList.get(i), wList.get(i), hList.get(i));

        }
    }



    class mouse extends MouseAdapter {

        @Override
        public void mouseDragged(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            for (int i = 0; i < xList.size(); i++) {
                if (x < xList.get(i) + wList.get(i) && x > xList.get(i) && y < yList.get(i) + hList.get(i) && y < yList.get(i) + hList.get(i)) {
                    timer.stop();
                    getGraphics().setColor(Color.WHITE);
                    getGraphics().fillRect(0, 0, getWidth(), getHeight());
                }
            }

            repaint();

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            for (int i = 0; i < xList.size(); i++) {
                if (x < xList.get(i) + wList.get(i) && x > xList.get(i) && y < yList.get(i) + hList.get(i) && y < yList.get(i) + hList.get(i)) {
                    timer.stop();
                    getGraphics().setColor(Color.WHITE);
                    getGraphics().fillRect(0, 0, getWidth(), getHeight());
                }
            }
            repaint();
        }

    }


    public class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            xList.add(obX);
            yList.add(obY);
            hList.add(obH);
            wList.add(obW);

            for (int d = 0; d < xList.size(); d++) {
                yList.set(d, yList.get(d) + 20);
            }


            repaint();


        }
    }
}

/*
    Timer timer = new Timer(200, new TimerListener());

    Random rand = new Random();
    int vel = rand.nextInt(3);
    int y = 0;
    int x = 0;
 //   ObstacleRect p = new ObstacleRect(x,y,20,100);

//    ObstacleRect[] possible = new ObstacleRect[];

    public GameScreen() {

        timer.start();

    }


    protected void paintComponent(Graphics g) {


        g.setColor(Color.BLACK);
        g.fillRect(x,y,20,100);


    }


    public class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {

                    x = e.getX();
                    y = e.getY();

                    repaint();
                }
            });

        }
*/

