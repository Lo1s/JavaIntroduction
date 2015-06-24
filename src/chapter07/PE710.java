/**
 * 
 */
package chapter07;

/**
 * @author jslapnicka
 *
 */
public class PE710 {

	/**
	 * 
	 */
	public PE710() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[4][4];
		displayArray(randomize(matrix));
		System.out.println("The largest column index is: " + columnSearch(matrix));
		System.out.println("The largest row index is: " + rowSearch(matrix));
	}
	// Finds the most 1s in a column
	public static int columnSearch(int[][] array) {
		int sumColumn = 0;
		int index = 0;
		int result = 0;
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				sumColumn += array[column][row];
			}
			if (sumColumn > result) {
				index = row;
				result = sumColumn;
				sumColumn = 0;
			} else
				sumColumn = 0;
		}
		return index;
	}
	// Finds the most 1s in a row
	public static int rowSearch(int[][] array) {
		int sumRow = 0;
		int index = 0;
		int result = 0;
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				sumRow += array[row][column];
			}
			if (sumRow > result) {
				index = row;
				result = sumRow;
				sumRow = 0;
			} else
				sumRow = 0;
		}
		return index;
	}
	
	// Randomize the binary into the array
	public static int[][] randomize(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				array[row][column] = hdR.mtd.getRandomNumber(0, 1);
			}
		}
		return array;
	}
	// Display the array
	public static void displayArray(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				System.out.print(array[row][column]);
			}
			System.out.println();
		}
	}

}
