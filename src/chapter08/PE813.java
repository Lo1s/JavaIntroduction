/**
 * 
 */
package chapter08;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 12. 6. 2014 2014 12:53:56 
 */
public class PE813 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of rows and columns in the array: ");
		int row = input.nextInt();
		int column = input.nextInt();
		System.out.println("Enter the array: ");
		double[][] array = new double[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				array[i][j] = input.nextDouble();
			}
		}
		Location loc = locateLargest(array);
		System.out.println("The location of the largest element is " + loc.maxValue + " at (" + loc.row + ", " + loc.column + ")");
	}
	public static Location locateLargest(double[][] array) {
		double maxValue = array[0][0];
		Location loc = new Location(0, 0, maxValue);
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				if (array[row][column] > maxValue) {
					maxValue = array[row][column];
					loc = new Location(row, column, maxValue);
				}
				
			}
		}
		return loc;
	}

}
class Location {
	int row;
	int column;
	double maxValue = 0;
	
	// Constructor
	Location(int newRow, int newColumn, double newMaxValue) {
		row = newRow;
		column = newColumn;
		maxValue = newMaxValue;
	}
}
