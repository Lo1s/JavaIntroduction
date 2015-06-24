/**
 * 
 */
package chapter14;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 18. 8. 2014 2014 12:42:14 
 */
public class L1403_QuotientWithMethod {

	/**
	 * @param args
	 */
	
	public static int quotient(int number1, int number2) {
		if (number2 == 0) {
			System.out.print("Devisor cannot be zero");
			System.exit(1);
		}
		return number1 / number2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		
		int result = quotient(number1, number2);
		System.out.print(number1 + " / " + number2 + " = " + result);
		input.close();
	}

}
