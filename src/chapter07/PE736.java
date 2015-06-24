/**
 * 
 */
package chapter07;
import java.util.Scanner;
import java.util.Arrays;
/**
 * @author jslapnicka
 *
 */
public class PE736 {

	/**
	 * 
	 */
	public PE736() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number n: ");
		int n = Integer.parseInt(input.nextLine());
		char[][] matrix = new char[n][n];
		char[] letters = new char[matrix.length];
		// Creates an array of chars based on the length of the inputed matrix
		for (int j = 0; j < matrix.length; j++) {
			letters[j] = (char)('A' + j);
		}
	    // Enter matrix
	    System.out.println("Enter " + n + " rows of letters separated by spaces:  ");
	    for (int i = 0; i < n; i++) {
	      String s = input.nextLine();
	      String[] items = s.split("[ .+]");
	      if (items.length != n) {
	        System.out.println("Wrong input: you need to enter exactly " + n + " letters");
	        System.exit(1);
	      }
	      
	      for (int j = 0; j < items.length; j++) {
	        if (items[j].length() != 1) {
	          System.out.println("Wrong input: you need to enter single letters");
	          System.exit(2);
	        }
	        
	        matrix[i][j] = items[j].charAt(0);
	      }
	      
	      char[] clonedRow = matrix[i].clone();
	      Arrays.sort(clonedRow);
	      if (!Arrays.equals(clonedRow, letters)) {
	        System.out.println("Wrong input: the letters must be from " + letters[0] 
	          + " to " + letters[letters.length - 1]);
	      }
	    }
		if (isLatin(matrix, letters))
			System.out.println("The input array is a Latin square");
		else
			System.out.println("The input array is not a latin square");
	}
	// Checks if the matrix is Latin square
	public static boolean isLatin(char[][] matrix, char[] letters) {

		// Checks the duplicity
		boolean[][] checkRows = new boolean[matrix.length][matrix.length];
		boolean[][] checkColumns = new boolean[matrix.length][matrix.length];

		for (int row = 0; row < matrix.length; row++) {
			// Sorts & creates a supportive arrays of the inputed values in a row & column
			char[] sortedRow = new char[matrix.length];
			char[] sortedColumn = new char[matrix.length];
			for (int i = 0; i < matrix.length; i++) {
				sortedRow[i] = matrix[row][i];
				sortedColumn[i] = matrix[i][row];
			}
			Arrays.sort(sortedRow);
			Arrays.sort(sortedColumn);		
			for (int column = 0; column < matrix.length; column++) {
				if (sortedRow[column] == letters[column])
					checkRows[row][column] = true;
				if (sortedColumn[column] == letters[column])
					checkColumns[column][row] = true;
			}
		}

		// Checks the column and row for a double value
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (!checkRows[row][column] || !checkColumns[row][column])
					return false;
			}
		}
		return true;
	}
}
