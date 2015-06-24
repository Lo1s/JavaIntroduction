/**
 * 
 */
package chapter13;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 *
 */
public class PE1307_TicTacToeBoard extends JFrame {

	int random = (int)(Math.random() * (2 - 1) + 1);

	public PE1307_TicTacToeBoard() {
		setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 9; i++)
			add(new TicTacToeBoard(hdR.mtd.getRandomNumber(0, 2)));
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1307_TicTacToeBoard();
		frame.setTitle("Exercise13_07");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class TicTacToeBoard extends JPanel {

	int i;
	/**
	 * 
	 */
	public TicTacToeBoard(int i) {
		this.i = i;
	}

	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		switch(i) {
		case 0: g.drawOval((int)(getWidth() * 0.1), (int)(getHeight() * 0.1), (int)(getWidth() * 0.8), (int)(getHeight() * 0.8));
		break;
		case 1: g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
		g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
		break;
		case 2: break;
		}
	}
}