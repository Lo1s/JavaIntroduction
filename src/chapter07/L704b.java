/**
 * 
 */
package chapter07;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class L704b {

	/**
	 * 
	 */
	public L704b() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = readSolution();
		
		
		System.out.println(isValid(grid) ? "Valid solution" : "Invalid solution");
	}
	// Reads a grid from the console
	@SuppressWarnings("resource")
	public static int[][] readSolution() {
		Scanner input = new Scanner(System.in);
		int[][] grid = new int[9][9];
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				grid[row][column] = input.nextInt();
			}
		}
		return grid;
	}
	// Checks if the solution is valid
	public static boolean isValid(int[][] grid) {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (grid[i][j] < 1 || grid[i][j] > 9 || !isValid(i, j, grid))
					return false;
		return true; // The solution is valid
	}
	// Checks if the grid[i][j] is valid in the grid
	public static boolean isValid(int i, int j, int[][] grid) {
		// Check whether grid[i][j] is valid in i's row
		for (int column = 0; column < 9; column++) {
			if (column != j && grid[i][column] == grid[i][j])
				return false;
		}
		// Check whether grid[i][j] is valid in j's column
		for (int row = 0; row < 9; row++) {
			if (row != i && grid[row][j] == grid[i][j])
				return false;
		}
		// Checks whether grid[i][j] is valid in j's column
		for (int row = i; row < i + 3; row++)
			for (int col = i; col < i + 3; col++)
				if (row != i && col != j && grid[row][col] == grid[i][j])
					return false;
		return true;
	}

}