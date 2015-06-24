/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE719 {

	/**
	 * 
	 */
	public PE719() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of rows and columns: ");
		int rows = input.nextInt();
		int columns = input.nextInt();
		int[][] inputArray = new int[rows][columns];
		for (int row = 0; row < inputArray.length; row++) {
			System.out.print("\n" + (row + 1) + ". row: ");
			for (int column = 0; column < inputArray[row].length; column++) {
				inputArray[row][column] = input.nextInt();
			}
		}
		if (isConsecutiveFour(inputArray))
			System.out.println("There are 4 consecutive numbers in the array ! ");
		else
			System.out.println("There are not 4 consecutive numbers in the array !");
	}
	// Checks if there is four consecutive numbers in the array
	public static boolean isConsecutiveFour(int[][] values) {
		for (int row = 0; row < values.length; row++) {
			int countRow = 1;
			int countColumn = 1;
			for (int column = 0; column < values[row].length - 1; column++) {
				// Checks the row
				if ((column + 1) < values[row].length && values[row][column] == values[row][column + 1]) {
					countRow++;
					if (countRow == 4)
						return true;
				}
				else if ((column + 1) < values[row].length && values[row][column] != values[row][column + 1])
					countRow = 1;
				// Checks the column
				if ((column + 1) < values.length && values[column][row] == values[column + 1][row]) {
					countColumn++;
					if (countColumn == 4)
						return true;
				}
				else if ((column + 1) < values.length && values[column][row] != values[column + 1][row])
					countColumn = 1;
			}
		}
		// Major Diagonal
		for (int row = 0; row < values.length; row++) {
			int countMajorDiagonalRight = 1;
			int countMajorDiagonalLeft = 1;
			for (int column = 0; column < values[row].length; column++) {
				// Checks the major diagonal right from array[0][0]
				if ((column + 1) < values.length && (column + 1 + row) < values[row].length && 
						values[column][column + row] == values[column + 1][column + 1 + row]) {
					countMajorDiagonalRight++;
					if (countMajorDiagonalRight == 4)
						return true;
				}
				else if ((column + 1) < values.length && (column + 1 + row) < values[row].length && 
						values[column][column + row] != values[column + 1][column + 1 + row])
					countMajorDiagonalRight = 1;
				// Checks the major diagonal left from array[0][0]
				if ((column + 2 + row) < values.length && values[column + 1 + row][column] == values[column + 2 + row][column + 1]) {
					countMajorDiagonalLeft++;
					if (countMajorDiagonalLeft == 4)
						return true;
				}
				else if ((column + 2 + row) < values.length && values[column + 1 + row][column] != values[column + 2 + row][column + 1])
					countMajorDiagonalLeft = 1;
			}
		}
		// Minor diagonal
		for (int row = 0; row < values.length; row++) {
			int countMinorDiagonalRight = 1;
			int countMinorDiagonalLeft = 1;
			for (int column = 0; column < values[row].length; column++) {
				// Checks the minor diagonal left from array[values.length - 1][values.length - 1]
				if ((values[row].length - 2 - column - row) >= 0 && (column + 1) < values.length &&
						values[column][values[row].length - 1 - column - row] == values[column + 1][values[row].length - 2 - column - row]) {
					countMinorDiagonalLeft++;
					if (countMinorDiagonalLeft == 4)
						return true;
				}
				else if ((values[row].length - 2 - column - row) >= 0 && (column + 1) < values.length &&
						values[column][values[row].length - 1 - column - row] != values[column + 1][values[row].length - 2 - column - row])
					countMinorDiagonalLeft = 1;
				// Checks the minor diagonal right from array[values.length - 1][values.length - 1]
				if ((values[row].length - 2 - column) >= 0 && (column + 1 + row) < values.length &&
						values[column + row][values[row].length - 1 - column] == values[column + 1 + row][values[row].length - 2 - column]) {
					countMinorDiagonalRight++;
					if (countMinorDiagonalRight == 4)
						return true;
				}
				else if ((values[row].length - 2 - column) >= 0 && (column + 1 + row) < values.length &&
						values[column + row][values[row].length - 1 - column] != values[column + 1 + row][values[row].length - 2 - column])
					countMinorDiagonalRight = 1;
			}
		}
		return false;
	}

}
