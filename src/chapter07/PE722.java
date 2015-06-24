/**
 * 
 */
package chapter07;

/**
 * @author jslapnicka
 *
 */
public class PE722 {

	/**
	 * 
	 */
	public PE722() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 6;
		int[][] matrix = createMatrix(size);
		displayMatrix(matrix);
		System.out.println();
		System.out.println("Does the row & column has even number of 1s ?");
		boolean[][] checker = checker(matrix);
		for (int i = 0; i < checker.length; i++) {
			System.out.println((i + 1) + ". row: " + checker[i][0] + " | " + (i + 1) + ". column: " + checker[i][1]);
		}
	}
	// Check if there is even number of 1s in every column and row
	public static boolean[][] checker(int[][] matrix) {
		boolean[][] checker = new boolean[matrix.length][2];
		for (int row = 0; row < matrix.length; row++) {
			int sumRow = 0;
			int sumColumn = 0;
			for (int column = 0; column < matrix[row].length; column++) {
				sumRow += matrix[row][column];
				sumColumn += matrix[column][row];
			}
			if (sumRow % 2 == 0)
				checker[row][0] = true;	// checker for the row
			if (sumColumn % 2 == 0)
				checker[row][1] = true; // checker for the column
		}
		return checker;
	}
	
	// Creates an matrix filled with 1/0s
	public static int[][] createMatrix(int size) {
		int[][] matrix = new int[size][size];
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = hdR.mtd.getRandomNumber(0, 1);
			}
		}
		return matrix;
	}
	// Display matrix
	public static void displayMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				System.out.print(matrix[row][column] + " ");
			}
			System.out.println();
		}
	}
	// Overloading the method for displaying matrix 
	public static void displayMatrix(boolean[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				System.out.print(matrix[row][column] + " ");
			}
			System.out.println();
		}
	}
	

}
