/**
 * 
 */
package chapter06;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE605 {

	/**
	 * 
	 */
	public PE605() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		System.out.print("Enter ten numbers: ");
		int[] numbers = new int[10];
		boolean[] isUnique = new boolean[10];
		int counter = 0;

		for (int i = 0; i < numbers.length; i++) {
			int number = input.nextInt();
			if (!isUnique[number]) {
				numbers[counter] = number;
				isUnique[number] = true;
				counter++;
			}
		}
		
		System.out.print("The unique numbers are: ");
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > 0)
				System.out.print(numbers[i] + " ");
		}
	}
}
