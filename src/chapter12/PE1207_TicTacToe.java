/**
 * 
 */
package chapter12;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author jslapnicka
 * @Date & @Time 25. 7. 2014 2014 7:54:59 
 */
public class PE1207_TicTacToe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1207_TicTacToe() {

		setLayout(new GridLayout(3, 3));
	
		ImageIcon o = new ImageIcon("C://Java//site//image//o.gif");
		ImageIcon x = new ImageIcon("C://Java//site//image//x.gif");

		for (int i = 0; i < 9; i++) {
			if ((int)(Math.random() * (2 - 0)) == 1)
				add(new JLabel(x));
			else
				add(new JLabel(o));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1207_TicTacToe();
		frame.setTitle("TicTacToe");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
