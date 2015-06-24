/**
 * 
 */
package chapter20;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 20. 11. 2014 2014 12:56:38 
 */
public class L2001_ComputeFactorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a nonnegative integer: ");
		int n = input.nextInt();
		
		// Display factorial
		System.out.println("Factorial of " + n + " is " + factorial(n));
		input.close();
	}
	
	public static long factorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

}
