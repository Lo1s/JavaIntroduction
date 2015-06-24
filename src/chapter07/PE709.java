/**
 * 
 */
package chapter07;

import java.util.Scanner;

/**
 * @author jslapnicka
 * 
 */
public class PE709 {

	/**
	 * 
	 */
	public PE709() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] grid = new int[3][3];

		// Getting the names of the players
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a name for player 1: ");
		String player1 = input.next();
		System.out.print("Thank you, " + player1 + " ! Your game token will be 'X'\n\n");

		System.out.print("Enter a name for player 2: ");
		String player2 = input.next();
		System.out.print("Thank you, " + player2 + " ! Your game token will be 'O'\n\n");
		displayGrid(grid);

		// Selecting coordinates for token input of the player 1
		int round = 1;
		while (winDrawLoss(grid) == 0) {
			System.out.println(round + ". round !");
			round++;
			System.out.print(player1 + ", please enter a row (0, 1, or 2): ");
			int rowInput1 = input.nextInt();
			System.out.print("Ok, now tell me at which column I should put it: ");
			int columnInput1 = input.nextInt();
			int player = 1;
			displayGrid(createGrid(grid, rowInput1, columnInput1, player));
			// Selecting coordinates for token input of the player 2
			if (winDrawLoss(grid) == 0) {
				System.out.print(player2 + ", please enter a row (0, 1, or 2): ");
				int rowInput2 = input.nextInt();
				System.out.print("Ok, now tell me at which column I should put it: ");
				int columnInput2 = input.nextInt();
				player = 10;
				displayGrid(createGrid(grid, rowInput2, columnInput2, player));
			}
		}

		if (winDrawLoss(grid) == 1) {
			System.out.println(player1 + ", you won ! Congratz !");
			System.out.println(player2 + ", don't be sad. Maybe next time !");
		} else if (winDrawLoss(grid) == 2) {
			System.out.println(player2 + ", you won ! Congratz !");
			System.out.println(player1 + ", don't be sad. Maybe next time !");
		} else if (winDrawLoss(grid) == 3) {
			System.out.println("Well, I know that the grid is small... I will tell my creator to make it a bit bigger next time !");
		}

	}

	// Displays the grid
	public static void displayGrid(int[][] array) {
		String token = "";
		System.out.println("     [O] [1] [2]");
		for (int sector = 0; sector < 3; sector++) {
			System.out.print("    -------------" + "\n[" + sector + "] |");
			for (int square = 0; square < 3; square++) {
				if (array[sector][square] == 1)
					token = "X";
				else if (array[sector][square] == 10)
					token = "O";
				if (array[sector][square] == 0)
					System.out.printf("%4s", "|");
				else
					System.out.print(" " + token + " |");
			}
			System.out.println();
		}
		System.out.print("    -------------" + "\n");
	}

	// Creating the grid
	public static int[][] createGrid(int[][] array, int rowInput,
			int columnInput, int player) {
		array[rowInput][columnInput] = player;
		return array;
	}

	// Check for win-draw-loss
	public static int winDrawLoss(int[][] array) {
		// Check if grid is full
		boolean isFull = true;
		for (int row = 0; row < array.length && isFull; row++) {
			for (int column = 0; column < array[row].length; column++) {
				if (array[row][column] == 0) {
					isFull = false;
					break;
				} else
					isFull = true;
			}
		}
		if (isFull) {
			return 3;
		}
		// Check for win
		int[] sumColumn = new int [3];
		int[] sumRow = new int[3];
		int sumMajorDiagonal = 0;
		int sumMinorDiagonal = 0;
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				// Check for column win
				sumColumn[row] += array[column][row];
				// Check for row win	
				sumRow[row] += array[row][column];
			}
		}
		// Check for diagonal win
		for (int i = 0; i < array.length; i++) {
			// Major diagonal
			sumMajorDiagonal += array[i][i];
			// Minor diagonal
			sumMinorDiagonal += array[i][array.length - 1 - i];
		}
		
		for (int row = 0; row < array.length; row++) {
			if (sumColumn[row] == 3 || sumRow[row] == 3 || sumMajorDiagonal == 3 || sumMinorDiagonal == 3)
				return 1;
			else if (sumColumn[row] == 30 || sumColumn[row] == 30 || sumMajorDiagonal == 30 || sumMinorDiagonal == 30)
				return 2;
		}
		return 0;
	}
}
