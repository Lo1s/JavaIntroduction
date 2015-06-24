/**
 * 
 */
package chapter13;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 *
 */
public class PE1308_Octagon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1308_Octagon() {
		add(new Octagon());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1308_Octagon();
		frame.setTitle("Exercise13_08");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class Octagon extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int[] xPoints = new int[8];
		int[] yPoints = new int[8];
		
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
		
		xPoints[0] = xCenter + radius;
		xPoints[1] = (int)(xCenter + radius * Math.cos(2 * Math.PI / 8));
		xPoints[2] = (int)(xCenter + radius * Math.cos(2 * 2 * Math.PI / 8));
		xPoints[3] = (int)(xCenter + radius * Math.cos(3 * 2 * Math.PI / 8));
		xPoints[4] = (int)(xCenter + radius * Math.cos(4 * 2 * Math.PI / 8));
		xPoints[5] = (int)(xCenter + radius * Math.cos(5 * 2 * Math.PI / 8));
		xPoints[6] = (int)(xCenter + radius * Math.cos(6 * 2 * Math.PI / 8));
		xPoints[7] = (int)(xCenter + radius * Math.cos(7 * 2 * Math.PI / 8));
		
		yPoints[0] = yCenter;
		yPoints[1] = (int)(yCenter - radius * Math.sin(2 * Math.PI / 8));
		yPoints[2] = (int)(yCenter - radius * Math.sin(2 * 2 * Math.PI / 8));
		yPoints[3] = (int)(yCenter - radius * Math.sin(3 * 2 * Math.PI / 8));
		yPoints[4] = (int)(yCenter - radius * Math.sin(4 * 2 * Math.PI / 8));
		yPoints[5] = (int)(yCenter - radius * Math.sin(5 * 2 * Math.PI / 8));
		yPoints[6] = (int)(yCenter - radius * Math.sin(6 * 2 * Math.PI / 8));
		yPoints[7] = (int)(yCenter - radius * Math.sin(7 * 2 * Math.PI / 8));
		
		g.drawPolygon(xPoints, yPoints, 8);
		
	}
}
