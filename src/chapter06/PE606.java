/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE606 {

	/**
	 * 
	 */
	public PE606() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int NUMBER_OF_PRIMES = 50;
		final int PRIMES_PER_LINE = 10;
		
		int[] primeNumbers = new int[NUMBER_OF_PRIMES];
		
		int count = 0;
		int number = 2;
		
		System.out.println("The first 50 prime numbers are:");
		
		while (count < NUMBER_OF_PRIMES) {
			boolean isPrime = true;
			
			for (int i = 0; primeNumbers[i] <= Math.sqrt(number) && i < count; i++) {
				  if (number % primeNumbers[i] == 0) {
					  isPrime = false;
					  break;
			      }
			}
			if (isPrime) {
				primeNumbers[count] = number;
				count++;
				
				if (count % PRIMES_PER_LINE == 0) {
					System.out.println(number);
				} else 
					System.out.print(number + " ");
			}
			number++;
	   }
	}
}