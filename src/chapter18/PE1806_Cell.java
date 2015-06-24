/**
 * 
 */
package chapter18;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;


/**
 * @author jslapnicka
 * @Date & @Time 7. 10. 2014 2014 16:14:55 
 */
@SuppressWarnings("serial")
public class PE1806_Cell extends JPanel {
	// Token used for this cell
	// Token used for this cell
	private char token = ' ';
	PE1806_TicTacToe parent;
	
	public PE1806_Cell(PE1806_TicTacToe parent) {
		// TODO Auto-generated constructor stub
		this.parent = parent;
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
			if (token == ' ' && parent.whoseTurn != ' ') {
				setToken(parent.whoseTurn);

				// Check game status
				if (parent.isWon(parent.whoseTurn)) {
					parent.jlblStatus.setText(parent.whoseTurn + " won! The game is over");
					parent.whoseTurn = ' '; // Game is over
				} else if (parent.isFull()) {
					parent.jlblStatus.setText("Draw ! The Game is over");
					parent.whoseTurn = ' '; // Game is over
				} else {
					// Change the turn
					parent.whoseTurn = (parent.whoseTurn == 'X') ? 'O' : 'X';
					// Display whose turn
					parent.jlblStatus.setText(parent.whoseTurn + "'s turn");
				}
			}
		}
	}
}