/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE723 {

	/**
	 * 
	 */
	public PE723() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a 6 x 6 matrix: ");
		int[][] matrix = new int[6][6];
		for (int row = 0; row < matrix.length; row++) {
			System.out.print((row  + 1) + ". row: ");
			for (int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = input.nextInt();
			}
		}
		System.out.println();
		int[] flipped = flipped(matrix);
		System.out.print("Flipped coin at [" + flipped[0] + ", " + flipped[1] + "]");
	}
	// Checks where is flipped coin
	public static int[] flipped(int[][] matrix) {
		int[] flipped = new int[2];
		for (int row = 0; row < matrix.length; row++) {
			int sumRow = 0;
			int sumColumn = 0;
			for (int column = 0; column < matrix[row].length; column++) {
				sumRow += matrix[row][column];
				sumColumn += matrix[column][row];
			}
			if (sumRow % 2 != 0)
				flipped[0] = (row + 1);
			if (sumColumn % 2 != 0)
				flipped[1] = (row + 1);
		}
		return flipped;
	}

}
