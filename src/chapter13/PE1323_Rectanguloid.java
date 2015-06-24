/**
 * 
 */
package chapter13;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 6. 8. 2014
 * 14:20:22
 */
public class PE1323_Rectanguloid extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1323_Rectanguloid() {
		add(new Rectanguloid());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1323_Rectanguloid();
		frame.setTitle("Exercise13_23");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class Rectanguloid extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int width = getWidth() / 2;
		int height = getHeight() / 4;
		
		g.drawRect(getWidth() / 2 - width / 2, getHeight() / 2 - height / 2, width, height);
		g.drawRect(getWidth() / 2 - (width / 2 - 30), getHeight() / 2 - (height / 2 + 30), width, height);
		g.drawLine(getWidth() / 2 - width / 2, getHeight() / 2 - height / 2, getWidth() / 2 - (width / 2 - 30), getHeight() / 2 - (height / 2 + 30));
		g.drawLine(getWidth() / 2 - width / 2, getHeight() / 2 - height / 2 + height, getWidth() / 2 - (width / 2 - 30), getHeight() / 2 - (height / 2 + 30) + height);
		g.drawLine(getWidth() / 2 + width / 2, getHeight() / 2 - height / 2, getWidth() / 2 + (width / 2 + 30), getHeight() / 2 - (height / 2 + 30));
		g.drawLine(getWidth() / 2 + width / 2, getHeight() / 2 + height / 2, getWidth() / 2 + (width / 2 + 30), getHeight() / 2 + (height / 2 - 30));
	}
}