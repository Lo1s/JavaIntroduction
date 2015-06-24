package chapter05;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE503 {

	/**
	 * 
	 */
	public PE503() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.print("Please enter an integer: ");
		int number = input.nextInt();
		
		System.out.println("The reversed number is: " + reverse(number));
		System.out.println("The number is Palidrome: " + isPalidrome(number));

	}
	
	public static int reverse(int number) {
		int digit = 0;
		int reverse =0;
		while (number != 0) {
			digit = number % 10;
			number = number / 10;
			reverse = (reverse * 10) + digit;
		}
		return reverse;			
	}
	
	public static boolean isPalidrome(int number) {
		if (number == reverse(number))
			return true;
		else
			return false;
		
	}

}
