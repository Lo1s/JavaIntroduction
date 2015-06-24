/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE725 {

	/**
	 * 
	 */
	public PE725() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 3-by-3 matrix entered row by row: ");
		double[][] matrix = new double[3][3];
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = input.nextDouble();
			}
		}
		System.out.print(isMarkovMatrix(matrix) ? "It is a markov matrix" : "It is not a markov matrix");
	}
	public static boolean isMarkovMatrix(double[][] array) {
		double sumColumn = 0;
		boolean[] isMarkov = new boolean[array.length];
		for (int column = 0; column < array.length; column++) {
			for (int row = 0; row < array[column].length; row++) {
				sumColumn += array[row][column];
			}
			if (sumColumn == 1) {
				isMarkov[column] = true;
			}
			sumColumn = 0;
		}
		for (int i = 0; i < isMarkov.length; i++) {
			if (!isMarkov[i])
				return false;
		}
		return true;

	}
}
