package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
 *  Description:
 *  1.) User is only allowed to put the token on the most bottom row possible
 *  2.) First player with consecutive four tokens in a row/column/diagonal wins
 *  3.) User is able to play against computer
 *  4.) AI which is defined in a computerMove() method and works on a simple principle:
 *  	a) looks for the most tokens in a row/column/major diagonal or minor diagonal
 *  	b) counts the real tokens and potential (empty) slots in a row/column/major/minor diagonal
 *  	c) creates an array where the amounts for real tokens, potential slots and coordination of possible token placement are stored
 *  	d) selects the best option and passes the chosen DrawSlot class
 *  	e) if the computer could not choose (equality) it generates a random move
 *  5.) Verifying of the winning combination is based on the definition of marginal coordinations
 *  	 within the grid for the given option (row, column, diagonals)
 *  6.) Program then scans the option and counts the number of tokens, if it finds 4 consecutive ones the coordinations of the winning 
 *  	combination is passed to the timer which provides the flashing effect.
 *   
 */

@SuppressWarnings("serial")
public class PE1835_ConnectFourWithComputer extends JApplet {

	// Grid of the slots. Every slot is drawn based on the information about player (yellow/red), row and column
	private DrawSlot[][] slots = new DrawSlot[6][7];
	// Stores the coordinations for the winning tokens
	private ArrayList<int[]> winCombination = new ArrayList<int[]>();
	// UI
	private JButton jbtStartOver = new JButton("Start Over");
	private JCheckBox jchkbComputer = new JCheckBox("Play with Computer");
	private JLabel jlblTurn = new JLabel();
	private Color playerColor; 
	// Data field
	private int player = 1;
	private boolean isClickable = true;
	private Timer timer;

