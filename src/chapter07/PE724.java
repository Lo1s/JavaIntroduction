/**
 * 
 */
package chapter07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE724 {

	/**
	 * 
	 */
	public PE724() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int[][] grid = readSolution();
		System.out.println(isValid(grid) ? "Valid solution" : "Invalid Solution"); 

	}
	//
	public static boolean isValid (int[][] grid) {
		// Checks the row
		boolean[][] rowValid = new boolean[grid.length][grid.length];
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				rowValid[row][grid[row][column] - 1] = true;
			}
		}
		// Checks the column
		boolean[][] columnValid = new boolean[grid.length][grid.length];
		for (int column = 0; column < grid.length; column++) {
			for (int row = 0; row < grid[column].length; row++) {
				columnValid[grid[row][column] - 1][column] = true;
			}
		}
		// Checks the 3x3 box
		boolean[][] boxValid = new boolean[grid.length][grid.length];
		int count = 0;
		for (int row = 0; row < 9; row += 3) {
			for (int column = 0; column < 9; column += 3) {
				for (int i = row; i < row + 3; i++) {
					for (int j = column; j < column + 3; j++) {
						// Row in the box
						boxValid[count][grid[i][j] - 1] = true;
					}
				}
				count++;
			}
		}
		// Valid if row, column 3x3 box arrays are true
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				if (!rowValid[row][column] || !columnValid[row][column] || !boxValid[row][column])
					return false;
			}
		}

		return true;
	}

	// Reads a grid from the console
	@SuppressWarnings("resource")
	public static int[][] readSolution() throws FileNotFoundException {
		int[][] grid = new int[9][9];
		Scanner input = new Scanner(new File("PE724-input.txt"));
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				grid[row][column] = input.nextInt();
			}
		}
		return grid;
	}

}
