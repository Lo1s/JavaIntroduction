/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 31. 10. 2014 2014 9:07:30 
 */
@SuppressWarnings("serial")
public class PE1833_PatternRecognition extends JApplet {

	private JTextField[][] jtfArray = new JTextField[6][7];
	private int[][] numbers = new int[6][7];
	private JButton jbtSolve = new JButton("Solve");
	private JButton jbtGenerateRandom = new JButton("Generate random");
	private boolean stop = false;

	public PE1833_PatternRecognition() {
		// TODO Auto-generated constructor stub
		JPanel jpButton = new JPanel();
		jpButton.add(jbtSolve);
		jpButton.add(jbtGenerateRandom);

		/** Creating the grid of text fields */
		JPanel jpGrid = new JPanel(new GridLayout(6, 7, 2, 2));
		for (int i = 0; i < jtfArray.length; i++) {				
			for (int j = 0; j < jtfArray[i].length; j++) {
				jtfArray[i][j] = new JTextField(2);
				jtfArray[i][j].setHorizontalAlignment(JTextField.CENTER);
				jpGrid.add(jtfArray[i][j]);
			}
		}

		/** Register listener */
		jbtGenerateRandom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < numbers.length; i++) {
					for (int j = 0; j < numbers[i].length; j++) {
						numbers[i][j] = hdR.mtd.getRandomNumber(0, 9);
						jtfArray[i][j].setText(numbers[i][j] + "");
					}
				}
				repaint();
			}
		});

		jbtSolve.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
				stop = false;
				for (int i = 0; i < jtfArray.length; i++) {
					for (int j = 0; j < jtfArray[i].length; j++) {
						if (!jtfArray[i][j].getText().isEmpty())
							numbers[i][j] = Integer.parseInt(jtfArray[i][j].getText());
						else
							numbers[i][j] = 0;
					}
				}
				for (int i = 0; i < numbers.length && !stop; i++) {
					for (int j = 0; j < numbers[i].length; j++) {
						if (consecutiveFour(numbers, numbers[i][j], i, j) == 1) {
							jtfArray[i][j].setBackground(Color.YELLOW);
							repaint();
						}
					}
				}
			}
		});

		/** Adding items into the frame */
		add(jpGrid, BorderLayout.CENTER);
		add(jpButton, BorderLayout.SOUTH);
	}

	// Check for win-draw-loss
	public static int consecutiveFour(int[][] array, int number, int rowInput, int columnInput) {
		// Check if grid is full
		// Check for win/draw
		/* 1.) Define the max range for checking 
		 * This section is looking for the range of possible winning move in a row, column, major diagonal and minor diagonal.
		 * If the range is within the grid the max coordinations are defined.
		 * If the range is outwith the grid the marginal coordinations of the array are defined
		 */
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
		int countRow = 0;
		for (int i = rowLeftMax; i <= rowRightMax ; i++) {
			countRow ++;
			if (countRow == 4) 
				return 1;
			if (i + 1 < array[rowInput].length && array[rowInput][i] != array[rowInput][i + 1])
				countRow = 0;
		}
		// b) Checking the column
		int countColumn = 0;
		for (int i = columnUpMax; i <= columnDownMax; i++) {
			countColumn ++;
			if (countColumn == 4) 
				return 1;
			if (i + 1 < array.length && array[i][columnInput] != array[i + 1][columnInput])
				countColumn = 0;
		}
		// c) Checking the major diagonal
		int countMajorDiagonal = 0;
		for (int i = majorDiagonalUpMaxRow, j = majorDiagonalUpMaxCol; i <= majorDiagonalDownMaxRow 
				&& j <= majorDiagonalDownMaxCol; i++, j++ ) {
			countMajorDiagonal ++;
			if (countMajorDiagonal == 4) 
				return 1;
			if (i + 1 < array.length && j + 1 < array[i].length && array[i][j] != array[i + 1][j + 1])
				countMajorDiagonal = 0;
		}
		// d) Checking the minor diagonal
		int countMinorDiagonal = 0;
		for (int i = minorDiagonalUpMaxRow, j = minorDiagonalUpMaxCol; i <= minorDiagonalDownMaxRow 
				&& j >= minorDiagonalDownMaxCol; i++, j--) {
			countMinorDiagonal ++;
			if (countMinorDiagonal == 4)
				return 1;
			if (i + 1 < array.length && j - 1 >= 0 && array[i][j] != array[i + 1][j - 1])
				countMinorDiagonal = 0;
		}
		return 0;
	}
	
	@Override
	public void init() {
		setSize(250, 200);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1833_PatternRecognition applet = new PE1833_PatternRecognition();

		frame.add(applet);
		frame.setTitle("Exercise18_33");
		frame.setSize(250, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
