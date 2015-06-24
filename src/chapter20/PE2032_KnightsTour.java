package chapter20;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * @author jslapnicka
 * @Date & @Time 27. 11. 2014 2014 16:21:20 
 */
@SuppressWarnings("serial")
public class PE2032_KnightsTour extends JApplet{


	private JLabel jlblRow = new JLabel("Specify a starting position, row: ");
	private JTextField jtfRow = new JTextField(2);
	private JLabel jlblColumn = new JLabel("column: ");
	private JTextField jtfColumn = new JTextField(2);
	private JButton jbtSearch = new JButton("Search");
	private JPanel jpSettings = new JPanel();
	private ChessBoard chessBoard = new ChessBoard();
	private DrawBoard drawBoard = new DrawBoard();
	private long startTime;
	private long endTime;

	public PE2032_KnightsTour() {
		// TODO Auto-generated constructor stub

		jpSettings.add(jlblRow);
		jpSettings.add(jtfRow);
		jpSettings.add(jlblColumn);
		jpSettings.add(jtfColumn);
		jpSettings.add(jbtSearch);

		drawBoard.setBorder(new LineBorder(Color.BLACK));

		add(drawBoard, BorderLayout.CENTER);
		add(jpSettings, BorderLayout.SOUTH);

		// Register listeners
		jbtSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = Integer.parseInt(jtfRow.getText()) - 1;
				int column = Integer.parseInt(jtfColumn.getText()) - 1;
				chessBoard.setInitialPosition(row, column);
				chessBoard.countPossibleMoves(row, column);
				startTime = System.currentTimeMillis();
				chessBoard.findPath(row , column);
				repaint();
			}
		});
	}

	class ChessBoard {
		private int[][] board = new int[8][8];
		private int row;
		private int column;
		public static final int FREE = 10;
		public static final int RESERVED = 11;
		public static final int OCCUPIED = 12;

		public ChessBoard() {
			// TODO Auto-generated constructor stub
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = FREE;
				}
			}
		}

		public void setRow(int newRow) {
			this.row = newRow;
		}

		public void setColumn(int newColumn) {
			this.column = newColumn;
		}

		public int getRow() {
			return this.row;
		}

		public int getColumn() {
			return this.column;
		}

		public void setPosition(int row, int column, int typeOfMove) {
			this.row = row;
			this.column = column;
			this.board[row][column] = typeOfMove;
		}

		public void setInitialPosition(int row, int column) {
			this.row = row;
			this.column = column;
			this.board[row][column] = OCCUPIED;			
		}

		public int[][] getBoard() {
			return this.board;
		}

		public int[] countPossibleMoves(int row, int column) {
			/**
			 * 		  Possible moves
			 * -0-[ ][ ][ ][ ][ ][ ][ ][ ]
			 * -1-[ ][8][-][1][ ][ ][ ][ ]
			 * -2-[7][ ][|][ ][2][ ][ ][ ]
			 * -3-[|][-][+][-][|][ ][ ][ ]
			 * -4-[6][ ][|][ ][3][ ][ ][ ]
			 * -5-[ ][5][-][4][ ][ ][ ][ ]
			 * -6-[ ][ ][ ][ ][ ][ ][ ][ ]
			 * -7-[ ][ ][ ][ ][ ][ ][ ][ ]
			 *    -0--1--2--3--4--5--6--7-
			 */
			int count = 0;
			// Check which moves are possible
			// 1.)
			if ((row - 2 >= 0) && (column + 1 < board.length) 
					&& board[row - 2][column + 1] == FREE) {
				count++;
			}
			// 2.)
			if ((column + 2 < board.length) && (row - 1 >= 0)
					&& board[row - 1][column + 2] == FREE) {
				count++;
			}
			// 3.)
			if ((column + 2 < board.length) && (row + 1 < board.length)
					&& board[row + 1][column + 2] == FREE) {
				count++;
			}
			// 4.)
			if ((row + 2 < board.length) && (column + 1 < board.length)
					&& board[row + 2][column + 1] == FREE) {
				count++;
			}
			// 5.)
			if ((row + 2 < board.length) && (column - 1 >= 0)
					&& board[row + 2][column - 1] == FREE) {
				count++;
			}
			// 6.)
			if ((column - 2 >= 0) && (row + 1 < board.length)
					&& board[row + 1][column - 2] == FREE) {
				count++;
			}
			// 7.)
			if ((column - 2 >= 0) && (row - 1 >= 0)
					&& board[row - 1][column - 2] == FREE) {
				count++;
			}
			// 8.)
			if ((row - 2 >= 0) && ((column - 1) >= 0)
					&& board[row - 2][column - 1] == FREE) {
				count++;
			}

			return new int[] {count, row, column};
		}

		public void findPath(int row, int column) {
			board[row][column] = OCCUPIED;
			drawBoard.setBoard(row, column);
			
			int[][] moveCounts = new int[8][3];
			int[] temp = new int[3];
			if (row - 2 >= 0 && column + 1 < board.length && board[row - 2][column + 1] == FREE) {
				temp = countPossibleMoves(row - 2, column + 1);
				moveCounts[0][0] = temp[0];
				moveCounts[0][1] = temp[1];
				moveCounts[0][2] = temp[2];
			}
			if (row - 1 >= 0 && column + 2 < board.length && board[row - 1][column + 2] == FREE) {
				temp = countPossibleMoves(row - 1, column + 2);
				moveCounts[1][0] = temp[0];
				moveCounts[1][1] = temp[1];
				moveCounts[1][2] = temp[2];
			}
			if (row + 1 < board.length && column + 2 < board.length && board[row + 1][column + 2] == FREE) {
				temp = countPossibleMoves(row + 1, column + 2);
				moveCounts[2][0] = temp[0];
				moveCounts[2][1] = temp[1];
				moveCounts[2][2] = temp[2];
			}
			if (row + 2 < board.length && column + 1 < board.length && board[row + 2][column + 1] == FREE) {
				temp = countPossibleMoves(row + 2, column + 1);
				moveCounts[3][0] = temp[0];
				moveCounts[3][1] = temp[1];
				moveCounts[3][2] = temp[2];
			}
			if (row + 2 < board.length && column - 1 >= 0 && board[row + 2][column - 1] == FREE) {
				temp = countPossibleMoves(row + 2, column - 1);
				moveCounts[4][0] = temp[0];
				moveCounts[4][1] = temp[1];
				moveCounts[4][2] = temp[2];
			}
			if (row + 1 < board.length && column - 2 >= 0 && board[row + 1][column - 2] == FREE) {
				temp = countPossibleMoves(row + 1, column - 2);
				moveCounts[5][0] = temp[0];
				moveCounts[5][1] = temp[1];
				moveCounts[5][2] = temp[2];
			}
			if (row - 1 >= 0 && column - 2 >= 0 && board[row - 1][column - 2] == FREE) {
				temp = countPossibleMoves(row - 1, column - 2);
				moveCounts[6][0] = temp[0];
				moveCounts[6][1] = temp[1];
				moveCounts[6][2] = temp[2];
			}
			if (row - 2 >= 0 && column - 1 >= 0 && board[row - 2][column - 1] == FREE) {
				temp = countPossibleMoves(row - 2, column - 1);
				moveCounts[7][0] = temp[0];
				moveCounts[7][1] = temp[1];
				moveCounts[7][2] = temp[2];
			}
			int minRow = 0;
			int minColumn = 0;
			int min = 8;
			boolean isPossible = false;
			for (int i = 0; i < moveCounts.length; i++) {
				if ((moveCounts[i][0] < min) && !(moveCounts[i][0] == 0 && moveCounts[i][1] == 0 && moveCounts[i][2] == 0)) {
					minRow = moveCounts[i][1];
					minColumn = moveCounts[i][2];
					min = moveCounts[i][0];
					isPossible = true;
				}
			}
			if (isPossible)
				findPath(minRow, minColumn);
			else {
				endTime = System.currentTimeMillis();
				System.out.println("Total time taken: " + (endTime - startTime) + "ms");
			}
		}

		/** For debug purposes only 
		public void printBoard() {
			for (int i = 0; i < board.length; i++) {
				System.out.print("-" + i + "-");
				for (int j = 0; j < board[i].length; j++) {
					System.out.print("[" + (board[i][j] < 10 ? "0" + board[i][j] : board[i][j])  + "]");
				}
				System.out.println();
			}
			System.out.printf("%34s\n", "-0- -1- -2- -3- -4- -5- -6- -7-");
			System.out.println("FREE = " + FREE);
			System.out.println("RESERVED = " + RESERVED);
			System.out.println("OCCUPIED = " + OCCUPIED + "\n");
		}
			*/
	}

	class DrawBoard extends JPanel {
		private ArrayList<int[]> board = new ArrayList<int[]>();
		private ArrayList<Point> points = new ArrayList<Point>();
		private int hGap;
		private int vGap;

		public DrawBoard() {
			// TODO Auto-generated constructor stub

		}

		public void setBoard(int row, int column) {
			board.add(new int[] {row, column});
		}



		@Override
		protected void paintComponent(Graphics g) {

			hGap = getWidth() / 8;
			vGap = getHeight() / 8;

			super.paintComponent(g);

			for (int i = 1; i < 8; i++) {
				g.drawLine(hGap * i, 0, hGap * i, getHeight());
				g.drawLine(0, vGap * i, getWidth(), vGap * i);
			}

			// Get Points for the occupied fields 
			for (int i = 0; i < board.size(); i++) {
				points.add(new Point(hGap * (board.get(i)[1] + 1) - (hGap / 2), vGap * (board.get(i)[0] + 1) - (vGap / 2)));
			}

			for (int i = 0; i + 1 < points.size(); i++) {
				g.drawLine((int)points.get(i).getX(), (int)points.get(i).getY(), 
						(int)points.get(i + 1).getX(), (int)points.get(i + 1).getY());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE2032_KnightsTour applet = new PE2032_KnightsTour();

		frame.add(applet);
		frame.setTitle("Exercise20_32");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
