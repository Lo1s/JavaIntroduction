/**
 * 
 */
package chapter14;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 18. 8. 2014 2014 14:23:12 
 */
public class L1405_InputMismatchExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		
		do {
			try {
				System.out.print("Enter an integer: ");
				int number = input.nextInt();
				
				System.out.println("The entered number is: " + number);
				continueInput = false;
			} catch (InputMismatchException ex) {
				System.out.println("Try again. (Incorrect input: an integer is required)");
				input.nextLine();
			}
		} while (continueInput);
		input.close();
	}

}
