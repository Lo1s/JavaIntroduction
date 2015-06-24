/**
 * 
 */
package chapter14;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 21. 8. 2014 2014 8:36:07 
 */
public class PE1402_InputMismatchException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		boolean falseInput = true;
		int sum = 0;
		int num1 = 0;
		int num2 = 0;
		while (falseInput) {
			System.out.print("Enter two integers: ");
			try {
				num1 = input.nextInt();
			}
			catch (InputMismatchException ex) {
				System.out.println(new StringBuilder("Wrong input: ").append(num1));
			}
			try {
				num2 = input.nextInt();
				sum = num1 + num2;
				falseInput = false;
			}
			catch (Exception ex) {
				System.out.println(new StringBuilder("Wrong input: ").append(num2));
				input.nextLine();
			}
		}
		input.close();
		System.out.print("The sum is: " + sum);
	}

}
