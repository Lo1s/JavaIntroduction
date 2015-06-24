/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE713 {

	/**
	 * 
	 */
	public PE713() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of rows and columns of the array: ");
		int inputRow = input.nextInt();
		int inputColumn = input.nextInt();
		double[][] inputArray = new double[inputRow][inputColumn];
		System.out.println("Enter the array: ");
		for (int row = 0; row < inputArray.length; row++) {
			for (int column = 0; column < inputArray[row].length; column++) {
				inputArray[row][column] = input.nextDouble();
			}
		}
		int[] coordinations = locateLargest(inputArray);
		int row = coordinations[0];
		int column = coordinations[1];
		System.out.print("The location of the largest element is at (" + row + ", " + column + ")");
	}
	public static int[] locateLargest(double[][] array) {
		int[] result = new int[2];
		double largestElement = 0;
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				if (array[row][column] > largestElement) {
					largestElement = array[row][column];
					result[0] = row;
					result[1] = column;
				}
			}
		}
		return result;
	}
}
