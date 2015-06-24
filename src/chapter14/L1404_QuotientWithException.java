/**
 * 
 */
package chapter14;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 18. 8. 2014 2014 12:51:31 
 */
public class L1404_QuotientWithException {

	/**
	 * @param args
	 */
	public static int quotient(int number1, int number2) {
		if (number2 == 0)
			throw new ArithmeticException("Devisor cannot be zero");
		
		return number1 / number2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		
		try {
			int result = quotient(number1, number2);
			System.out.println(number1 + " / " + number2 + " = " + result);
		} catch (ArithmeticException ex) {
			// TODO: handle exception
			System.out.println("Exception: an integer cannot be devided by zero");
		}
		
		System.out.println("Execution continues...");
		input.close();
	}

}
