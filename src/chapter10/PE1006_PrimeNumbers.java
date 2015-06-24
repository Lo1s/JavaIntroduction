/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 10:07:35 
 */
public class PE1006_PrimeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prime = 2;
		L1008_StackOfIntegers stack = new L1008_StackOfIntegers();

		while (prime <= 120) {
			boolean isPrime = true;
			for (int i = 2; i <= prime; i++) {
				if (prime % i == 0 && prime / i != 1) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				stack.push(prime);
			prime++;
		}

		while (stack.getSize() != 0)
			System.out.print(stack.pop() + " ");
	}

}
