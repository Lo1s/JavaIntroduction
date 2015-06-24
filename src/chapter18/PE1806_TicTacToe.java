/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;


import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;




/**
 * @author jslapnicka
 * @Date & @Time 7. 10. 2014 2014 16:14:35 
 */
@SuppressWarnings("serial")
public class PE1806_TicTacToe extends JApplet {

	char whoseTurn = 'X';

	// Create and initialize cells
	private PE1806_Cell[][] cells = new PE1806_Cell[3][3];

	// Create and initialize status label 
	JLabel jlblStatus = new JLabel("X's turn to play");

	/** Initialize UI */
	public PE1806_TicTacToe() {
		// Panel p to hold cells
		JPanel p = new JPanel(new GridLayout(3, 3, 0, 0));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				p.add(cells[i][j] = new PE1806_Cell(this));
			}
		}

		// Set line borders on the cells' panel and the status label
		p.setBorder(new LineBorder(Color.red, 1));
		jlblStatus.setBorder(new LineBorder(Color.yellow, 1));

		// Place the panel and the label for the applet
		add(p, BorderLayout.CENTER);
		add(jlblStatus, BorderLayout.SOUTH);
	}

	/** Determine whether the cells are all occupied */
	public boolean isFull() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (cells[i][j].getToken() == ' ')
					return false;
		return true;
	}

	/** Determine whether the player with the specified tokens wins */
	public boolean isWon(char token) {
		// Check rows
		for (int i = 0; i < 3; i++)
			if ((cells[i][0].getToken() == token)
					&& (cells[i][1].getToken() == token)
					&& (cells[i][2].getToken() == token)) {
				return true;
			}
		// Check columns
		for (int j = 0; j < 3; j++)
			if ((cells[0][j].getToken() == token)
					&& (cells[1][j].getToken() == token)
					&& (cells[2][j].getToken() == token)) {
				return true;
			}
		// Check major diagonal
		if ((cells[0][0].getToken() == token)
				&& (cells[1][1].getToken() == token)
				&& (cells[2][2].getToken() == token)) {
			return true;
		}
		// Check sub diagonal
		if ((cells[0][2].getToken() == token)
				&& (cells[1][1].getToken() == token)
				&& (cells[2][0].getToken() == token)) {
			return true;
		}

		return false;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.add(new PE1806_TicTacToe());
		frame.setTitle("Exercise18_06");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
