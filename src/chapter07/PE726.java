/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE726 {

	/**
	 * 
	 */
	public PE726() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 3-by-3 matrix row by row: ");
		double[][] test = new double[3][3];
		for (int row = 0; row < test.length; row++) {
			for (int column = 0; column < test[row].length; column++) {
				test[row][column] = input.nextDouble();
			}
		}
		System.out.println("\n Sorted array:");
		hdR.mtd.displayArray2dim(sortRows(test));
		
		System.out.println("\n Passed array:");
		hdR.mtd.displayArray2dim(test);
	}
	public static double[][] sortRows(double[][] array) {
		double[][] sortRows = new double[array.length][array[0].length];
		// Copy arrays
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				sortRows[row][column] = array[row][column];
			}
		}		
		for (int row = 0; row < sortRows.length; row++) {
			for (int i = 0; i < sortRows[row].length - 1; i++) {
				int minIndex = i;
				double min = sortRows[row][i];
				for (int j = i + 1; j < sortRows[row].length; j++) {
					if (sortRows[row][minIndex] > sortRows[row][j]) {
						min = sortRows[row][j];
						minIndex = j;
					}
				}
				// Swap if necessary (minIndex has changed)
				if (minIndex != i) {
					sortRows[row][minIndex] = sortRows[row][i];
					sortRows[row][i] = min;
				}
			}
		}
		return sortRows;
	}
}