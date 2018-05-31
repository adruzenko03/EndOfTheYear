import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    int obWidth = rand.nextInt(getWidth() / 12) + 20;
    int obHeight = rand.nextInt(3 * getHeight());
    int x = rand.nextInt(getWidth() - obWidth);
    ObstacleRect[] possible = new ObstacleRect[10];

    public GameScreen() {

        timer.start();

    }


    protected void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);



    }


    public class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {



            repaint();
        }
    }
}