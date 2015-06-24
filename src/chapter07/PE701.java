/**
 * 
 */
package chapter07;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE701 {

	/**
	 * 
	 */
	public PE701() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a 3-by-4 matrix by row: ");
		double[][] test = new double[3][4];
		PE701.createArray2dim(test);
		
		for (int i = 0; i < test[0].length; i++) {
			System.out.println("Sum of the elements at column " + i + " is: " + sumColumn(test, i));
		}
	}
	// Creating an array by user input with defined number of elements
	@SuppressWarnings("resource")
	public static double[][] createArray2dim(double[][] array) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter " + array.length + " rows per " + array[0].length + " numbers:");
		for (int row = 0; row < array.length; row++) {
			System.out.print(row + 1 + ". row: ");
			for (int column = 0; column < array[row].length; column++) {
				array[row][column] = input.nextDouble();
			}
		}
		return array;
	}

	// Sums the specific column
	public static double sumColumn(double[][] array, int columnIndex) {
		double sum = 0;
			for (int row = 0; row < array.length; row++) {
				sum += array[row][columnIndex];
			}
		return sum;
	}

}
