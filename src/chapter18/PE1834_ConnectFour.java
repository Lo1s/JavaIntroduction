package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 25. 10. 2014 2014 10:51:44
 * 
 *  Simple game of Connect Four
 *  Game uses J2SE Graphics for "UI" of the game
 *  Can be run as the applet or standalone application
 *  
 *  Rules:
 *  1.) User is only allowed to put the token on the most bottom row possible
 *  2.) First player with consecutive 4 in a row/column/diagonal wins
 *  
 */

@SuppressWarnings("serial")
public class PE1834_ConnectFour extends JApplet {

	private DrawSlot[][] slots = new DrawSlot[6][7];
	private JButton jbtStartOver = new JButton("Start Over");
	private int player = 1;
	private boolean isClickable = true;
	private Timer timer;
	private ArrayList<int[]> winCombination = new ArrayList<int[]>();

	public PE1834_ConnectFour() {

		SlotListener slotListener = new SlotListener();
		JPanel jpGrid = new JPanel(new GridLayout(6, 7));
		JPanel jpButton = new JPanel();
		jpButton.add(jbtStartOver);

		// Set initial values and register mouse listeners to the slots
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				slots[i][j] = new DrawSlot(i, j);
				slots[i][j].addMouseListener(slotListener);
				jpGrid.add(slots[i][j]);
			}
		}

		jbtStartOver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Default settings
				timer.stop();
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						slots[i][j].setPlayer(0);
						slots[i][j].blink(false);
					}
				}
				player = 1;
				isClickable = true;
				winCombination.removeAll(winCombination);
				repaint();
			}
		});

		timer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				slots[winCombination.get(0)[0]][winCombination.get(0)[1]].blink(true);
				slots[winCombination.get(1)[0]][winCombination.get(1)[1]].blink(true);
				slots[winCombination.get(2)[0]][winCombination.get(2)[1]].blink(true);
				slots[winCombination.get(3)[0]][winCombination.get(3)[1]].blink(true);
				repaint();
			}
		});

		add(jpGrid, BorderLayout.CENTER);
		add(jpButton, BorderLayout.SOUTH);

	}
	
	// Inner class for the mouse listener
	class SlotListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			// Only mousebutton1 allowed
			if (e.getButton() == MouseEvent.BUTTON1 && isClickable) {
				// Check if the field is empty/occupied by the player
				DrawSlot slot = (DrawSlot)e.getSource();
				if (slot.getPlayer() == 0) {
					int maxRow = -1;
					int checkRow = 0;
					while (checkRow < slots.length) {
						// Check if the clicked slot is the bottom one and not covered by any tokens above
						if (slots[checkRow][slot.getColumn()].getPlayer() == 0)
							maxRow = checkRow;
						checkRow++;
					}
					if (maxRow == slot.getRow()) {
						slot.setPlayer(player);
						winCombination = consecutiveFour(slots, slot.getPlayer(), slot.getRow(), slot.getColumn());
						if (winCombination.size() == 4) {
							isClickable = false;							
							timer.start();
						}
						player = (player == 1 ? 2 : 1);						
					}
				}
				repaint();
			}
		}
	}

	// Inner class for graphical drawing of the slot
	class DrawSlot extends JPanel {
		private Color color;
		private int player = 0;
		private int row;
		private int column;
		private boolean blinks = false;

		public DrawSlot(int row, int column) {
			this.row = row;
			this.column = column;
			setBackground(Color.BLUE);
		}

		// Get the player who occupies the slot [0 = empty, 1 = player1, 2 = player2]
		public int getPlayer() {
			return player;
		}

		// Set the player
		public void setPlayer(int player) {
			this.player = player;
		}

		// Set row for better localization of the clicked object
		public void setRow(int row) {
			this.row = row;
		}

		// Set column for better localization of the clicked object
		public void setColumn(int column) {
			this.column = column;
		}

		// Get row of the clicked slot
		public int getRow() {
			return row;
		}

		// Get column of the clicked slot
		public int getColumn() {
			return column;
		}

		// Get color of the slot
		public Color getColor() {
			return this.color;
		}

		// Set color of the slot
		public void setColor(Color newColor) {
			this.color = newColor;
		}

		// Set the flashing
		public void blink(boolean setOn) {
			this.blinks = setOn;
		}

		@Override
		protected void paintComponent(Graphics g) {
			int radius = Math.min(getWidth(), getHeight()) * 4 / 10;

			if (!blinks) {
				switch(player) {
				case 0: color = Color.WHITE; break;
				case 1: color = Color.RED; break;
				case 2: color = Color.YELLOW; break;
				}  
			} else {
				switch(player) {
				case 1: color = (color == Color.RED) ? Color.WHITE : Color.RED; break;
				case 2: color = (color == Color.YELLOW) ? Color.WHITE : Color.YELLOW; break;
				}
			}

			super.paintComponent(g);
			g.setColor(color);
			g.fillOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius);
		}
	}


	// Check for win-draw-loss
	public static ArrayList<int[]> consecutiveFour(DrawSlot[][] array, int number, int rowInput, int columnInput) {
		// Check if grid is full
		// Check for win/draw
		/* 1.) Define the max range for checking 
		 * This section is looking for the range of possible winning move in a row, column, major diagonal and minor diagonal.
		 * If the range is within the grid the max coordinations are defined.
		 * If the range is outwith the grid the marginal coordinations of the array are defined
		 */
		ArrayList<int[]> winningSlots = new ArrayList<int[]>();
		// a) row			
		int rowLeftMax = 0;
		int rowRightMax = 0;
		//	- left (4 - 1) = number of consecutive tokens
		if (columnInput >= (4 - 1))
			rowLeftMax = (columnInput - (4 - 1));
		else 
			rowLeftMax = 0;
		// 	- right
		if	(((array[rowInput].length - 1) - columnInput) >= (4 - 1))
			rowRightMax = columnInput + (4 - 1);
		else
			rowRightMax = array[rowInput].length - 1;
		//	b) column
		int columnUpMax = 0;
		int columnDownMax = 0;
		//	- up
		if (rowInput >= (4 - 1))
			columnUpMax = (rowInput - (4 - 1));
		else
			columnUpMax = 0;
		//	- down
		if (((array.length - 1) - rowInput) >= (4 - 1))
			columnDownMax = rowInput + (4 - 1);
		else
			columnDownMax = array.length - 1;
		// c) Major Diagonal
		int majorDiagonalUpMaxRow = 0;
		int majorDiagonalUpMaxCol = 0;
		int majorDiagonalDownMaxRow = 0;
		int majorDiagonalDownMaxCol = 0;
		// - up
		for (int i = rowInput, j = columnInput, k = (4 - 1); i >= 0 && j >= 0 && k >= 0; i--, j--, k--) {
			majorDiagonalUpMaxRow = i;
			majorDiagonalUpMaxCol = j;
		}
		// - down
		for (int i = rowInput, j = columnInput, k = (4 - 1); i < array.length && j < array[i].length && k >= 0; i++, j++, k--) {
			majorDiagonalDownMaxRow = i;
			majorDiagonalDownMaxCol = j;
		}
		// d) Minor Diagonal
		int minorDiagonalUpMaxRow = 0;
		int minorDiagonalUpMaxCol = 0;
		int minorDiagonalDownMaxRow = 0;
		int minorDiagonalDownMaxCol = 0;
		// - up
		for (int i = rowInput, j = columnInput, k = (4 - 1); i >= 0 && j < array[i].length && k >= 0 ; i--, j++, k--) {
			minorDiagonalUpMaxRow = i;
			minorDiagonalUpMaxCol = j;
		}
		// - down
		for (int i = rowInput, j = columnInput, k = (4 -1); i < array.length && j >= 0 && k >= 0 ; i++, j--, k--) {
			minorDiagonalDownMaxRow = i;
			minorDiagonalDownMaxCol = j;
		}
		/* 2.) Checks if there is a winning move in the range
		 * 
		 */
		// a) Checking the row
		winningSlots.removeAll(winningSlots);
		int countRow = 0;
		for (int i = rowLeftMax; i <= rowRightMax ; i++) {
			countRow++;
			winningSlots.add(new int[] {rowInput, i});
			if (countRow == 4) {
				return winningSlots;
			}
			if (i + 1 < array[rowInput].length && array[rowInput][i].getPlayer() != array[rowInput][i + 1].getPlayer()) {
				countRow = 0;
				winningSlots.removeAll(winningSlots);
			}
		}
		// b) Checking the column
		winningSlots.removeAll(winningSlots);
		int countColumn = 0;
		for (int i = columnUpMax; i <= columnDownMax; i++) {
			countColumn++;
			winningSlots.add(new int[] {i, columnInput});
			if (countColumn == 4) 
				return winningSlots;;
				if (i + 1 < array.length && array[i][columnInput].getPlayer() != array[i + 1][columnInput].getPlayer()) {
					countColumn = 0;
					winningSlots.removeAll(winningSlots);
				}
		}
		// c) Checking the major diagonal
		winningSlots.removeAll(winningSlots);
		int countMajorDiagonal = 0;
		for (int i = majorDiagonalUpMaxRow, j = majorDiagonalUpMaxCol; i <= majorDiagonalDownMaxRow 
				&& j <= majorDiagonalDownMaxCol; i++, j++ ) {
			countMajorDiagonal++;
			winningSlots.add(new int[] {i, j});
			if (countMajorDiagonal == 4) 
				return winningSlots;
			if (i + 1 < array.length && j + 1 < array[i].length && array[i][j].getPlayer() != array[i + 1][j + 1].getPlayer()) {
				countMajorDiagonal = 0;
				winningSlots.removeAll(winningSlots);
			}
		}
		// d) Checking the minor diagonal
		winningSlots.removeAll(winningSlots);
		int countMinorDiagonal = 0;
		for (int i = minorDiagonalUpMaxRow, j = minorDiagonalUpMaxCol; i <= minorDiagonalDownMaxRow 
				&& j >= minorDiagonalDownMaxCol; i++, j--) {
			countMinorDiagonal++;
			winningSlots.add(new int[] {i, j});
			if (countMinorDiagonal == 4)
				return winningSlots;
			if (i + 1 < array.length && j - 1 >= 0 && array[i][j].getPlayer() != array[i + 1][j - 1].getPlayer()) {
				countMinorDiagonal = 0;
				winningSlots.removeAll(winningSlots);
			}
		}
		winningSlots.removeAll(winningSlots);
		return winningSlots;
	}

	public void init() {
		setSize(300, 300);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1834_ConnectFour applet = new PE1834_ConnectFour();
		frame.add(applet);
		frame.setTitle("Exercise18_34");
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
