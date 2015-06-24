/**
 * 
 */
package chapter13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 29. 7. 2014 2014 7:59:05 
 */
public class L1303_FigurePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int LINE = 1;
	public static final int RECTANGLE = 2;
	public static final int ROUND_RECTANGLE = 3;
	public static final int OVAL = 4;

	private int type = 1;
	private boolean filled = false;

	public L1303_FigurePanel() {

	}

	public L1303_FigurePanel(int type) {
		this.type = type;
	}

	public L1303_FigurePanel(int type, boolean filled) {
		this.type = type;
		this.filled = filled;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int width = getWidth();
		int height = getHeight();

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
			g.setColor(Color.BLACK);
			if (filled)
				g.fillOval((int)(0.1 * width), (int)(0.1 * height), (int)(0.8 * width), (int)(0.8 * height));
			else
				g.drawOval((int)(0.1 * width), (int)(0.1 * height), (int)(0.8 * width), (int)(0.8 * height));
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
