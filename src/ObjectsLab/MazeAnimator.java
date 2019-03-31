package ObjectsLab;

import javax.swing.*;
import java.awt.*;

public class MazeAnimator extends JFrame {

    private final int DEFAULTMAZEDIM = 30;
    private final int INDIVGRIDDIM = 40;


    public static void main(String[] args) {

        JFrame maze = new MazeAnimator();
        maze.setVisible(true);

    }

    public MazeAnimator() {

        MazeGenerator mz = new MazeGenerator();
        mz.generateMaze(DEFAULTMAZEDIM);
        add(new MazePanel(mz.getMazeData()));
        setSize(INDIVGRIDDIM * DEFAULTMAZEDIM, INDIVGRIDDIM * DEFAULTMAZEDIM);
        setTitle("fiveguys++");

    }
    class MazePanel extends JPanel {

        private int dim;
        private Room[][] maze;

        public MazePanel(Room[][] maze) {
            dim = maze.length;
            this.maze = maze;
        }

        protected void paintComponent(Graphics g) {

        }
    }
}
