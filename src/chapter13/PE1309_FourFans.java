/**
 * 
 */
package chapter13;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 *
 */
public class PE1309_FourFans extends JFrame {

	public PE1309_FourFans() {
		setLayout(new GridLayout(2, 2));
		add(new FourFans());
		add(new FourFans());
		add(new FourFans());
		add(new FourFans());
		
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
		JFrame frame = new PE1309_FourFans();
		frame.setTitle("Exercise13_09");
		frame.setSize(300, 300);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}

class FourFans extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
		
		int x = xCenter - radius;
		int y = yCenter - radius;
		
		g.fillArc(x, y, 2 * radius, 2 * radius, 0, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, 90, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, 180, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, 270, 30);
		
		g.drawOval(x - 5, y - 5, 2 * radius + 10, 2 * radius + 10);
	}
}