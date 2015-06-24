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
 * 6. 8. 2014
 * 15:44:37
 */
public class PE1324_BeanMachine extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1324_BeanMachine() {
		add(new BeanMachine());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1324_BeanMachine();
		frame.setTitle("Exercise13_24");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class BeanMachine extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int xCenter = getWidth() / 2;
		int widthEntrance = getWidth() / 20;
		int heightTube = getHeight() - 80;
		
		// Entrance
		g.drawLine(xCenter - widthEntrance / 2, getHeight() / 10, xCenter - widthEntrance / 2, getHeight() / 6);
		g.drawLine(xCenter + widthEntrance / 2, getHeight() / 10, xCenter + widthEntrance / 2, getHeight() / 6);
		// Tube
		g.drawLine(xCenter - widthEntrance / 2, getHeight() / 6, getWidth() / 5, heightTube);
		g.drawLine(xCenter + widthEntrance / 2, getHeight() / 6, getWidth() - (getWidth() / 5), heightTube);
		// Bottom part
		g.drawLine(getWidth() / 5, heightTube, getWidth() / 5, getHeight() - (getHeight() / 20));
		g.drawLine(getWidth() - (getWidth() / 5), heightTube, getWidth() - (getWidth() / 5), getHeight() - (getHeight() / 20));
		g.drawLine(getWidth() / 5, getHeight() - (getHeight() / 20), getWidth() - (getWidth() / 5), getHeight() - (getHeight() / 20));
		// Separators
		int widthBottom = (getWidth() - (getWidth() / 5)) - (getWidth() / 5);
		int startingPoint = getWidth() / 5;
		for (int i = 7; i >= 1; i--) {
			startingPoint += widthBottom / 8;
			g.drawLine(startingPoint, heightTube, startingPoint, getHeight() - (getHeight() / 20));
		}
		// Bumpers
		startingPoint = getWidth() / 5;
		int distance = getWidth() / 5;
		g.setColor(Color.GREEN);
		for (int row = 7; row >= 1; row--) {
			for (int column = 1; column <= row; column++) {
				distance += widthBottom / 8;
				g.fillOval(distance - 5, heightTube - 5, 10, 10);
			}
			startingPoint += ((widthBottom / 8) / 2);
			distance = startingPoint;
			heightTube -= 30;
		}
		
	}
	
}