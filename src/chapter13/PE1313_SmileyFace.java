/**
 * 
 */
package chapter13;

import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 5. 8. 2014
 * 14:49:57
 */
public class PE1313_SmileyFace extends JFrame {

	public PE1313_SmileyFace() {
		add(new SmileyFace());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1313_SmileyFace();
		frame.setTitle("Exercise13_13");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class SmileyFace extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;

		int radius = (int)(Math.min(getWidth(), getHeight() * 0.4));

		// Head
		g.drawOval(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);

		// Nose
		g.drawLine(xCenter - 20, yCenter + 20, xCenter + 20, yCenter + 20);
		g.drawLine(xCenter - 20, yCenter + 20, xCenter, yCenter - 20);
		g.drawLine(xCenter + 20, yCenter + 20, xCenter, yCenter - 20);

		// Eyes
		g.drawOval(xCenter - 50, yCenter - 50, 35, 20);
		g.fillOval(xCenter - 40, yCenter - 48, 15, 15);

		g.drawOval(xCenter + 15, yCenter - 50, 35, 20);
		g.fillOval(xCenter + 25, yCenter - 48, 15, 15);

		// Mouth

		Polygon p = new Polygon();
		double scaleFactor = 0.01;
		for (int x = -40; x <= 40; x++) {
			p.addPoint(x + 140, 200 - (int)(scaleFactor * x * x));
		}
		
		g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
	}
}
