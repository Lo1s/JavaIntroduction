/**
 * 
 */
package chapter13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 *
 */
public class PE1312_SinCosFunction extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PE1312_SinCosFunction() {
		// TODO Auto-generated constructor stub
		add(new SinCosFunction());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1312_SinCosFunction();
		frame.setTitle("Exercise13_12");
		frame.setSize(420, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class SinCosFunction extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Polygon p = new Polygon();

		for (int x = -170; x <= 170; x++) {
			p.addPoint(x + 200, 100 - (int)(50 * Math.sin((x / 100.0) * 2 * Math.PI)));
		}
		
		g.setColor(Color.RED);
		g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
		
		Polygon p2 = new Polygon();
		
		for (int x = -170; x <= 170; x++) {
			p2.addPoint(x + 200, 100 - (int)(50 * Math.cos((x / 100.0) * 2 * Math.PI)));
		}
		
		g.setColor(Color.BLUE);
		g.drawPolyline(p2.xpoints, p2.ypoints, p2.npoints);
		
		int xCenter = 200;
		int yCenter = 100;
		
		g.setColor(Color.BLACK);
		g.drawLine(10, yCenter, 390, yCenter);
		
		g.drawLine(xCenter, 180, xCenter, 30);
		
		g.drawLine(390, yCenter, 380, yCenter - 10);
		
		g.drawLine(390, yCenter, 380, yCenter + 10);
		
		g.drawLine(xCenter, 30, xCenter - 10, 40);
		g.drawLine(xCenter, 30, xCenter + 10, 40);
		
		g.drawString("X", 390, yCenter - 20);
		g.drawString("Y", xCenter + 20, 30);
		
		String pi = "\u03c0";
		g.drawString(-2 + pi, 100, 120);
		g.drawString(2 + pi, 300, 120);
		g.drawString("-" + pi, 150, 120);
		g.drawString(pi, 250, 120);
		g.drawString("0", 190, 120);
		
	}
}