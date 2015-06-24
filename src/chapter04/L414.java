package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
public class L414 {

	/**
	 * 
	 */
	public L414() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int NUMBER_OF_PRIMES = 50;
		final int PRIMES_PER_LINE = 10;
		
		int count = 0;
		int number = 2;
		
		System.out.println("The first 50 prime numbers are:");
		
		while (count < NUMBER_OF_PRIMES) {
			boolean isPrime = true;
			
			for (int divisor = 2; divisor <= number / 2; divisor++) {
				  if (number % divisor == 0) {
					  isPrime = false;
					  break;
			      }
			}
			if (isPrime) {
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
