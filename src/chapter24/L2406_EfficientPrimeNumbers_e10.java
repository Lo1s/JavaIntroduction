/**
 * 
 */
package chapter24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 22. 1. 2015 2015 13:55:36 
 */
public class L2406_EfficientPrimeNumbers_e10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Find all prime numbers <= n, enter n: ");
		int n = input.nextInt();
		
		// A list to hold prime numbers
		List<Integer> list = new ArrayList<Integer>();
		
		final int NUMBER_PER_LINE = 10;
		int count = 0;
		int number = 2;
		int squareRoot = 1;
		
		System.out.println("The prime numbers are \n");
		
		// Repeatedly find prime numbers
		while (number <= n) {
			boolean isPrime = true;
			
			if (squareRoot * squareRoot < number) squareRoot++;
			
			// Test whether number is prime
			for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
				if (number % list.get(k) == 0) {
					isPrime = false;
					break;
				}
			}
			
			// Print the prime number and increase the count
			if (isPrime) {
				count++;
				list.add(number);
				if (count % NUMBER_PER_LINE == 0) {
					System.out.println(number);
				}
				else
					System.out.print(number + " ");
			}
			
			// Check whether the next number is prime
			number++;
		}
		
		System.out.println("\n" + count + " prime(s) less than or equal to " + n);
		input.close();
	}

}
