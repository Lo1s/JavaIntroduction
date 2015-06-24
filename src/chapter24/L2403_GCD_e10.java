/**
 * 
 */
package chapter24;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 22. 1. 2015 2015 11:30:04 
 */
public class L2403_GCD_e10 {

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
		input.close();
		
		System.out.println("The greatest common divisor for " + m + " and " + n + " is " + gcd(m, n));
	}
	
	public static int gcd(int m, int n) {
		int gcd = 1;
		if (m % n == 0) return n;
		
		for (int k = n / 2; k >= 1; k--) {
			if (m % k == 0 && n % k == 0) {
				gcd = k;
				break;
			}
		}
		
		return gcd;
	}

}
