/**
 * 
 */
package chapter06;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE608 {

	/**
	 * 
	 */
	public PE608() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ten numbers");
		double[] test = new double [10];
		
		for (int i = 1; i <= test.length; i++) {
			System.out.print(i + ". number: ");
			test[i - 1] = input.nextDouble();
		}
		
		System.out.println("The average is: " + average(test));
	}
	
	public static int average(int[] array) {
		int total = 0;
		int totalIndexes = array.length;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		
		return total / totalIndexes;
	}
	
	public static double average(double[] array) {
		double total = 0;
		int totalIndexes = array.length;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		
		return total / totalIndexes;
	}

}
