package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
public class PE420 {

	/**
	 * 
	 */
	public PE420() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int MAX_PRIME = 1000;
		final int PRIMES_PER_LINE = 8;
		
		int count = 0;
		int number = 2;
		
		System.out.println("The prime numbers in range of 2 - 1000 are:");
		
		while (count < MAX_PRIME && number <= 1000) {
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