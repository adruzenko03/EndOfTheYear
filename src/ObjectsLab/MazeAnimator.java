import javax.swing.*;
import java.awt.*;

public class MazeAnimator extends JFrame {

    private static final int DEFAULTMAZEDIM = 20;
    private static final int INDIVGRIDDIM = 24;
    private final int HEADINGHEIGHT = 56;

    public static void main(String[] args) {
        JFrame maze = new MazeAnimator();
        maze.setVisible(true);
    }

    public MazeAnimator() {

        MazeGenerator mz = new MazeGenerator();
        mz.generateMaze(DEFAULTMAZEDIM);

        setSize((2 * DEFAULTMAZEDIM + 2) * INDIVGRIDDIM , (2 * DEFAULTMAZEDIM + 1)* INDIVGRIDDIM + HEADINGHEIGHT);
        setTitle("fiveguys++");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new MazePanel(mz.getAsciiMaze()));
    }

    class MazePanel extends JPanel {

        private char[][] charMaze;

        public MazePanel(String mazeString) {

            String[] lines = mazeString.split("\n");
            charMaze = new char[lines.length][];
            for (int line = 0; line < lines.length; line++) {
                charMaze[line] = lines[line].toCharArray();
            }

        }

        protected void paintComponent(Graphics g) {

            for (int row = 0; row < charMaze.length; row++) {
                for (int col = 0; col < charMaze[row].length; col++) {
                    if (charMaze[row][col] == '#') {
                        g.setColor(Color.black);
                        g.fillRect(col * MazeAnimator.INDIVGRIDDIM, row * MazeAnimator.INDIVGRIDDIM, MazeAnimator.INDIVGRIDDIM, MazeAnimator.INDIVGRIDDIM);
                    }

                    else if (charMaze[row][col] == 'S') {
                        g.setColor(Color.green);
                        g.fillRect(col * MazeAnimator.INDIVGRIDDIM, row * MazeAnimator.INDIVGRIDDIM, MazeAnimator.INDIVGRIDDIM, MazeAnimator.INDIVGRIDDIM);
                    }

                    else if (charMaze[row][col] == 'E') {
                        g.setColor(Color.red);
                        g.fillRect(col * MazeAnimator.INDIVGRIDDIM, row * MazeAnimator.INDIVGRIDDIM, MazeAnimator.INDIVGRIDDIM, MazeAnimator.INDIVGRIDDIM);
                    }

                }

            }

        }

    }
}
