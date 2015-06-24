/**
 * 
 */
package chapter12;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 25. 7. 2014 2014 12:23:27 
 */
public class PE1210_Chessboard extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public PE1210_Chessboard() {
		setLayout(new GridLayout(8, 8));
		
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if ((column + row) % 2 == 0)
					add(new JButton()).setBackground(Color.white);
				else
					add(new JButton()).setBackground(Color.black);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1210_Chessboard();
		frame.setTitle("Chessboard");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
