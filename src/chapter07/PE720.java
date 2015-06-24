/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE720 {

	/**
	 * 
	 */
	public PE720() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[][] grid = new int[6][7];
		displayGrid(grid);
		String disk = "";
		int player1 = 1;
		int player2 = 100;

		while(!winDraw(grid)) {
			// Red player input
			disk = "red";
			System.out.print("Drop a " + disk + " disk at column (0-6): " );
			int inputColumn = input.nextInt();
			createGrid(grid, player1, inputColumn);
			displayGrid(grid);

			// Yellow player input
			if (!winDraw(grid)) {
				disk = "yellow";
				System.out.print("Drop a " + disk + " disk at column (0-6): " );
				inputColumn = input.nextInt();
				createGrid(grid, player2, inputColumn);
				displayGrid(grid);	
			}
		}
		System.out.print("Player with the " + disk + " disk won !");
	}
	// Checks if the player won or if it is a draw (grid is full)
	public static boolean winDraw(int[][] grid) {
		for (int row = 0; row < grid.length; row++) {
			int countRow = 1;
			int countColumn = 1;
			for (int column = 0; column < grid[row].length - 1; column++) {
				// Checks the row
				if (grid[row][column] != 0 && (column + 1) < grid[row].length && grid[row][column] == grid[row][column + 1]) {
					countRow++;
					if (countRow == 4)
						return true;
				}
				else if ((column + 1) < grid[row].length && grid[row][column] != grid[row][column + 1])
					countRow = 1;
				// Checks the column
				if (grid[column][row] != 0 && (column + 1) < grid.length && grid[column][row] == grid[column + 1][row]) {
					countColumn++;
					if (countColumn == 4)
						return true;
				}
				else if ((column + 1) < grid.length && grid[column][row] != grid[column + 1][row])
					countColumn = 1;
			}
		}
		// Major Diagonal
		for (int row = 0; row < grid.length; row++) {
			int countMajorDiagonalRight = 1;
			int countMajorDiagonalLeft = 1;
			for (int column = 0; column < grid[row].length; column++) {
				// Checks the major diagonal right from array[0][0]
				if ((column + 1 + row) < grid.length && grid[column][column + row] != 0 && (column + 1 + row) < grid[row].length && 
						grid[column][column + row] == grid[column + 1][column + 1 + row]) {
					countMajorDiagonalRight++;
					if (countMajorDiagonalRight == 4)
						return true;
				}
				else if ((column + 1) < grid.length && (column + 1 + row) < grid[row].length && 
						grid[column][column + row] != grid[column + 1][column + 1 + row])
					countMajorDiagonalRight = 1;
				// Checks the major diagonal left from array[0][0]
				if ((column + 2 + row) < grid.length && grid[column + 1 + row][column] != 0 && grid[column + 1 + row][column] == grid[column + 2 + row][column + 1]) {
					countMajorDiagonalLeft++;
					if (countMajorDiagonalLeft == 4)
						return true;
				}
				else if ((column + 2 + row) < grid.length && grid[column + 1 + row][column] != grid[column + 2 + row][column + 1])
					countMajorDiagonalLeft = 1;
			}
		}
		// Minor diagonal
		for (int row = 0; row < grid.length; row++) {
			int countMinorDiagonalRight = 1;
			int countMinorDiagonalLeft = 1;
			for (int column = 0; column < grid[row].length; column++) {
				// Checks the minor diagonal left from array[grid.length - 1][grid.length - 1]
				if ((grid[row].length - 2 - column - row) >= 0 && (column + 1) < grid.length &&grid[column][grid[row].length - 2 - column - row] != 0 && grid[column][grid[row].length - 1 - column - row] == grid[column + 1][grid[row].length - 2 - column - row]) {
					countMinorDiagonalLeft++;
					if (countMinorDiagonalLeft == 4)
						return true;
				}
				else if ((grid[row].length - 2 - column - row) >= 0 && (column + 1) < grid.length &&
						grid[column][grid[row].length - 1 - column - row] != grid[column + 1][grid[row].length - 2 - column - row])
					countMinorDiagonalLeft = 1;
				// Checks the minor diagonal right from array[grid.length - 1][grid.length - 1]
				if ((grid[row].length - 2 - column) >= 0 && (column + 1 + row) < grid.length && grid[column + row][grid[row].length - 1 - column] != 0 && grid[column + row][grid[row].length - 1 - column] == grid[column + 1 + row][grid[row].length - 2 - column]) {
					countMinorDiagonalRight++;
					if (countMinorDiagonalRight == 4)
						return true;
				}
				else if ((grid[row].length - 2 - column) >= 0 && (column + 1 + row) < grid.length &&
						grid[column + row][grid[row].length - 1 - column] != grid[column + 1 + row][grid[row].length - 2 - column])
					countMinorDiagonalRight = 1;
			}
		}
		return false;
	}

	// Creates a grid with the input from the user
	public static int[][] createGrid(int[][] grid, int player, int input) {
		int row = grid.length - 1;
		while (row >= 0) {
			if (grid[row][input] == 0) {
				grid[row][input] = player;
				break;
			}
			else
				row--;
		}
		return grid;
	}

	// Displays the grid
	public static void displayGrid(int[][] grid) {
		System.out.println("\n|0|1|2|3|4|5|6|");
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				if (grid[row][column] == 0)
					System.out.print("| ");
				else if (grid[row][column] == 1)
					System.out.print("|R");
				else if (grid[row][column] == 100)
					System.out.print("|Y");
			}
			System.out.println("|");
		}
		System.out.println("---------------");
	}

}
