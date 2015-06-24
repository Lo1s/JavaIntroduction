package chapter05;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE502 {

	/**
	 * 
	 */
	public PE502() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		long number = input.nextLong();
		System.out.print("The sum of all digits in " + number + " is: " + sumDigits(number));

	}
	
	public static int sumDigits(long number) {
		int sumDigits = 0;
		while (number != 0) {
			long digit = number % 10;
			number = number / 10;
			sumDigits += digit;
		}
		return sumDigits;
	}

}
