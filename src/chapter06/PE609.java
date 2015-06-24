/**
 * 
 */
package chapter06;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE609 {

	/**
	 * 
	 */
	public PE609() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ten number");
		double[] test = new double[10];
		
		for (int i = 0; i < test.length; i++) {
			System.out.print(i + 1 + ". number: ");
			test[i] = input.nextDouble();
		}
		
		System.out.println("The minimum value is: " + min(test));
	}
	
	public static double min(double[] array) {
		double min = array[0];
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i] < min)
				min = array[i];
		}
		return min;
	}

}
