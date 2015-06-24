/**
 * 
 */
package chapter20;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author jslapnicka
 * @Date & @Time 24. 11. 2014 2014 12:25:25 
 */
@SuppressWarnings("serial")
public class PE2026_CreateMaze extends JApplet {

	private JButton jbtFindPath = new JButton("Find Path");
	private JButton jbtClearPath = new JButton("Clear Path");
	private JLabel jlblMazeStatus = new JLabel("Path not found");
	private DrawCell[][] board = new DrawCell[8][8];	

	public PE2026_CreateMaze() {
		// TODO Auto-generated constructor stub

		// Initialize the board
		JPanel jpBoard = new JPanel(new GridLayout(8, 8));
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8;column++) {
				board[row][column] = new DrawCell(row, column, false);
				jpBoard.add(board[row][column]);
			}
		}

		// Create panel for the buttons
		JPanel jpButtons = new JPanel();
		jpButtons.add(jbtFindPath);
		jpButtons.add(jbtClearPath);

		// Add items to the frame
		add(jlblMazeStatus, BorderLayout.NORTH);
		add(jpBoard, BorderLayout.CENTER);
		add(jpButtons, BorderLayout.SOUTH);

		// Register listeners
		jbtFindPath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (findPath(0, 0))
					jlblMazeStatus.setText("Found path !");
				else
					jlblMazeStatus.setText("Path not found !");
			}
		});

		jbtClearPath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int row = 0; row < board.length; row++) {
					for (int column = 0; column < board[row].length; column++) {
						board[row][column].setFilled(false);
						board[row][column].setReserved(false);
						board[row][column].setClicked(false);
						board[row][column].visit(false);
					}
				}
			}
		});
	}
	
	public boolean findPath(int row, int column) {
		board[row][column].visit(true);

		if ((row == 7) && (column == 7)) {
			board[row][column].setFilled(true);
			return true;
		}
		// Go up
		if ((row > 0) && !board[row - 1][column].isClicked() 
				&& !board[row - 1][column].visited() && !board[row - 1][column].isReserved()) {

			reserve(row, column);

			if (findPath(row - 1, column)) {
				board[row][column].setFilled(true);
				return true;
			}

			unReserve(row, column);
		}
		// Go down
		if ((row < 7) && !board[row + 1][column].isClicked() 
				&& !board[row + 1][column].visited() && !board[row + 1][column].isReserved()) {

			reserve(row, column);

			if (findPath(row + 1, column)) {
				board[row][column].setFilled(true);
				return true;
			}

			unReserve(row, column);
		}
		// Go left
		if ((column > 0) && !board[row][column - 1].isClicked() 
				&& !board[row][column - 1].visited() && !board[row][column - 1].isReserved()) {

			reserve(row, column);

			if (findPath(row, column - 1)) {
				board[row][column].setFilled(true);
				return true;
			}

			unReserve(row, column);
		}

		// Go right
		if ((column < 7) && !board[row][column + 1].isClicked() 
				&& !board[row][column + 1].visited() && !board[row][column + 1].isReserved()) {

			reserve(row, column);

			if (findPath(row, column + 1)) {
				board[row][column].setFilled(true);
				return true;
			}

			unReserve(row, column);
		}


		return false;
	}

	// Temporary block the neighbor to prevent neighboring path
	public void reserve(int row, int column) {
		if (row > 0) {
			board[row - 1][column].setReserved(true);
		}

		if (row < 7) {
			board[row + 1][column].setReserved(true);;
		}

		if (column > 0) {
			board[row][column - 1].setReserved(true);;
		}

		if (column < 7) {
			board[row][column + 1].setReserved(true);;
		}
		
	}

	// Remove the temporary block
	public void unReserve(int row, int column) {
		if (row > 0) {
			board[row - 1][column].setReserved(false);;
		}

		if (row < 7) {
			board[row + 1][column].setReserved(false);;
		}

		if (column > 0) {
			board[row][column - 1].setReserved(false);;
		}

		if (column < 7) {
			board[row][column + 1].setReserved(false);
		}
		
	}


	class DrawCell extends JPanel {

		private int row;
		private int column;
		private boolean filled;
		private boolean clicked;
		private boolean reserved;
		private boolean visited;

		public DrawCell() {
			// TODO Auto-generated constructor stub
		}

		public DrawCell(int row, int column, boolean filled) {
			this.row = row;
			this.column = column;
			this.filled = filled;

			addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					setClicked(true);
					repaint();
				}
			});
		}

		public void setReserved(boolean reserved) {
			repaint();
			this.reserved = reserved;
		}

		public void setFilled(boolean filled) {
			this.filled = filled;
			repaint();
		}

		public void setClicked(boolean clicked) {
			this.clicked = clicked;
		}
		
		public void visit(boolean visited) {
			this.visited = true;
		}

		public int getRow() {
			return this.row;
		}

		public int getColumn() {
			return this.column;
		}
		
		public boolean visited() {
			return visited;
		}

		public boolean isReserved() {
			return this.reserved;
		}

		public boolean isFilled() {
			return this.filled;
		}

		public boolean isClicked() {
			return this.clicked;
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			if (filled) {
				g.setColor(Color.BLACK);
				g.fillRect(0 + 5, 0, 30, 20);
			} else
				g.drawRect(0 + 5, 0, 30, 20);

			if (clicked) {
				g.drawLine(0 + 5, 0, 35, 20);
				g.drawLine(35, 0, 0 + 5, 20);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE2026_CreateMaze applet = new PE2026_CreateMaze();

		frame.add(applet);
		frame.setTitle("Exercise20_26");
		frame.setSize(310, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
