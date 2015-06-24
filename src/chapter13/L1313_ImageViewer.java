
package chapter13;

import javax.swing.JPanel;
import java.awt.*;


/**
 * @author jslapnicka
 * @Date & @Time 30. 7. 2014 2014 14:25:41 
 */
public class L1313_ImageViewer extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private java.awt.Image image;
	private boolean stretched = true;
	private int xCoordinate;
	private int yCoordinate;
	
	public L1313_ImageViewer() {
		
	}
	
	public L1313_ImageViewer(Image image) {
		this.image = image;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (image != null)
			if (isStretched())
				g.drawImage(image, xCoordinate, yCoordinate, getWidth(), getHeight(), this);
			else
				g.drawImage(image, xCoordinate, yCoordinate, this);
	}

	/**
	 * @return the image
	 */
	public java.awt.Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(java.awt.Image image) {
		this.image = image;
		repaint();
	}

	/**
	 * @return the stretched
	 */
	public boolean isStretched() {
		return stretched;
	}

	/**
	 * @param stretched the stretched to set
	 */
	public void setStretched(boolean stretched) {
		this.stretched = stretched;
		repaint();
	}

	/**
	 * @return the xCoordinate
	 */
	public int getxCoordinate() {
		return xCoordinate;
	}

	/**
	 * @param xCoordinate the xCoordinate to set
	 */
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
		repaint();
	}

	/**
	 * @return the yCoordinate
	 */
	public int getyCoordinate() {
		return yCoordinate;
	}

	/**
	 * @param yCoordinate the yCoordinate to set
	 */
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
		repaint();
	}
	
	
	
}


