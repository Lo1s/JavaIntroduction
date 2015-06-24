/**
 * 
 */
package chapter07;
import java.util.Scanner;
import java.io.*;
/**
 * @author jslapnicka
 *
 */
public class PE704 {

	/**
	 * 
	 */
	public PE704() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int[][] workingHours = new int[8][7];
		Scanner input = new Scanner(new File("PE704-input.txt"));

		for (int row = 0; row < workingHours.length; row++) {
			for (int column = 0; column < workingHours[0].length; column++) {
				workingHours[row][column] = input.nextInt();
			}
		}
		// Creating array for the sums of the rows
		int[] sum = new int[workingHours.length];
		for (int row = 0; row < workingHours.length; row++) {
			sum[row] = sumRow(workingHours, row);

		}
		// Displaying the results in descending order
		int max = 0;
		int counter = 0;
		while (counter < sum.length) {
			for (int i = 0; i < sum.length; i++) {
				if (sum[max] < sum[i]) {
					max = i;
				}
			}
			System.out.println("Employee's nr." + max + " total work hours are: " + sum[max]);
			counter++;
			sum[max] = -1;
		}

	}
	// Sums the row
	public static int sumRow(int[][] array, int rowIndex) {
		int sum = 0;
		for (int column = 0; column < array[0].length; column++) {
			sum += array[rowIndex][column];
		}
		return sum;
	}

}
