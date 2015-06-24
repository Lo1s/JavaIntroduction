/**
 * 
 */
package chapter06;
import java.util.Scanner;

/**
 * @author hydRa
 *
 */
public class PE603 {

	/**
	 * 
	 */
	public PE603() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the integers between 1 and 100: ");
		int[] numbers = new int[100];

		// Reading input until the 0 is entered
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt();
			if (numbers[i] == 0)
				break;
		}

		// Counting the occurence of the numbers
		int counter[] = new int[100];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > 0)
				counter[numbers[i]]++;
			else if (numbers[i] == 0)
				break;
		}

		String timeString = "";
		for (int i = 0; numbers[i] != 0; i++) {
			if (counter[numbers[i]] > 1) {
				timeString = " times";
			System.out.println(numbers[i] + " occurs " + counter[numbers[i]] + timeString);
			} else if (counter[numbers[i]] == 1){
				timeString = " time";
				System.out.println(numbers[i] + " occurs " + counter[numbers[i]] + timeString);
			}

			if (numbers[i] == 0)
				break;
			counter[numbers[i]] = 0;
		}
	}

}
