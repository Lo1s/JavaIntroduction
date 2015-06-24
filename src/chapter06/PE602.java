/**
 * 
 */
package chapter06;
import java.util.Scanner;

/**
 * @author hydRa
 *
 */
public class PE602 {

	/**
	 * 
	 */
	public PE602() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 integers: ");
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt();
		}
		
		System.out.println("Input order: ");
		System.out.print(java.util.Arrays.toString(numbers));
		System.out.println("\n");
		System.out.println(java.util.Arrays.toString(hdR.mtd.reverse(numbers)));
		
	}

}
