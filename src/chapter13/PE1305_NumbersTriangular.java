/**
 * 
 */
package chapter13;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 1. 8. 2014 2014 14:08:45 
 */
public class PE1305_NumbersTriangular extends JFrame {

	private static final long serialVersionUID = 1L;

	public PE1305_NumbersTriangular() {
		add(new TriangularNumbers());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1305_NumbersTriangular frame = new PE1305_NumbersTriangular();
		frame.setTitle("Exercise13_05");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class TriangularNumbers extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int row = 30;
		for (int i = 1; i <= 11; i++) {
			for (int j = 1; j <= i; j++) {
				g.setFont(new Font("TimesRoman", Font.BOLD, 15));
				g.drawString(j + "", 10 + (j * 18), row);
			}
			row += 18;
		}
	}
}