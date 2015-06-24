/**
 * 
 */
package chapter13;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 12. 8. 2014
 * 20:04:54
 */
public class PE1330_ConnectTwoCircles extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1330_ConnectTwoCircles() {
		add(new ConnectTwoCircles());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1330_ConnectTwoCircles();
		frame.setTitle("Exercise13_30");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}

}

class ConnectTwoCircles extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int radius = 15;
		int x1 = (int)(Math.random() * (getWidth() - radius));
		int y1 = (int)(Math.random() * (getHeight() - radius));
		
		int x2 = (int)(Math.random() * (getWidth() - radius));
		int y2 = (int)(Math.random() * (getHeight() - radius));
		
		g.setColor(Color.green);
		g.fillOval(x1 - radius, y1 - radius, 2 * radius, 2 * radius);
		g.fillOval(x2 - radius, y2 - radius, 2 * radius, 2 * radius);
		g.setColor(Color.black);
	    double d = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	    int x11 = (int)(x1 - radius * (x1 - x2) / d);
	    int y11 = (int)(y1 - radius * (y1 - y2) / d);
	    int x21 = (int)(x2 + radius * (x1 - x2) / d);
	    int y21 = (int)(y2 + radius * (y1 - y2) / d);
	    g.drawLine(x11, y11, x21, y21);
		
		int distance = (int)Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		
		g.drawString(String.valueOf(distance), (x1 + x2) / 2, ((y1 + y2) / 2) + 30);
	}
	
}