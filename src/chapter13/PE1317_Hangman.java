/**
 * 
 */
package chapter13;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 5. 8. 2014
 * 20:46:10
 */
public class PE1317_Hangman extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1317_Hangman() {
		add(new Hangman());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1317_Hangman();
		frame.setTitle("Exercise13_17");
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class Hangman extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		// Piadestal
		g.drawArc(20, getHeight() - 40, 80, 50, 0, 180);
		
		// Main support
		g.drawLine(60, getHeight() - 40, 60, 30);
		
		// UP support
		g.drawLine(60, 30, 180, 30);
		
		// Head support
		g.drawLine(180, 30, 180, 60);
		
		// Head
		g.drawOval(160, 60, 40, 40);
		
		// Body
		g.drawLine(180, 100, 180, 220);
		
		// Hands
		g.drawLine(180, 100, 130, 150);
		g.drawLine(180, 100, 230, 150);
		
		// Legs
		g.drawLine(180, 220, 130, 270);
		g.drawLine(180, 220, 230, 270);
	}
}