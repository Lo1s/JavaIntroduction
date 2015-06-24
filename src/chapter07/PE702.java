/**
 * 
 */
package chapter07;

/**
 * @author jslapnicka
 *
 */
public class PE702 {

	/**
	 * 
	 */
	public PE702() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] test = new double[4][4];
		System.out.println("Enter a 4-by-4 matrix row by row: ");
		hdR.mtd.createArray2dim(test);
		
		System.out.println("Sum of the elements in the major diagonal is: " + sumMajorDiagonal(test));
	}
	public static double sumMajorDiagonal(double[][] array) {
		double sum = 0;
		for (int row = 0; row < array.length; row++) {
			sum += array[row][row];
		}
		return sum;
	}

}
