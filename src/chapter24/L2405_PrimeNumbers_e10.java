/**
 * 
 */
package chapter24;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 22. 1. 2015 2015 12:53:08 
 */
public class L2405_PrimeNumbers_e10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Find all prime numbers <= n, enter n: ");
		int n = input.nextInt();
		
		final int NUMBER_PER_LINE = 10;
		int count = 0; // count the number of prime numbers
		int number = 2; // a number to be tested for primeness
		
		System.out.println("The prime numbers are: ");
		
		// Repeatedly find the prime numbers
		while (number <= n) {
			// Assume the number is prime
			boolean isPrime = true; // is the current number prime ?
			
			// Test if number is prime
			for (int divisor = 2; divisor <= (int)(Math.sqrt(number)); divisor++) {
				if (number % divisor == 0) { // If true number is not prime
					isPrime = false;
					break;
				}
			}
			
			// Print the prime number and increase the count
			if (isPrime) {
				count++;
				
				if (count % NUMBER_PER_LINE == 0) {
					System.out.printf("%9d\n", number);
				}
				else
					System.out.printf("%9d", number);
			}
			
			// Check if the next number is prime
			number++;
		}
		
		System.out.println("\n" + count + " prime(s) less then or equal to " + n);
		input.close();
	}

}
