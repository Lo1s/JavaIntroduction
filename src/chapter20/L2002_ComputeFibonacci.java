/**
 * 
 */
package chapter20;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 20. 11. 2014 2014 13:05:51 
 */
public class L2002_ComputeFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an index for Fibonacci number: ");
		int index = input.nextInt();
		
		// Find and display the Fibonacci number
		System.out.println("The Fibonacci number at index: " + index + " is " + fib(index));
		input.close();
	}
	
	public static long fib(int index) {
		if (index == 0)
			return 0;
		else if (index == 1)
			return 1;
		else
			return fib(index - 2) + fib(index - 1);
	}

}
