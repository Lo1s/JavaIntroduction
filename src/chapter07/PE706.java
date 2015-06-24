/**
 * 
 */
package chapter07;

/**
 * @author jslapnicka
 *
 */
public class PE706 {

	/**
	 * 
	 */
	public PE706() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] firstMatrice = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
		double[][] secondMatrice = {{0, 2, 4},{1, 4.5, 2.2},{1.1, 4.3, 5.2}};

		displayArray2dim(firstMatrice, secondMatrice, multiplyMatrix(firstMatrice, secondMatrice));
	}
	// Displays the two dimensional array
	public static void displayArray2dim(double[][] array, double[][] array2, double[][] sumArray) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				System.out.printf("%3.1f%1s", array[row][column],"");
			}
			if (row == 1)
				System.out.printf("%4s%1s%4s", "", "*", "");
			else
				System.out.printf("%9s", "");
			for (int column = 0; column < array[row].length; column++) {
				System.out.printf("%3.1f%1s", array2[row][column], "");
			}
			if (row == 1)
				System.out.printf("%4s%1s%4s", "", "=", "");
			else
				System.out.printf("%9s", "");
			for (int column = 0; column < array[row].length; column++) {
				System.out.printf("%3.1f%1s", sumArray[row][column], "");
			}
			System.out.println();
		}

	}
	public static double[][] multiplyMatrix(double[][] array1, double[][] array2) {
		double[][] multiply = new double[array2.length][array1.length];

		for (int row = 0; row < array1.length; row++) {
			double sum = 0;
			for (int i = 0; i < array1[0].length; i++) {
				for (int column = 0; column < array1[0].length; column++) {
					sum += array1[row][column] * array2[column][i];
				}
				multiply[row][i] = sum;
				sum = 0;
			}
		}
		return multiply;
	}
}
