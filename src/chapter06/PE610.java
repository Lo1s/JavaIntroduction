/**
 * 
 */
package chapter06;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE610 {

	/**
	 * 
	 */
	public PE610() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ten numbers: ");
		double[] test = new double[10];
		
		for (int i = 0; i < test.length; i++) {
			System.out.print(i + 1 + ". number: ");
			test[i] = input.nextDouble();
		}
		
		System.out.println("--------------");
		System.out.println("The min index of the smallest element is: " + minIndex(test));
	}
	
	public static int minIndex(double[] array) {
		double min = 0;
		int minIndex = 0;
		for (int i = 1; i < array.length - 1; i++) {
			if (min > array[i]) {
				min = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

}
