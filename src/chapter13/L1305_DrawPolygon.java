/**
 * 
 */
package chapter13;

import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 29. 7. 2014 2014 12:26:48 
 */
public class L1305_DrawPolygon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public L1305_DrawPolygon() {
		setTitle("DrawPolygon");
		add(new PolygonsPanel());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1305_DrawPolygon frame = new L1305_DrawPolygon();
		frame.setTitle("DrawPolygon");
		frame.setSize(200, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class PolygonsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		
		int radius = (int)(Math.min(getWidth(), getHeight() * 0.4));
		
		Polygon polygon = new Polygon();
		
		polygon.addPoint(xCenter + radius, yCenter);
		polygon.addPoint((int)(xCenter + radius * Math.cos(2 * Math.PI / 6)), (int)(yCenter - radius * Math.sin(2 * Math.PI / 6)));
		polygon.addPoint((int)(xCenter + radius * Math.cos(2 * 2 * Math.PI / 6)), (int)(yCenter - radius * Math.sin(2 * 2 * Math.PI / 6)));
		polygon.addPoint((int)(xCenter + radius * Math.cos(3 * 2 * Math.PI / 6)), (int)(yCenter - radius * Math.sin(3 * 2 * Math.PI / 6)));
		polygon.addPoint((int)(xCenter + radius * Math.cos(4 * 2 * Math.PI / 6)), (int)(yCenter - radius * Math.sin(4 * 2 * Math.PI / 6)));
		polygon.addPoint((int)(xCenter + radius * Math.cos(5 * 2 * Math.PI / 6)), (int)(yCenter - radius * Math.sin(5 * 2 * Math.PI / 6)));
		
		g.drawPolygon(polygon);
	}
	
}