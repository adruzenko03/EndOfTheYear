import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import sun.audio.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Beats");
        add (new GameScreen());

    }

    public static void main(String[] args) {
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

    Timer 타이모 = new Timer(300, new TimerListener());

    public GameScreen() {
        mouse gs = new mouse();
        this.addMouseListener(gs);
        this.addMouseMotionListener(gs);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(x, y, 20, 20);

    }

    public void drawObstacles (Graphics g) {

    }


    class mouse extends MouseAdapter {

        @Override
        public void mouseDragged(MouseEvent e) {
            x = e.getX();
            y = e.getY();

            repaint();

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            x = e.getX();
            y = e.getY();
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

