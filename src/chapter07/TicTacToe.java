/**
 * 
 */
package chapter07;

import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class TicTacToe {

	/**
	 * 
	 */
	public TicTacToe() {

	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		Scanner input = new Scanner(System.in);
		// Asking for the language
		System.out.println("Ahoj ! Prosím, zvolte jazyk (0 = ENG, 1 = CZ): ");
		System.out.print("Hi ! Please select a language (0 = ENG, 1 = CZ): ");
		int language = input.nextInt();

		// Asking for the size of the grid
		if (language == 0) 
			System.out.print("Hello again ! Please enter the size of the grid, first tell me how wide it should be: ");
		else
			System.out.print("Zvolte šíøku pole: ");
		int columnSize = input.nextInt();
		if (language == 0)
			System.out.print("And how long it should be: ");
		else
			System.out.print("Zvolte výšku pole: ");
		int rowSize = input.nextInt();
		int[][] grid = new int[rowSize][columnSize];
		// Number of winning tokens
		if (language == 0)
			System.out.print("\nOk, we have the size of the grid.\n"
					+ "Now tell me, How good are you ? In other words: How many tokens would be needed for the win: ");
		else
			System.out.print("\nOk, velikost pole bychom mìli.\n"
					+ "Teï bych ještì potøeboval vìdìt, jak moc si vìøíte ? Aneb na kolik chcete hrát ? ");
		int numberOfTokens = input.nextInt();
		while (numberOfTokens > grid.length && numberOfTokens > grid[0].length) {
			if (numberOfTokens <= 100) {
				if (language == 0)
					System.out.print("\nDude, I know that you are just a human being. \nBut rest assure that it is not possible"
							+ " to make a winning move of " + numberOfTokens + " tokens in a grid with the size of " 
							+ grid.length + " rows and " + grid[0].length + " columns." + "\nPlease enter a lower number for a mutual happiness: ");
				else
					System.out.print("Ty vole ! Chápu, že jsi jen èlovìk, ale vìø mi, že není možné vyhrát na " 
							+ numberOfTokens + " v poli o velikosti " + grid.length + " na " + grid[0].length + ".\nProsím, zadej menší hodnotu: ");
				numberOfTokens = input.nextInt();
			} else {
				if (language == 0)
					System.out.print("\nYou are crazy !\n"
							+ "Well, I can arrange that but I am just not sure that you as a human being are able to handle it !\n" 
							+ "Please enter a lower number for a mutual happiness: ");
				else
					System.out.print("Ty jsi blázen !\n"
							+ "Jako mùžu to zaøídit, ale nejsem si jistý jestli to zvládnete... Jste pøeci jenom lidi !\n"
							+ "Prosím zadej menší hodnotu: ");
				numberOfTokens = input.nextInt();
			}
		}
		// Getting the names of the players
		if (language == 0)
			System.out.print("\nEnter a name for player 1: ");
		else 
			System.out.print("\nJméno prvního hráèe: ");
		String player1 = input.next();
		if (language == 0)
			System.out.print("Thank you, " + player1 + " ! Your game token will be 'X'\n\n");
		else
			System.out.print("Dìkuji, " + player1 + " ! Budeš hrát s 'X'\n\n");
		if (language == 0)
			System.out.print("Enter a name for player 2: ");
		else
			System.out.print("\nJméno druhého hráèe: ");
		String player2 = input.next();
		if (language == 0)
			System.out.print("Thank you, " + player2 + " ! Your game token will be 'O'\n\n");
		else
			System.out.print("Dìkuji, " + player2 + " ! Ty hraješ s 'O'\n\n");
		displayGrid(grid);

		// Selecting coordinates for token input of the player 1
		int rowInput1 = 0;
		int columnInput1 = 0;
		int rowInput2 = 0;
		int columnInput2 = 0;
		int round = 1;
		while (winDrawLoss(grid, numberOfTokens, rowInput1, columnInput1) == 0 && winDrawLoss(grid, numberOfTokens, rowInput2, columnInput2) == 0) {
			if (language == 0)
				System.out.println(round + ". round !");
			else
				System.out.println(round + ". kolo !");
			round++;
			if (language == 0)
				System.out.print(player1 + ", please enter a row: ");
			else
				System.out.print(player1 + ", prosím zvol øadu: ");
			rowInput1 = input.nextInt();
			if (language == 0)
				System.out.print("Ok, now tell me at which column I should put it: ");
			else
				System.out.print("Ok, teï poprosím o sloupec: ");
			columnInput1 = input.nextInt();
			int player = 1;
			// Check if empty
			while (!isEmpty(grid, rowInput1, columnInput1)) {
				if (language == 0) {
					System.out.println("\nThe field with coordinations: row = [" + rowInput1 + "] column = [" + columnInput1 + "] is already taken.");
					System.out.println("Please enter new coordinations for row: ");
				} else { 
					System.out.println("\nPole se souøadnicemi: øada = [" + rowInput1 + "] sloupec = [" + columnInput1 + "] je už bohužel obsazené.");
					System.out.println("Prosím zadej novou øadu: ");
				}
				rowInput1 = input.nextInt();
				if (language == 0)
					System.out.println("And for the column: ");
				else
					System.out.println("A sloupec: ");
				columnInput1 = input.nextInt();
			}
			displayGrid(createGrid(grid, rowInput1, columnInput1, player));
			// Selecting coordinates for token input of the player 2 if the player 1 had not already won
			if (winDrawLoss(grid, numberOfTokens, rowInput1, columnInput1) == 0) {
				if (language == 0)
					System.out.print(player2 + ", please enter a row: ");
				else
					System.out.print(player2 + ", prosím zvol øadu: ");
				rowInput2 = input.nextInt();
				if (language == 0)
					System.out.print("Ok, now tell me at which column I should put it: ");
				else
					System.out.print("Ok, teï poprosím o sloupec: ");
				columnInput2 = input.nextInt();
				player = 100;
				// Check if empty
				while (!isEmpty(grid, rowInput2, columnInput2)) {
					if (language == 0) {
						System.out.println("\nThe field with coordinations: row = [" + rowInput2 + "] column = [" + columnInput2 + "] is already taken.");
						System.out.println("Please enter new coordinations for row: ");
					} else { 
						System.out.println("\nPole se souøadnicemi: øada = [" + rowInput2 + "] sloupec = [" + columnInput2 + "] je už bohužel obsazené.");
						System.out.println("Prosím zadej novou øadu: ");
					}
					rowInput2 = input.nextInt();
					if (language == 0)
						System.out.println("And for the column: ");
					else
						System.out.println("A sloupec: ");
					columnInput2 = input.nextInt();
				}
				displayGrid(createGrid(grid, rowInput2, columnInput2, player));
			}
		}
		int result1 = winDrawLoss(grid, numberOfTokens, rowInput1, columnInput1);
		int result2 = winDrawLoss(grid, numberOfTokens, rowInput2, columnInput2);

		if (result1 == 1) {
			if (language == 0) {
				System.out.println(player1 + ", you won ! Congratz !");
				System.out.println(player2 + ", don't be sad. Maybe next time !");
			} else {
				System.out.println(player1 + ", vyhrál(a) jsi ! Dobøe ty !");
				System.out.println(player2 + ", nebuï smutný(á). Pøíštì to vyjde !");
			}
		} else if (result2 == 2) {
			if (language == 0) {
				System.out.println(player2 + ", you won ! Congratz !");
				System.out.println(player1 + ", don't be sad. Maybe next time !");
			} else {
				System.out.println(player2 + ", vyhrál(a) jsi ! Dobøe ty !");
				System.out.println(player1 + ", nebuï smutný(á). Pøíštì to vyjde !");
			}
		} else if (result1 == 3) {
			if (language == 0)
				System.out.println("Wow, you are good ! Next time choose a bigger grid though !");
			else
				System.out.println("Wow, jsi fakt dobrý ! Pøíštì si ale zvolte vìtší pole ! ;)");
		} else if (result2 == 3) {
			if (language == 0)
				System.out.println("Wow, you are good ! Next time choose a bigger grid though !");
			else
				System.out.println("Wow, jsi fakt dobrý ! Pøíštì si ale zvolte vìtší pole ! ;)");
		}

	}

	// Displays the grid
	public static void displayGrid(int[][] array) {
		String token = "";
		// Print the column coordinates
		System.out.print("      ");
		for (int i = 0; i < array.length; i++) {
			if (i < 10)
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
		// Print the row coordinates + grid
		for (int sector = 0; sector < array.length; sector++) {
			if (sector < 10)
				System.out.print("[" + " " + sector + "] |");
			else
				System.out.print("[" + sector + "] |");
			for (int square = 0; square < array[sector].length; square++) {
				if (array[sector][square] == 1)
					token = "X";
				else if (array[sector][square] == 100)
					token = "O";
				if (array[sector][square] == 0) {
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
	// Check if the coordinates are empty
	public static boolean isEmpty(int[][] array, int rowInput,int columnInput) {
		if (array[rowInput][columnInput] != 0)
			return false;
		else
			return true;
	}
	// Creating the grid
	public static int[][] createGrid(int[][] array, int rowInput,int columnInput, int player) {
		array[rowInput][columnInput] = player;
		return array;
	}

	// Check for win-draw-loss
	public static int winDrawLoss(int[][] array, int numberOfTokens, int rowInput, int columnInput) {
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
		// Check for win/draw
		/* 1.) Define the max range for checking 
		 * This section is looking for the range of possible winning move in a row, column, major diagonal and minor diagonal.
		 * If the range is within the grid the max coordinations are defined.
		 * If the range is outwith the grid the marginal coordinations of the array are defined
		 */
		// a) row			
		int rowLeftMax = 0;
		int rowRightMax = 0;
		//	- left
		if (columnInput >= numberOfTokens)
			rowLeftMax = (columnInput - (numberOfTokens - 1));
		else 
			rowLeftMax = 0;
		// 	- right
		if	(((array[rowInput].length - 1) - columnInput) >= numberOfTokens)
			rowRightMax = columnInput + (numberOfTokens - 1);
		else
			rowRightMax = array[rowInput].length - 1;
		//	b) column
		int columnUpMax = 0;
		int columnDownMax = 0;
		//	- up
		if (rowInput >= numberOfTokens)
			columnUpMax = (rowInput - (numberOfTokens - 1));
		else
			columnUpMax = 0;
		//	- down
		if (((array.length - 1) - rowInput) >= numberOfTokens)
			columnDownMax = rowInput + (numberOfTokens - 1);
		else
			columnDownMax = array.length - 1;
		// c) Major Diagonal
		int majorDiagonalUpMaxRow = 0;
		int majorDiagonalUpMaxCol = 0;
		int majorDiagonalDownMaxRow = 0;
		int majorDiagonalDownMaxCol = 0;
		// - up
		for (int i = rowInput, j = columnInput, k = (numberOfTokens - 1); i >= 0 && j >= 0 && k >= 0; i--, j--, k--) {
			majorDiagonalUpMaxRow = i;
			majorDiagonalUpMaxCol = j;
		}
		// - down
		for (int i = rowInput, j = columnInput, k = (numberOfTokens - 1); i < array.length && j < array[i].length && k >= 0; i++, j++, k--) {
			majorDiagonalDownMaxRow = i;
			majorDiagonalDownMaxCol = j;
		}
		// d) Minor Diagonal
		int minorDiagonalUpMaxRow = 0;
		int minorDiagonalUpMaxCol = 0;
		int minorDiagonalDownMaxRow = 0;
		int minorDiagonalDownMaxCol = 0;
		// - up
		for (int i = rowInput, j = columnInput, k = (numberOfTokens - 1); i >= 0 && j < array[i].length && k >= 0 ; i--, j++, k--) {
			minorDiagonalUpMaxRow = i;
			minorDiagonalUpMaxCol = j;
		}
		// - down
		for (int i = rowInput, j = columnInput, k = (numberOfTokens -1); i < array.length && j >= 0 && k >= 0 ; i++, j--, k--) {
			minorDiagonalDownMaxRow = i;
			minorDiagonalDownMaxCol = j;
		}
		/* 2.) Checks if there is a winning move in the range
		 * 
		 */
		// a) Checking the row
		int sumRow = 0;
		for (int i = rowLeftMax; i <= rowRightMax ; i++) {
			sumRow += array[rowInput][i];
			if (sumRow == 1 * numberOfTokens)
				return 1;
			else if (sumRow == 100 * numberOfTokens)
				return 2;
			if (i + 1 < array[rowInput].length && array[rowInput][i] != array[rowInput][i + 1])
				sumRow = 0;
		}
		// b) Checking the column
		int sumColumn = 0;
		for (int i = columnUpMax; i <= columnDownMax; i++) {
			sumColumn += array[i][columnInput];
			if (sumColumn == 1 * numberOfTokens)
				return 1;
			else if (sumColumn == 100 * numberOfTokens)
				return 2;
			if (i + 1 < array.length && array[i][columnInput] != array[i + 1][columnInput])
				sumColumn = 0;
		}
		// c) Checking the major diagonal
		int majorDiagonalSum = 0;
		for (int i = majorDiagonalUpMaxRow, j = majorDiagonalUpMaxCol; i <= majorDiagonalDownMaxRow 
				&& j <= majorDiagonalDownMaxCol; i++, j++ ) {
			majorDiagonalSum += array[i][j];
			if (majorDiagonalSum == 1 * numberOfTokens)
				return 1;
			else if (majorDiagonalSum == 100 * numberOfTokens)
				return 2;
			if (i + 1 < array.length && j + 1 < array[i].length && array[i][j] != array[i + 1][j + 1])
				majorDiagonalSum = 0;
		}
		// d) Checking the minor diagonal
		int minorDiagonalSum = 0;
		for (int i = minorDiagonalUpMaxRow, j = minorDiagonalUpMaxCol; i <= minorDiagonalDownMaxRow 
				&& j >= minorDiagonalDownMaxCol; i++, j--) {
			minorDiagonalSum += array[i][j];
			if (minorDiagonalSum == 1 * numberOfTokens)
				return 1;
			else if (minorDiagonalSum == 100 * numberOfTokens)
				return 2;
			if (i + 1 < array.length && j - 1 >= 0 && array[i][j] != array[i + 1][j - 1])
				minorDiagonalSum = 0;
		}
		return 0;
	}
}