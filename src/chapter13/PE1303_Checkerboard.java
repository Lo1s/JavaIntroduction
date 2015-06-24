/**
 * 
 */
package chapter13;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 31. 7. 2014 2014 13:25:30 
 */
public class PE1303_Checkerboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1303_Checkerboard() {
		add(new Checkerboard());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1303_Checkerboard frame = new PE1303_Checkerboard();
		frame.setTitle("Checkerboard");
		frame.setSize(300, 300);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class Checkerboard extends JPanel {

	Checkerboard() {
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		int width = getWidth() / 8;
		int height = getHeight() / 8;
		int x = 0;
		int y = 0;
				
		
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if ((column + row) % 2 == 0) {
					g.setColor(Color.white);
				} else {
					g.setColor(Color.black);
				}
				g.fillRect(x, y, width, height);
				x += width;
			}
			x = 0;
			y += height;
		}
	}
}