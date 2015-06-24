/**
 * 
 */
package chapter13;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 6. 8. 2014
 * 11:11:34
 */
public class PE1321_TicTacToeImage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1321_TicTacToeImage() {
		setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 9; i++) {
			add(new TicTacToe());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1321_TicTacToeImage();
		frame.setTitle("Exercise13_21");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class TicTacToe extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		ImageIcon x = new ImageIcon("C://Java//site//image//x.gif");
		ImageIcon o = new ImageIcon("C://Java//site//image//o.gif");
		
		Image xImage = x.getImage();
		Image oImage = o.getImage();
		Image image = xImage;
		
		int random = hdR.mtd.getRandomNumber(1, 2);
		
		if (random == 1)
			image = xImage;
		else
			image = oImage;
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
}