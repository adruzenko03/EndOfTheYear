package ObjectsLab;

import javax.swing.*;
import java.awt.*;

public class MazeAnimator extends JFrame {

    public static void main(String[] args) {


        MazeGenerator mz = new
        JFrame maze = new MazeAnimator();
        maze.setVisible(true);

    }

    public MazeAnimator() {

        setTitle("fiveguys++");

    }

    class MazePanel extends JPanel {

        private int dim;

        public MazePanel(int dim) {
            this.dim = dim;
        }

        protected void paintComponent(Graphics g) {

        }
    }
}


