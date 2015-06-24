/**
 * 
 */
package chapter13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 1. 8. 2014 2014 14:49:24 
 */
public class PE1306_ImproveFigurePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int LINE = 1;
	public static final int RECTANGLE = 2;
	public static final int ROUND_RECTANGLE = 3;
	public static final int OVAL = 4;
	public static final int ARC = 5;
	public static final int POLYGON = 6;

	private int type = 1;
	private boolean filled = false;

	public PE1306_ImproveFigurePanel() {

	}

	public PE1306_ImproveFigurePanel(int type) {
		this.type = type;
	}

	public PE1306_ImproveFigurePanel(int type, boolean filled) {
		this.type = type;
		this.filled = filled;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int width = getWidth();
		int height = getHeight();
		int xCenter = getSize().width / 2;
		int yCenter = getSize().height / 2;
		int radius = (int)(Math.min(getSize().width, getSize().height) * 0.4);

		int x = xCenter - radius;
		int y = yCenter - radius;

		Polygon polygon = new Polygon();


		switch(type) {
		case LINE: // Display two cross lines
			g.setColor(Color.black);
			g.drawLine(10, 10, width - 10,height - 10);
			g.drawLine(width - 10, 10, 10, height - 10);
			break;
		case RECTANGLE: // Display a rectangle
			g.setColor(Color.blue);
			if (filled)
				g.fillRect((int)(0.1 * width), (int)(0.1 * height), (int)(0.8 * width), (int)(0.8 * height));
			else
				g.drawRect((int)(0.1 * width), (int)(0.1 * height), (int)(0.8 * width), (int)(0.8 * height));
			break;
		case ROUND_RECTANGLE: // Display a round-cornered rectangle
			g.setColor(Color.RED);
			if (filled)
				g.fillRoundRect((int)(0.1 * width), (int)(0.1 * height), (int)(0.8 * width), (int)(0.8 * height), 20, 20);
			else
				g.drawRoundRect((int)(0.1 * width), (int)(0.1 * height), (int)(0.8 * width), (int)(0.8 * height), 20, 20);
			break;
		case OVAL: // Display an oval
			g.drawOval(5, 5, getWidth()/2-10, getHeight()/2-10);
			g.setColor(Color.red);
			g.drawOval(getWidth()/2+5, 5, getWidth()/2-10, getHeight()/2-10);
			g.setColor(Color.yellow);
			g.fillOval(5, getHeight()/2+5, getWidth()/2-10,
					getHeight()/2-10);
			g.setColor(Color.orange);
			g.fillOval(getWidth()/2+5, getHeight()/2+5, getWidth()/2-10,
					getHeight()/2-10);
		case ARC: // Display an arc
			g.setColor(Color.BLACK);
			if (filled)
				g.fillArc(x, y, 2*radius, 2*radius, 0, 30);
			g.fillArc(x, y, 2*radius, 2*radius, 90, 30);
			g.fillArc(x, y, 2*radius, 2*radius, 180, 30);
			g.fillArc(x, y, 2*radius, 2*radius, 270, 30);
			break;
		case POLYGON: // Display a polygon
			polygon.addPoint(xCenter + radius, yCenter);
			polygon.addPoint((int)(xCenter + radius*Math.cos(2*Math.PI/6)),
					(int)(yCenter - radius*Math.sin(2*Math.PI/6)));
			polygon.addPoint((int)(xCenter + radius*Math.cos(2*2*Math.PI/6)),
					(int)(yCenter - radius*Math.sin(2*2*Math.PI/6)));
			polygon.addPoint((int)(xCenter + radius*Math.cos(3*2*Math.PI/6)),
					(int)(yCenter - radius*Math.sin(3*2*Math.PI/6)));
			polygon.addPoint((int)(xCenter + radius*Math.cos(4*2*Math.PI/6)),
					(int)(yCenter - radius*Math.sin(4*2*Math.PI/6)));
			polygon.addPoint((int)(xCenter + radius*Math.cos(5*2*Math.PI/6)),
					(int)(yCenter - radius*Math.sin(5*2*Math.PI/6)));
			// Draw the polygon
			g.drawPolygon(polygon);
		}
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the filled
	 */
	public boolean isFilled() {
		return filled;
	}

	/**
	 * @param filled the filled to set
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	@Override // Specify preferred size
	public Dimension getPreferredSize() {
		return new Dimension(80, 80);
	}	
}
