/**
 * 
 */
package chapter24;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jslapnicka
 * @Date & @Time 2. 2. 2015 2015 14:50:59 
 */
public class PE2414_ExecutionTimeForPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\t\t\t8 000 000\t10 000 000\t12 000 000\t14 000 000\t16 000 000\t18 000 000");
		System.out.println("-----------------------------------------------");
		System.out.print("Listing 22.5");

		for (int i = 8000000; i <= 18000000; i += 2000000) {
			long startTime = System.currentTimeMillis();
			L2205(i);
			System.out.print("\t\t" + (System.currentTimeMillis() - startTime));
		}

		System.out.print("\nListing 22.6");

		for (int i = 8000000; i <= 18000000; i += 2000000) {
			long startTime = System.currentTimeMillis();
			L2206(i);
			System.out.print("\t\t" + (System.currentTimeMillis() - startTime));
		}

		System.out.print("\nListing 22.7");

		for (int i = 8000000; i <= 18000000; i += 2000000) {
			long startTime = System.currentTimeMillis();
			L2207(i);
			System.out.print("\t\t" + (System.currentTimeMillis() - startTime));
		}

	}

	public static void L2205(int n) {

		int number = 2; // a number to be tested for primeness

		// Repeatedly find the prime numbers
		while (number <= n) {
			// Assume the number is prime
			// Test if number is prime
			for (int divisor = 2; divisor <= (int)(Math.sqrt(number)); divisor++) {
				if (number % divisor == 0) { // If true number is not prime
					break;
				}
			}			
			// Check if the next number is prime
			number++;
		}
	}

	public static void L2206(int n) {		
		// A list to hold prime numbers
		List<Integer> list = new ArrayList<Integer>();

		int number = 2;
		int squareRoot = 1;

		// Repeatedly find prime numbers
		while (number <= n) {

			if (squareRoot * squareRoot < number) squareRoot++;

			// Test whether number is prime
			for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
				if (number % list.get(k) == 0) {
					break;
				}
			}			
			// Check whether the next number is prime
			number++;
		}
	}

	public static void L2207(int n) {

		boolean[] primes = new boolean[n + 1]; // Prime number sieve

		// Initialize primes[i] to true
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}

		for (int k = 2; k <= n / k; k++) {
			if (primes[k]) {
				for (int i = k; i <= n / k; i++) {
					primes[k * i] = false;
				}
			}
		}
	}
}
