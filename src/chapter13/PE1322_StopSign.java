/**
 * 
 */
package chapter13;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 6. 8. 2014
 * 11:29:23
 */
public class PE1322_StopSign extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1322_StopSign() {
		StopSign stop = new StopSign();
		stop.setFont(new Font("TimesRoman", Font.BOLD, 50));
		add(stop);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1322_StopSign();
		frame.setTitle("Exercise13_22");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class StopSign extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int)(Math.min(getWidth(), getHeight() * 0.4));		
		
		Polygon polygon = new Polygon();
		

	    // Add points to the polygon
	    for (int i = 0; i < 8; i++) {
	      polygon.addPoint((int)(xCenter + radius *
	        Math.cos(i * 2 * Math.PI / 8 + 2 * Math.PI / 16)), (int)(yCenter - radius *
	        Math.sin(i * 2 * Math.PI / 8 + 2 * Math.PI / 16)));
	    }

		g.setColor(Color.RED);
		g.fillPolygon(polygon);
		
		FontMetrics fm = g.getFontMetrics();
		
		int stringWidth = fm.stringWidth("STOP");
		int stringAscent = fm.getAscent();
		int xCoordinate = getWidth() / 2 - stringWidth / 2;
		int yCoordinate = getHeight() / 2 + stringAscent / 2;
		
		g.setColor(Color.WHITE);
		g.drawString("STOP", xCoordinate, yCoordinate);
	}
}
