/**
 * 
 */
package chapter07;

import java.util.Scanner;

/**
 * @author hydRa
 *
 */
public class L701 {

	/**
	 * 
	 */
	public L701() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = createArray2dim(3, 4);
		
		// Display the sum from a method
		System.out.println("The sum of the two dimensional array is: " + sumOf2dimArray(test));
	} 
	
	// Creates a two-dimensional array
	@SuppressWarnings("resource")
	public static int[][] createArray2dim(int row, int column) {
		int[][] array = new int[row][column];
		Scanner input = new Scanner(System.in);
		System.out.println("Enter " + row + " rows and " + column + " columns: ");
		for (int i = 0; i < row; i++) {
			System.out.print((i + 1) + ". row: ");
			for (int j = 0; j < column; j++) {
				array[i][j] = input.nextInt();
			}
		}
		return array;
	}
	// Calculates the sum of the two dimensional array
	public static int sumOf2dimArray(int[][] array) {
		int sum = 0;
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				sum += array[row][column];
			}
		}
		return sum;
	}

}
