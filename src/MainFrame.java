import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Background;
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


    public void drawObstacles (Graphics g) {

        for (int i = 0; i < xList.size(); i++) {
            g.setColor(colour);
            g.fillRect(xList.get(i), yList.get(i), wList.get(i), hList.get(i));

            if (i > 0) {
                g.setColor(getBackground());
                g.fillRect(xList.get(i), yList.get(i) - 20, wList.get(i), 20);
            }




        }
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

            if (!yList.contains(500)) {

                xList.add(obX);
                yList.add(obY);
                hList.add(obH);
                wList.add(obW);

            }

            for (int d = 0;d < xList.size(); d++) {
                yList.set(d, yList.get(d) + 20);
                System.out.println(yList.get(d));
            }


            repaint();


        }
    }
}
