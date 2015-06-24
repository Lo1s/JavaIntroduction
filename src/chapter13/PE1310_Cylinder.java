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
public class PE1310_Cylinder extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PE1310_Cylinder() {
		add(new Cylinder());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1310_Cylinder();
		frame.setTitle("Exercise13_10");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class Cylinder extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int)(Math.min(getWidth(), getHeight() * 0.4));
		
		int x = xCenter - radius;
		int y = yCenter - radius;
		
		g.drawOval(x, y, 2 * radius, radius - 20);
		g.drawOval(x, y + 130, 2 * radius, radius - 20);
		g.drawLine(x, y + 40, x, y + 170);
		g.drawLine(xCenter + radius, y + 40, xCenter + radius, y + 170);
	}
}
