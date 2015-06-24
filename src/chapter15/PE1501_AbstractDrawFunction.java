/**
 * 
 */
package chapter15;

import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 4. 9. 2014 2014 10:02:29 
 */
public abstract class PE1501_AbstractDrawFunction extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Polygon to hold the points */
	private Polygon p = new Polygon();
	
	protected PE1501_AbstractDrawFunction() {
		// TODO Auto-generated constructor stub
		drawFunction();
	}
	
	/** Return the y-coordinate */
	abstract double f(double x);
	
	/** Obtain points for x-coordinates 100, 101......300 */
	public void drawFunction() {
		for (int x = -100; x <= 100; x++) {
			p.addPoint(x + 125, 125 - (int)f(x));	
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawLine(10, 125, 275, 125);
        g.drawLine(125, 30, 125, 200);
        g.drawLine(275, 125, 255, 115);
        g.drawLine(275, 125, 255, 135);
        g.drawLine(125, 30, 115, 50);
        g.drawLine(125, 30, 135, 50);
        g.drawString("X", 255, 95);
        g.drawString("Y", 145, 40);
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
	}
}
