/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE622 {

	/**
	 * 
	 */
	public PE622() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] grid = {0, -1, -1, -1, -1, -1, -1, -1};

		// Put 8 queens on the grid
		int queens = 1;	// first queen at [0][0]
		while (queens >= 0 && queens <= 7) {
			int position = insertQueen(grid, queens);
			if (position > - 1) {
				grid[queens] = position;
				queens++;
				displayGrid(grid);
			} else {
				grid[queens] = -1;
				queens--; // to the previous row
				displayGrid(grid);
			}
		}
		displayGrid(grid);
	}

	// Insert queen into the grid
	public static int insertQueen(int[] grid, int row) {
		int start = grid[row] == -1 ? 0 : grid[row] + 1;
		for (int column = start; column < grid.length; column++) {
			if (freePosition(grid, row, column))
				return column;
		}
		return -1;
	}

	// Check if there is a queen in the same row, column or diagonal
	public static boolean freePosition(int[] grid, int rowInput, int columnInput) {
		// Check if column is possible
		for (int i = 0; i < grid.length; i++) {
			if (columnInput == grid[i])
				return false;
		}
		// c) Major Diagonal
		// - up
		for (int i = rowInput, j = columnInput; i >= 0 && j >= 0; i--, j--) {
			if (grid[i] == j)
				return false;
		}
		// - down
		for (int i = rowInput, j = columnInput; i < grid.length && j < grid.length; i++, j++) {
			if (grid[i] == j)
				return false;
		}
		// d) Minor Diagonal
		// - up
		for (int i = rowInput, j = columnInput; i >= 0 && j < grid.length; i--, j++) {
			if (grid[i] == j)
				return false;
		}
		// - down
		for (int i = rowInput, j = columnInput; i < grid.length && j >= 0; i++, j--) {
			if (grid[i] == j)
				return false;
		}
		return true;
	}

	// Displays the grid
	public static void displayGrid(int[] array) {
		// Print the coordinates
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + ", " + array[i]);
		}

		// Print the column of the grid
		String token = "Q";
		System.out.print("      ");
		for (int i = 0; i < array.length; i++) {
			if (i < 100)
				System.out.print("[" + " " + i + "]");
			else
				System.out.print("[" + i + "]");
		}
		// Print line
		System.out.print("\n     ");
		for (int i = 0; i < array.length; i++) {
			if (i < array.length - 1)
				System.out.print("----");
			else
				System.out.print("-----\n");
		}
		// Print the row of the grid
		for (int row = 0; row < array.length; row++) {
			System.out.print("[" + row + "]  |");
			for (int column = 0; column < array.length; column++) {
				if (column < array[row] || column > array[row]) {
					System.out.printf("%4s", "|");
				} else
					System.out.print(" " + token + " |");
			}
			// Print line
			System.out.print("\n     ");
			for (int i = 0; i < array.length; i++) {
				if (i < array.length - 1)
					System.out.print("----");
				else
					System.out.print("-----\n");
			}
		}
	}
}
