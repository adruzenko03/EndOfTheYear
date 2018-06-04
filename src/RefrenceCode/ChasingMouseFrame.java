package RefrenceCode;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChasingMouseFrame extends JFrame {

	public ChasingMouseFrame() {
		setTitle("Chase the Mouse!");

		add(new ChasingMousePanel());
	}

	public static void main(String[] args) {
		ChasingMouseFrame frame = new ChasingMouseFrame();
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

/**
 * The CheckedPanel is a panel of rectangles. The constructor determines the
 * number of rectangles used to subdivide the panel in each dimension. The top
 * left rectangle is red. The next rectangle is blue. The third rectangle is
 * green. The next rectangle is red. The pattern repeats, continuing across
 * rows.
 */
class ChasingMousePanel extends JPanel {
	int x = 0, y = 0;
	int radius = 10;
	protected ChasingMousePanel(){
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {

				x = e.getX();
				y = e.getY();
				repaint();
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1){
					radius += 2;
				}
				if (e.getButton() == MouseEvent.BUTTON3){
					radius -= 2;
				}
				repaint();
			}
		});
	}


	/** Draws the panel! */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
}