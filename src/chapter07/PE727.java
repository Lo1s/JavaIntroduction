/**
 * 
 */
package chapter07;

import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE727 {

	/**
	 * 
	 */
	public PE727() {
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
		hdR.mtd.displayArray2dim(sortColumns(test));
		
		System.out.println("\n Passed array:");
		hdR.mtd.displayArray2dim(test);
	}
	public static double[][] sortColumns(double[][] array) {
		double[][] sortColumns = new double[array.length][array.length];
		// Copy arrays
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				sortColumns[row][column] = array[row][column];
			}
		}
		
		// Sorting
		for (int column = 0; column < sortColumns[0].length; column++) {
			for (int i = 0; i < sortColumns.length - 1; i++) {
				double min = sortColumns[i][column];
				int minIndex = i;
				for (int j = i + 1; j < sortColumns.length; j++) {
					if (min > sortColumns[j][column]) {
						min = sortColumns[j][column];
						minIndex = j;
					}
				}
				// Swap if necessary
				if (minIndex != i) {
					sortColumns[minIndex][column] = sortColumns[i][column];
					sortColumns[i][column] = min;
				}
			}
		}
		return sortColumns;
	}

}
