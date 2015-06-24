/**
 * 
 */
package chapter07;

/**
 * @author jslapnicka
 *
 */
public class PE705 {

	/**
	 * 
	 */
	public PE705() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] firstMatrice = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
		double[][] secondMatrice = {{0, 2, 4},{1, 4.5, 2.2},{1.1, 4.3, 5.2}};
		
		displayArray2dim(firstMatrice, secondMatrice, sumTwoArrays(firstMatrice, secondMatrice));
	}	
	// Displays the two dimensional array
	public static void displayArray2dim(double[][] array, double[][] array2, double[][] sumArray) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				System.out.printf("%3.1f%1s", array[row][column],"");
			}
			if (row == 1)
				System.out.printf("%4s%1s%4s", "", "+", "");
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
	// Sums the two matrices
	public static double[][] sumTwoArrays(double[][] array1, double[][] array2) {
		double[][] sum = new double[array1.length][array1.length];
		for (int row = 0; row < array1.length; row++) {
			for (int column = 0; column < array1.length; column++) {
				sum[row][column] = array1[row][column] + array2[row][column];
			}
		}
		return sum;
	}

}
