/**
 * 
 */
package chapter14;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 18. 8. 2014 2014 12:37:05 
 */
public class L1402_QuotientWithIf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		
		if (number2 != 0)
			System.out.print(number1 + " / " + number2 + " = " + number1/number2);
		else
			System.out.print("Devisor cannot be zero");
		input.close();
	}

}
