/**
 * 
 */
package chapter24;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 22. 1. 2015 2015 11:08:44 
 */
public class L2402_ImprovedFibonacci_e10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an index for the Fibonacci number: ");
		int index = input.nextInt();
		
		// Find and display the Fibonacci number
		System.out.println("Fibonacci number at index " + index + " is " + fib(index));
		input.close();
	}
	
	public static long fib(long n) {
		long f0 = 0;	// for fib(0)
		long f1 = 1;	// for fib(1)
		long f2 = 1;	// for fib(2)
		
		if (n == 0)
			return f0;
		else if (n == 1)
			return f1;
		else if (n == 2)
			return f2;
		
		for (int i = 3; i <= n; i++) {
			f0 = f1;
			f1 = f2;
			f2 = f0 + f1;
		}
		
		return f2;
	}

}
