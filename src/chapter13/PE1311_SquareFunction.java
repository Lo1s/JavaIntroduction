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
 *
 */
public class PE1311_SquareFunction extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PE1311_SquareFunction() {
		add(new SquareFunction());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1311_SquareFunction();
		frame.setTitle("Exercise13_11");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class SquareFunction extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Polygon polygon = new Polygon();
		
		double scaleFactor = 0.01;
		for (int x = -100; x <= 100; x++) {
			polygon.addPoint(x + 200, 200 - (int)(scaleFactor * x * x));
		}
		// Draw the function
		g.drawPolyline(polygon.xpoints, polygon.ypoints, polygon.npoints);
		// Draw the XY 
		g.drawLine(100, (100 + (int)(scaleFactor * 100 * 100)), 300, (100 + (int)(scaleFactor * 100 * 100)));
		g.drawLine(200, 100, 200, 220);
		// Finish the arrow
		g.drawLine(200, 100, 190, 110);
		g.drawLine(200, 100, 210, 110);
		
		g.drawLine(300, (100 + (int)(scaleFactor * 100 * 100)), 290, (100 + (int)(scaleFactor * 100 * 100)) - 10);
		g.drawLine(300, (100 + (int)(scaleFactor * 100 * 100)), 290, (100 + (int)(scaleFactor * 100 * 100)) + 10);
		
		// Draw the X and Y strings
		g.drawString("Y", 220, 100);
		g.drawString("X", 300, (100 + (int)(scaleFactor * 100 * 100)) - 20);
		
	}
}