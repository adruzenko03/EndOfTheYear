import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

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

    Timer timer = new Timer(200, new TimerListener());

    Random rand = new Random();
    int vel = rand.nextInt(3);
    int y = 0;
    int x = 0;

    ObstacleRect[] possible = new ObstacleRect[];

    public GameScreen() {

        timer.start();

    }


    protected void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);



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



            repaint();
        }
    }
}