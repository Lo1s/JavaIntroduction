/**
 * 
 */
package chapter14;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 18. 8. 2014 2014 12:32:10 
 */
public class L1401_Quotient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		input.close();
		System.out.print(number1 + " / " + number2 + " = " + number1 / number2);
	}

}