	public PE1835_ConnectFourWithComputer() {
		// Set up the UI
		SlotListener slotListener = new SlotListener();
		jchkbComputer.setBackground(Color.BLACK);
		jchkbComputer.setForeground(Color.WHITE);
		playerColor = Color.RED;
		Font font = new Font("TimesRoman", Font.BOLD, 12);
		jlblTurn.setFont(font);
		jlblTurn.setForeground(playerColor);
		jlblTurn.setText("Player " + player + "'s turn");
		JPanel jpGrid = new JPanel(new GridLayout(6, 7));
		JPanel jpBottomControls = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpBottomControls.add(jlblTurn);
		jpBottomControls.add(jbtStartOver);
		jpBottomControls.add(jchkbComputer);
		jpBottomControls.setBackground(Color.BLACK);
		// Set initial values and register mouse listeners to the slots
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				slots[i][j] = new DrawSlot(i, j);
				slots[i][j].addMouseListener(slotListener);
				jpGrid.add(slots[i][j]);
			}
		}
		// Register listeners for the button, timer and checkbox
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
				isClickable = true;
				winCombination.removeAll(winCombination);
				// The first player always begins
				setPlayer(1);
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
		jchkbComputer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (jchkbComputer.isSelected() && player != 1) {
					DrawSlot slotComputer = computerMove(slots);
					slotComputer.setPlayer(player);
					winCombination = consecutiveFour(slots, slotComputer.getPlayer(), slotComputer.getRow(), slotComputer.getColumn());
					// Check for the winning combination [Computer]
					if (winCombination.size() == 4) {
						isClickable = false;							
						timer.start();
					}
					setPlayer(1);
				}
			}
		});
		add(jpGrid, BorderLayout.CENTER);
		add(jpBottomControls, BorderLayout.SOUTH);

	}

	// Inner class for the mouse listener
	class SlotListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			// Only mousebutton1 allowed
			if (e.getButton() == MouseEvent.BUTTON1 && isClickable) {
				DrawSlot slot = (DrawSlot)e.getSource();
				// Check if the clicked slot is the bottom one
				int maxRow = -1;
				int checkRow = 0;
				while (checkRow < slots.length) {
					if (slots[checkRow][slot.getColumn()].getPlayer() == 0)
						maxRow = checkRow;
					checkRow++;
				}
				if (maxRow == slot.getRow()) {
					slot.setPlayer(player);
					winCombination = consecutiveFour(slots, slot.getPlayer(), slot.getRow(), slot.getColumn());
					// Check for the winning combination [Player 1 & 2]
					if (winCombination.size() == 4) {
						isClickable = false;							
						timer.start();
					} else {
						setPlayer(0);
					}
				}
				if (jchkbComputer.isSelected() && player == 2) {
					DrawSlot slotComputer = computerMove(slots);
					slotComputer.setPlayer(player);
					winCombination = consecutiveFour(slots, slotComputer.getPlayer(), slotComputer.getRow(), slotComputer.getColumn());
					// Check for the winning combination [Computer]
					if (winCombination.size() == 4) { 
						isClickable = false;							
						timer.start();
					}
					setPlayer(0);
				}
			}
		}
	}

	// [0] = switch player X to player Y, [1] = switch to player 1, [2] = switch to player 2
	public void setPlayer(int option) {
		if (option < 0 || option > 2) {
			System.out.println("Usage: [0] = switch player X to player Y, [1] = switch to player 1, [2] = switch to player 2");
			System.exit(0);
		}
		if (option == 0)
			player = (player == 1) ? 2 : 1;
		else 
			player = option;
		playerColor = (player == 1) ? Color.RED : Color.YELLOW;
		jlblTurn.setText("Player " + player + "'s turn !");
		jlblTurn.setForeground(playerColor);
		repaint();
	}

	// Computer move
	public DrawSlot computerMove(DrawSlot[][] slots) {
		DrawSlot slot;
		// Save number of tokens in columns, rows, diagonals
		/** Try column */
		/**		[0]				[1]				[2]				[3]
		 * {numberOfTokens, potentialCount, possibleRow, possibleColumn}
		 */
		int[][] tokensInColumn = new int[][] {
				{0, 0, 0, 0}, 
				{0, 0, 0, 0},  
				{0, 0, 0, 0}, 
				{0, 0, 0, 0},  
				{0, 0, 0, 0},  
				{0, 0, 0, 0},  
				{0, 0, 0, 0}, 
		};
		for (int column = 0; column < slots[0].length; column++) {
			for (int row = 0; row < slots.length; row++) {
				// Count computer's tokens in a given column
				if (slots[row][column].getPlayer() == 2) {
					tokensInColumn[column][0]++;
				}
				if (slots[row][column].getPlayer() == 0) {
					tokensInColumn[column][1]++;
					tokensInColumn[column][2] = row;
					tokensInColumn[column][3] = column;
				} else if (slots[row][column].getPlayer() == 1) {
					break;
				}
			}
		}

		/** Try row */
		/**		[0]				[1]				[2]				[3]
		 * {numberOfTokens, potentialCount, possibleRow, possibleColumn}
		 */
		int[][] tokensInRow = new int[][] {
				{0, 0, 0, 0}, 
				{0, 0, 0, 0}, 
				{0, 0, 0, 0},
				{0, 0, 0, 0}, 
				{0, 0, 0, 0}, 
				{0, 0, 0, 0}, 
		};
		int tempPotential;
		boolean[] isFreeRow = new boolean[tokensInRow.length];
		for (int row = slots.length - 1; row >= 0; row--) {
			tempPotential = 0;
			for (int column = 0; column < slots[row].length; column++) {
				if (slots[row][column].getPlayer() == 2) {
					// Count computers tokens in a given row
					if ((row != slots.length - 1 && slots[row + 1][column].getPlayer() != 0)
							|| (row != slots.length - 1 && slots[row + 1][column].getPlayer() == 1)
							|| (row == slots.length - 1))
						tokensInRow[row][0]++;
				}
				// Count empty (potential) tokens and store the next possible token placement
				if (slots[row][column].getPlayer() == 0) {
					isFreeRow[row] = true;
					// Secure that token would not be placed when there is an empty slot below
					if ((row != slots.length - 1 && slots[row + 1][column].getPlayer() != 0) 
							|| (row != slots.length - 1 && slots[row + 1][column].getPlayer() == 1)
							|| (row == slots.length - 1)) {
						tokensInRow[row][1]++;
						// Write coordinations only if the potential is higher then previous
						if (tokensInRow[row][1] > tempPotential) { 
							tokensInRow[row][2] = row;
							tokensInRow[row][3] = column;
						}
					}
					// Reset the count if there is a token of the opponent
				} else if (slots[row][column].getPlayer() == 1 && tokensInRow[row][1] < 7 && tokensInRow[row][1] != 0) {
					tempPotential = tokensInRow[row][1];
					tokensInRow[row][1] = 0;
				}

			}
			if (tempPotential > tokensInRow[row][1])
				tokensInRow[row][1] = tempPotential;
		}

		// Clean up the count of tokens for the already filled row
		for (int i = 0; i < isFreeRow.length; i++) {
			if (!isFreeRow[i]) {
				tokensInRow[i][0] = 0;
			}
		}

		/** Try major diagonal */
		int counter = 0;
		int[][] tokensInMajorDiagonal = new int[][] {
		/**		[0]				[1]				[2]					[3]
		 * {numberOfTokens, potentialCount, nextPossibleRow, nextPossibleColumn}
		 */
		{0, 0, 0, 0},	// counter = 00 |02 03 04  05 XX XX XX|
		{0, 0, 0, 0},	// counter = 01 |01 02 03  04 05 XX XX|
		{0, 0, 0, 0},	// counter = 02 |00 01 02  03 04 05 XX|
		{0, 0, 0, 0},	// counter = 03 |XX 00 01 |02 03 04 05| - 	* loops scans only for the first possible bottom token 
		{0, 0, 0, 0},	// counter = 04 |XX XX 00 |01 02 03 04|		* in the marked diagonals, if there is already one placed
		{0, 0, 0, 0},	// counter = 05 |XX XX XX |00 01 02 03|		* then it goes via given diagonal and counts them
		};
		boolean[] isFreeMajorDiagonal = new boolean[tokensInMajorDiagonal.length];
		int column = 0;
		for (int row = slots.length - 1; row > 2; row--) {
			// Search only for the slots where major diagonal may arise
			if (row == slots.length - 1)
				column = 3;
			else if (row == slots.length - 2 || row == slots.length - 3)
				column = slots[row].length - 1;
			for (; column < slots[row].length; column++) {
				// Checking the number of consecutive yellow tokens in a major diagonal
				for (int nextRow = row, nextColumn = column; nextRow >= 0 && nextColumn >= 0; nextRow--, nextColumn--) {
					if (slots[nextRow][nextColumn].getPlayer() == 2)
						// Count the real number of tokens
						tokensInMajorDiagonal[counter][0]++;
					if (slots[nextRow][nextColumn].getPlayer() == 0) {
						// Secure that token would not be placed when there is an empty slot under
						isFreeMajorDiagonal[counter] = true;
						if ((nextRow != slots.length - 1 && slots[nextRow + 1][nextColumn].getPlayer() != 0) 
								|| (nextRow != slots.length - 1 && slots[nextRow + 1][nextColumn].getPlayer() == 1)
								|| (nextRow == slots.length - 1)) {
							tokensInMajorDiagonal[counter][1]++;
							tokensInMajorDiagonal[counter][2] = nextRow;
							tokensInMajorDiagonal[counter][3] = nextColumn;
						}
					} else if (slots[nextRow][nextColumn].getPlayer() == 1 && tokensInMajorDiagonal[counter][1] < 7 
							&& tokensInMajorDiagonal[counter][1] != 0 && tokensInMajorDiagonal[counter][1] != 1) {
						break;
					}
				}
				counter++;
			}
		}

		// Clean up the count of tokens for the filled major diagonal
		for (int i = 0; i < isFreeMajorDiagonal.length; i++) {
			if (!isFreeMajorDiagonal[i]) {
				tokensInMajorDiagonal[i][0] = 0;
			}
		}

		/** Try minor diagonal */
		int[][] tokensInMinorDiagonal = new int[][] {
		/**		[0]				[1]				[2]					[3]
		 * {numberOfTokens, potentialCount, nextPossibleRow, nextPossibleColumn}
		 */
		{0, 0, 0, 0},	// counter = 00 |XX XX XX 00  01 02 03|
		{0, 0, 0, 0},	// counter = 01 |XX XX 00 01  02 03 04|
		{0, 0, 0, 0},	// counter = 02 |XX 00 01 02  03 04 05|
		{0, 0, 0, 0},	// counter = 03 |00 01 02 03| 04 05 XX|
		{0, 0, 0, 0},	// counter = 04 |01 02 03 04| 05 XX XX|
		{0, 0, 0, 0},	// counter = 05 |02 03 04 05| XX XX XX|
		}; 
		boolean[] isFreeMinorDiagonal = new boolean[tokensInMinorDiagonal.length];
		counter = 0;
		int stop = slots[0].length;
		for (int row = 3; row < slots.length; row++) {
			// Look only for the slots where minor diagonal may arise
			if (row == 3 || row == 4)
				stop = 0;
			else if (row == slots.length - 1)
				stop = 3;
			for (column = 0; column <= stop; column++) {
				// Checking the number of consecutive yellow tokens in a major diagonal
				for (int nextRow = row, nextColumn = column; nextRow >= 0 && nextColumn < slots[row].length; nextRow--, nextColumn++) {
					if (slots[nextRow][nextColumn].getPlayer() == 2)
						// Count the real number of tokens
						tokensInMinorDiagonal[counter][0]++;
					if (slots[nextRow][nextColumn].getPlayer() == 0) {
						// Secure that token would not be placed when there is empty slot under
						isFreeMinorDiagonal[counter] = true;
						if ((nextRow != slots.length - 1 && slots[nextRow + 1][nextColumn].getPlayer() != 0) 
								|| (nextRow != slots.length - 1 && slots[nextRow + 1][nextColumn].getPlayer() == 1)
								|| (nextRow == slots.length - 1)) {
							tokensInMinorDiagonal[counter][1]++;
							tokensInMinorDiagonal[counter][2] = nextRow;
							tokensInMinorDiagonal[counter][3] = nextColumn;
						}
					} else if (slots[nextRow][nextColumn].getPlayer() == 1 && tokensInMinorDiagonal[counter][1] < 7 
							&& tokensInMinorDiagonal[counter][1] != 0 && tokensInMinorDiagonal[counter][1] != 1) {
						break;
					}
				}
				counter++;
			}
		}

		/** Evaluate the best possible move according to actual placement */
		// 1.) Scan the highest number of potential consecutive moves in the given column
		int maxIndexColumn = 0;
		for (int i = 0; i < tokensInColumn.length; i++) {
			if (tokensInColumn[i][1] > 0 && tokensInColumn[i][0] > tokensInColumn[maxIndexColumn][0])
				maxIndexColumn = i;
			// If there is more options choose the one with higher potential moves
			if (tokensInColumn[i][0] >= tokensInColumn[maxIndexColumn][0] && tokensInColumn[i][1] > tokensInColumn[maxIndexColumn][1])
				maxIndexColumn = i;
		}

		// 2.) Scan the highest number of potential consecutive moves in the given row
		int maxIndexRow = 0;
		for (int i = 0; i < tokensInRow.length; i++) {
			if (tokensInRow[i][1] > 0 && tokensInRow[i][0] > tokensInRow[maxIndexRow][0])
				maxIndexRow = i;
			// If there is more options choose the one with higher potential moves
			if (tokensInRow[i][0] > 0 && tokensInRow[i][0] >= tokensInRow[maxIndexRow][0] 
					&& tokensInRow[i][1] > tokensInRow[maxIndexRow][1])
				maxIndexRow = i;
		}

		// 3.) Scan the highest number of potential consecutive moves in the given major diagonal
		int maxIndexMajorDiagonal = 0;
		for (int i = 0; i < tokensInMajorDiagonal.length; i++) {
			if (tokensInMajorDiagonal[i][0] > 0
					&& tokensInMajorDiagonal[i][0] > tokensInMajorDiagonal[maxIndexMajorDiagonal][0])
				maxIndexMajorDiagonal = i;
			// If there is more options choose the one with higher potential moves
			if (tokensInMajorDiagonal[i][0] > 0 && tokensInMajorDiagonal[i][0] >= tokensInMajorDiagonal[maxIndexMajorDiagonal][0]
					&& tokensInMajorDiagonal[i][1] > tokensInMajorDiagonal[maxIndexMajorDiagonal][1])
				maxIndexMajorDiagonal = i;
		}

		// 4.) Scan the highest number of potential consecutive moves in the given minor diagonal
		int maxIndexMinorDiagonal = 0;
		for (int i = 0; i < tokensInMinorDiagonal.length; i++) {
			if (tokensInMinorDiagonal[i][0] > 0
					&& tokensInMinorDiagonal[i][0] > tokensInMinorDiagonal[maxIndexMinorDiagonal][0])
				maxIndexMinorDiagonal = i;
			// If there is more options choose the one with higher potential moves
			if (tokensInMinorDiagonal[i][0] > 0 && tokensInMinorDiagonal[i][0] >= tokensInMinorDiagonal[maxIndexMinorDiagonal][0]
					&& tokensInMinorDiagonal[i][1] > tokensInMinorDiagonal[maxIndexMinorDiagonal][1])
				maxIndexMinorDiagonal = i;
		}

		/** Compare number of consecutive tokens in row/column/diagonal */
		// If the column is the best possibility
		if ((tokensInColumn[maxIndexColumn][0] > tokensInRow[maxIndexRow][0])
				&& (tokensInColumn[maxIndexColumn][0] > tokensInMajorDiagonal[maxIndexMajorDiagonal][0])
				&& (tokensInColumn[maxIndexColumn][0] > tokensInMinorDiagonal[maxIndexMinorDiagonal][0])) {
			slot = slots[tokensInColumn[maxIndexColumn][2]][tokensInColumn[maxIndexColumn][3]];
			// If the row is the best possibility
		} else if ((tokensInRow[maxIndexRow][1] > 0) 
				&& (tokensInRow[maxIndexRow][0] > tokensInColumn[maxIndexColumn][0])
				&& (tokensInRow[maxIndexRow][0] > tokensInMajorDiagonal[maxIndexMajorDiagonal][0])
				&& (tokensInRow[maxIndexRow][0] > tokensInMinorDiagonal[maxIndexMinorDiagonal][0])) {
			slot = slots[tokensInRow[maxIndexRow][2]][tokensInRow[maxIndexRow][3]];
			// If the major diagonal is the best possibility
		} else if ((tokensInMajorDiagonal[maxIndexMajorDiagonal][1] > 0) 
				&& (tokensInMajorDiagonal[maxIndexMajorDiagonal][0] > tokensInColumn[maxIndexColumn][0])
				&& (tokensInMajorDiagonal[maxIndexMajorDiagonal][0] > tokensInRow[maxIndexRow][0])
				&& (tokensInMajorDiagonal[maxIndexMajorDiagonal][0] > tokensInMinorDiagonal[maxIndexMinorDiagonal][0])) {
			slot = slots[tokensInMajorDiagonal[maxIndexMajorDiagonal][2]][tokensInMajorDiagonal[maxIndexMajorDiagonal][3]];
			// If the minor diagonal is the best possibility
		} else if ((tokensInMinorDiagonal[maxIndexMinorDiagonal][1] > 0)
				&& (tokensInMinorDiagonal[maxIndexMinorDiagonal][0] > tokensInColumn[maxIndexColumn][0])
				&& (tokensInMinorDiagonal[maxIndexMinorDiagonal][0] > tokensInRow[maxIndexRow][0])
				&& (tokensInMinorDiagonal[maxIndexMinorDiagonal][0] > tokensInMajorDiagonal[maxIndexMajorDiagonal][0])) {
			slot = slots[tokensInMinorDiagonal[maxIndexMinorDiagonal][2]][tokensInMinorDiagonal[maxIndexMinorDiagonal][3]];
			// If there is a possibility of equality -> make a random move
		} else {
			int random = (int)(Math.random() * ((tokensInColumn.length - 1) + 1));
			slot = slots[tokensInColumn[random][2]][tokensInColumn[random][3]];
		}
		return slot;
	}

	// Check for the winning combination
	public static ArrayList<int[]> consecutiveFour(DrawSlot[][] array, int number, int rowInput, int columnInput) {
		// Check for win
		/* 1.) Define the max range for checking 
		 * Method is searching for the range of possible winning move in a row, column, major diagonal and minor diagonal.
		 * If the range is within the grid the max coordinations are defined.
		 * If the range is outwith the grid the marginal coordinations of the array are defined
		 */
		ArrayList<int[]> winningSlots = new ArrayList<int[]>();
		// 1a) Row			
		int rowLeftMax = 0;
		int rowRightMax = 0;
			// left 
		if (columnInput >= (4 - 1))
			rowLeftMax = (columnInput - (4 - 1));
		else 
			rowLeftMax = 0;
			// right
		if	(((array[rowInput].length - 1) - columnInput) >= (4 - 1))
			rowRightMax = columnInput + (4 - 1);
		else
			rowRightMax = array[rowInput].length - 1;
		// 1b) Column
		int columnUpMax = 0;
		int columnDownMax = 0;
			// up
		if (rowInput >= (4 - 1))
			columnUpMax = (rowInput - (4 - 1));
		else
			columnUpMax = 0;
			// down
		if (((array.length - 1) - rowInput) >= (4 - 1))
			columnDownMax = rowInput + (4 - 1);
		else
			columnDownMax = array.length - 1;
		// 1c) Major Diagonal
		int majorDiagonalUpMaxRow = 0;
		int majorDiagonalUpMaxCol = 0;
		int majorDiagonalDownMaxRow = 0;
		int majorDiagonalDownMaxCol = 0;
			// up
		for (int i = rowInput, j = columnInput, k = (4 - 1); i >= 0 && j >= 0 && k >= 0; i--, j--, k--) {
			majorDiagonalUpMaxRow = i;
			majorDiagonalUpMaxCol = j;
		}
			// down
		for (int i = rowInput, j = columnInput, k = (4 - 1); i < array.length && j < array[i].length && k >= 0; i++, j++, k--) {
			majorDiagonalDownMaxRow = i;
			majorDiagonalDownMaxCol = j;
		}
		// 1d) Minor Diagonal
		int minorDiagonalUpMaxRow = 0;
		int minorDiagonalUpMaxCol = 0;
		int minorDiagonalDownMaxRow = 0;
		int minorDiagonalDownMaxCol = 0;
			// up
		for (int i = rowInput, j = columnInput, k = (4 - 1); i >= 0 && j < array[i].length && k >= 0 ; i--, j++, k--) {
			minorDiagonalUpMaxRow = i;
			minorDiagonalUpMaxCol = j;
		}
			// down
		for (int i = rowInput, j = columnInput, k = (4 -1); i < array.length && j >= 0 && k >= 0 ; i++, j--, k--) {
			minorDiagonalDownMaxRow = i;
			minorDiagonalDownMaxCol = j;
		}
		/* 2.) Checks if there is a winning move in the range
		 * 
		 */
		// 2a) Checking the row
		winningSlots.removeAll(winningSlots);
		for (int i = rowLeftMax; i <= rowRightMax ; i++) {
			winningSlots.add(new int[] {rowInput, i});
			if (winningSlots.size() == 4) {
				return winningSlots;
			}
			if (i + 1 < array[rowInput].length && array[rowInput][i].getPlayer() != array[rowInput][i + 1].getPlayer()) {
				winningSlots.removeAll(winningSlots);
			}
		}
		// 2b) Checking the column
		winningSlots.removeAll(winningSlots);
		for (int i = columnUpMax; i <= columnDownMax; i++) {
			winningSlots.add(new int[] {i, columnInput});
			if (winningSlots.size() == 4) 
				return winningSlots;;
				if (i + 1 < array.length && array[i][columnInput].getPlayer() != array[i + 1][columnInput].getPlayer()) {
					winningSlots.removeAll(winningSlots);
				}
		}
		// 2c) Checking the major diagonal
		winningSlots.removeAll(winningSlots);
		for (int i = majorDiagonalUpMaxRow, j = majorDiagonalUpMaxCol; i <= majorDiagonalDownMaxRow 
				&& j <= majorDiagonalDownMaxCol; i++, j++ ) {
			winningSlots.add(new int[] {i, j});
			if (winningSlots.size() == 4) 
				return winningSlots;
			if (i + 1 < array.length && j + 1 < array[i].length && array[i][j].getPlayer() != array[i + 1][j + 1].getPlayer()) {
				winningSlots.removeAll(winningSlots);
			}
		}
		// 2d) Checking the minor diagonal
		winningSlots.removeAll(winningSlots);
		for (int i = minorDiagonalUpMaxRow, j = minorDiagonalUpMaxCol; i <= minorDiagonalDownMaxRow 
				&& j >= minorDiagonalDownMaxCol; i++, j--) {
			winningSlots.add(new int[] {i, j});
			if (winningSlots.size() == 4)
				return winningSlots;
			if (i + 1 < array.length && j - 1 >= 0 && array[i][j].getPlayer() != array[i + 1][j - 1].getPlayer()) {
				winningSlots.removeAll(winningSlots);
			}
		}
		winningSlots.removeAll(winningSlots);
		return winningSlots;
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

	// Applet settings
	public void init() {
		setSize(358, 300);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1835_ConnectFourWithComputer applet = new PE1835_ConnectFourWithComputer();
		frame.add(applet);
		frame.setTitle("Connect Four");
		frame.setSize(358,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
