/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE714 {

	/**
	 * 
	 */
	public PE714() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size for the matrix: ");
		int size = input.nextInt();
		int[][] binaryMatrix = binaryMatrix(size);
		hdR.mtd.displayArray2dim(binaryMatrix);
		int[][] checker = checker(binaryMatrix);

		// Prints the result
		boolean isCovered = false;
		for (int j = 0; j < checker.length; j++) {
			if (checker[0][j] > -1) {
				System.out.println("All " + checker[0][j] + "s on row " + (j + 1));
				isCovered = true;
			}
		}
		if (!isCovered) {
			System.out.println("No same numbers on a row.");
		}
		isCovered = false;
		for (int j = 0; j < checker.length; j++) {
			if (checker[1][j] > -1) {
				System.out.println("All " + checker[1][j] + "s on column " + (j + 1));
				isCovered = true;
			}
		}
		if (!isCovered) {
			System.out.println("No same numbers on a column.");
		}
		isCovered = false;
		if (checker[2][0] > -1) {
			System.out.println("All " + checker[2][0] + "s on the major diagonal");
			isCovered = true;
		}
		if (!isCovered) {
			System.out.println("No same numbers on a major diagonal.");
		}
		isCovered = false;
		if (checker[3][0] > -1) {
			System.out.println("All " + checker[3][0] + "s on the minor diagonal");
			isCovered = true;
		}
		if (!isCovered) {
			System.out.println("No same numbers on a minor diagonal.");
			isCovered = false;
		}
	}

	// Checks the rows, columns and diagonals where is only the same value 
	public static int[][] checker(int[][] array) {
		int checkSumRow = 0;
		int checkSumColumn = 0;
		int checkSumMajorDiagonal = 0;
		int checkSumMinorDiagonal = 0;
		int[][] checker = new int[4][array.length];
		for (int row = 0; row < checker.length; row++) {
			for (int column = 0; column < checker.length; column++) {
				checker[row][column] = -1;
			}
		}

		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				// Checks the row
				checkSumRow += array[row][column];
				// Check the column
				checkSumColumn += array[column][row];
			}
			// Checks the major diagonal
			checkSumMajorDiagonal += array[row][row];
			// Checks the minor diagonal
			checkSumMinorDiagonal += array[array.length - 1 - row][row];
			if (checkSumRow == array.length || checkSumRow == 0) 
				checker[0][row] = checkSumRow / array.length;	// All 1s or 0s in a row
			else if (checkSumColumn == array.length || checkSumColumn == 0) 
				checker[1][row] = checkSumColumn / array.length;
			checkSumRow = 0;
			checkSumColumn = 0;
		}
		if (checkSumMajorDiagonal == array.length || checkSumMajorDiagonal == 0)
			checker[2][0] = checkSumMajorDiagonal / array.length;
		if (checkSumMinorDiagonal == array.length || checkSumMinorDiagonal == 0)
			checker[3][0] = checkSumMinorDiagonal / array.length;
		return checker;
	}

	// Creates the random binary matrix according to the passed size
	public static int[][] binaryMatrix(int size) {
		int[][] binaryMatrix = new int[size][size];
		for (int row = 0; row < binaryMatrix.length; row++) {
			for (int column = 0; column < binaryMatrix[row].length; column++) {
				binaryMatrix[row][column] = hdR.mtd.getRandomNumber(0, 1);
			}
		}
		return binaryMatrix;
	}
}
