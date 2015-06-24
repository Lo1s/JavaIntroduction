/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.event.MouseEvent;

/**
 * @author jslapnicka
 * @Date & @Time 6. 10. 2014 2014 15:28:33 
 */
@SuppressWarnings("serial")
public class L1810_TicTacToe extends JApplet {

	private char whoseTurn = 'X';

	// Create and initialize cells
	private Cell[][] cells = new Cell[3][3];

	// Create and initialize status label 
	private JLabel jlblStatus = new JLabel("X's turn to play");

	/** Initialize UI */
	public L1810_TicTacToe() {
		// Panel p to hold cells
		JPanel p = new JPanel(new GridLayout(3, 3, 0, 0));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				p.add(cells[i][j] = new Cell());
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

	public class Cell extends JPanel {
		// Token used for this cell
		private char token = ' ';

		public Cell() {
			// TODO Auto-generated constructor stub
			setBorder(new LineBorder(Color.BLACK, 1)); // Set cell's border
			addMouseListener(new MyMouseListener()); // Register listener
		}

		/** Return token */
		public char getToken() {
			return token;
		}

		/** Set a new token */
		public void setToken(char c) {
			token = c;
			repaint();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (token == 'X') {
				g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
				g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
			} else if (token == 'O') {
				g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
			}
		}

		private class MyMouseListener extends MouseAdapter {
			@Override /** Handle mouse click on a cell */
			public void mouseClicked(MouseEvent e) {
				// If a cell is empty and the game is not over
				if (token == ' ' && whoseTurn != ' ') {
					setToken(whoseTurn);

					// Check game status
					if (isWon(whoseTurn)) {
						jlblStatus.setText(whoseTurn + " won! The game is over");
						whoseTurn = ' '; // Game is over
					} else if (isFull()) {
						jlblStatus.setText("Draw ! The Game is over");
						whoseTurn = ' '; // Game is over
					} else {
						// Change the turn
						whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
						// Display whose turn
						jlblStatus.setText(whoseTurn + "'s turn");
					}
				}
			}
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.add(new L1810_TicTacToe());
		frame.setTitle("TicTacToe");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
