/**
 * 
 */
package chapter24;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 22. 1. 2015 2015 12:22:27 
 */
public class L2404_GCDEuclid_e10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first integer: ");
		int m = input.nextInt();
		System.out.print("Enter second integer: ");
		int n = input.nextInt();
		
		System.out.println("The greatest common divisor for " + m + " and " + n + " is " + gcd(m, n));	
		input.close();		
	}
	
	public static int gcd(int m, int n) {
		if (m % n == 0)
			return n;
		else
			return gcd(n, m % n);
	}

}
