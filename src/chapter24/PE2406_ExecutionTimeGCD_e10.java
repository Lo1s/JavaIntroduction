/**
 * 
 */
package chapter24;

/**
 * @author jslapnicka
 * @Date & @Time 23. 1. 2015 2015 18:53:36 
 */
public class PE2406_ExecutionTimeGCD_e10 {

	/**
	 * @param args
	 */


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int INDEX = 47;
		int[] numbers = new int[INDEX];
		numbers[0] = 0;
		numbers[1] = 1;
		for (int i = 2; i < INDEX; i++) {
			numbers[i] = numbers[i - 1] + numbers[i - 2];
		}

		System.out.println("\t\t\t40\t41\t42\t43\t44\t45");
		System.out.println("-----------------------------------------------");
		System.out.print("Listing 23.2 GCD1");

		long[] executionTime = new long[6];

		for (int i = 40; i <= 45; i++) {
			long startTime = System.currentTimeMillis();
			gcd(numbers[i], numbers[i + 1]);
			executionTime[i - 40] = System.currentTimeMillis() - startTime;
		}

		for (int i = 0; i <= 5; i++) {
			System.out.print("\t" + executionTime[i]);
		}

		System.out.print("\nListing 23.3 GCD2");

		for (int i = 40; i <= 45; i++) {
			long startTime = System.currentTimeMillis();
			gcdEuclid(numbers[i], numbers[i + 1]);
			executionTime[i - 40] = System.currentTimeMillis() - startTime;
		}

		for (int i = 0; i <= 5; i++) {
			System.out.print("\t" + executionTime[i]);
		}
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

	public static int gcdEuclid(int m, int n) {
		if (m % n == 0) {
			return n;
		} else {
			return gcdEuclid(n, m % n);
		}

	}

}
