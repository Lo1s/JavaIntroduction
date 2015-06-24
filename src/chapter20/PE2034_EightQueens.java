/**
 * 
 */
package chapter20;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 3. 12. 2014 2014 11:23:53 
 */
@SuppressWarnings("serial")
public class PE2034_EightQueens extends JApplet {

	private DrawBoard drawBoard = new DrawBoard();
	private EightQueens eightQueens = new EightQueens();
	private Image queen = (new ImageIcon("C:/Java/site/image/queen.jpg").getImage());

	public PE2034_EightQueens() {
		// TODO Auto-generated constructor stub
		eightQueens.placeQueens(0, 0);
		add(drawBoard);
	}

	class EightQueens {

		private int[][] board = new int[8][8];
		private int countQueens = 0;
		public EightQueens() {
			// TODO Auto-generated constructor stub

		}

		public void placeQueens(int row, int column) {
			if (countQueens != 8) {
				if (column == 8) {
					row--;
					for (int i = 0; i < board.length; i++) {
						if (board[row][i] == 1) {
							removeQueen(row, i);
							placeQueens(row, ++i);
							break;
						}
					}
				}

				if (row != 8 && column != 8 && freePosition(board, row, column)) {
					addQueen(row, column);
					placeQueens(++row, 0);
				} else
					placeQueens(row, ++column);
			}

		}

		public void addQueen(int row, int column) {
			board[row][column] = 1;
			countQueens++;
			if (countQueens == 8)
				repaint();
		}

		public void removeQueen(int row, int column) {
			board[row][column] = 0;
			countQueens--;
		}

		// Check if there is a queen in the same row, column or diagonal
		public boolean freePosition(int[][] board, int rowInput, int columnInput) {

			// Check the row
			// LEFT
			for (int column = columnInput; column >= 0; column--) {
				if (board[rowInput][column] == 1) {
					return false;
				}
			}

			// RIGHT
			for (int column = columnInput; column < board[0].length; column++) {
				if (board[rowInput][column] == 1) {
					return false;
				}
			}

			// Check the column
			// UP
			for (int row = rowInput;  row >= 0; row--) {
				if (board[row][columnInput] == 1) {
					return false;
				}
			}
			// DOWN
			for (int row = rowInput; row < board.length; row++) {
				if (board[row][columnInput] == 1) {
					return false;
				}
			}

			// Check the major diagonal
			// UP
			for (int row = rowInput, column = columnInput; row >= 0 && column >= 0; row--, column--) {
				if (board[row][column] == 1) {
					return false;
				}
			}
			// DOWN
			for (int row = rowInput, column = columnInput; row < board.length && column < board[row].length; row++, column++) {
				if (board[row][column] == 1) {
					return false;
				}
			}

			// Check the minor diagonal
			// UP
			for (int row = rowInput, column = columnInput; row >= 0 && column < board[row].length; row--, column++) {
				if (board[row][column] == 1) {
					return false;
				}
			}
			// DOWN
			for (int row = rowInput, column = columnInput; row < board.length && column >= 0; row++, column--) {
				if (board[row][column] == 1) {
					return false;
				}
			}

			return true;
		}

		// Displays the grid
		public void displayGrid(int[][] array) {

			// Print the column of the grid
			String token = "Q";
			System.out.print("      ");
			for (int i = 0; i < array.length; i++) {
				if (i < 100)
					System.out.print("[" + " " + i + "]");
				else
					System.out.print("[" + i + "]");
			}
			// Print line
			System.out.print("\n     ");
			for (int i = 0; i < array.length; i++) {
				if (i < array.length - 1)
					System.out.print("----");
				else
					System.out.print("-----\n");
			}
			// Print the row of the grid
			for (int row = 0; row < array.length; row++) {
				System.out.print("[" + row + "]  |");
				for (int column = 0; column < array.length; column++) {
					if (array[row][column] != 1) {
						System.out.printf("%4s", "|");
					} else
						System.out.print(" " + token + " |");
				}
				// Print line
				System.out.print("\n     ");
				for (int i = 0; i < array.length; i++) {
					if (i < array.length - 1)
						System.out.print("----");
					else
						System.out.print("-----\n");
				}
			}
		}

	}

	class DrawBoard extends JPanel {

		private int vGap;
		private int hGap;

		@Override
		protected void paintComponent(Graphics g) {

			hGap = getWidth() / 8;
			vGap = getHeight() / 8;

			super.paintComponent(g);

			// Draw the board
			for (int i = 1; i < 8; i++) {
				// Horizontal
				g.drawLine(0, vGap * i, getWidth(), vGap * i);
				// Vertical
				g.drawLine(hGap * i, 0, hGap * i, getHeight());
			}
			eightQueens.displayGrid(eightQueens.board);
				for (int i = 0; i < eightQueens.board.length; i++) {
					for (int j = 0; j < eightQueens.board.length; j++) {
						if (eightQueens.board[i][j] == 1)
							g.drawImage(queen, j * hGap + 2, i * vGap + 2, hGap - 4, vGap - 4, this);
					}
				}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE2034_EightQueens applet = new PE2034_EightQueens();

		frame.add(applet);
		frame.setTitle("Exercise20_34");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
