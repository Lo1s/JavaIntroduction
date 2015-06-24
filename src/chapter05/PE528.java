/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
public class PE528 {

	/**
	 * 
	 */
	public PE528() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mersennePrime = 0;
		System.out.println(" p" + "      " + "2^p - 1\n");
		for (int p = 2; p <= 31; p++) {
			mersennePrime = ((int)Math.pow(2, p) - 1);
			if (hdR.mtd.isPrime(p) && hdR.mtd.isPrime(mersennePrime))
				System.out.printf("%2d%10d\n", p, mersennePrime);
		}

	}

}
