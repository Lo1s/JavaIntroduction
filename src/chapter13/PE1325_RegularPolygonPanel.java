/**
 * 
 */
package chapter13;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 6. 8. 2014
 * 22:54:10
 */
public class PE1325_RegularPolygonPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1325_RegularPolygonPanel() {
		setLayout(new GridLayout(1, 6));
		for (int i = 5; i <= 10; i++) {
			add(new RegularPolygonPanel(i));
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1325_RegularPolygonPanel();
		frame.setTitle("Exercise13_25");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class RegularPolygonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numberOfSides;

	public RegularPolygonPanel() {

	}

	public RegularPolygonPanel(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	public void setNumberOfSides(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}


	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Polygon p = new Polygon();

		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int)(Math.min(getWidth(), getHeight() * 0.4));

		for (int i = 1; i <= numberOfSides; i++) {
			p.addPoint((int)(xCenter + radius * Math.cos(i * 2 * Math.PI / numberOfSides)), 
					(int)(yCenter - radius * Math.sin(i * 2 * Math.PI / numberOfSides)));
		}
		g.drawPolygon(p);
	}
}