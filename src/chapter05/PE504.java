/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE504 {

	/**
	 * 
	 */
	public PE504() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter an integer: ");
		int number = input.nextInt();
		
		System.out.print("Reversed number is: ");
		reverse(number);
	}
	
	public static void reverse(int number) {
		int reverse = 0;
		int digit = 0;
		while (number != 0) {
			digit = number % 10;
			number = number / 10;
			reverse = (reverse * 10) + digit;
		}
		System.out.print(reverse);
	}
	
	

}
