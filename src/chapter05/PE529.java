/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
public class PE529 {

	/**
	 * 
	 */
	public PE529() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int twinPrime = 0;
		while (twinPrime < 1000) {
			for (int prime = 2; twinPrime < 1000; prime++) {
				twinPrime = prime + 2;
				if (hdR.mtd.isPrime(prime) && hdR.mtd.isPrime(twinPrime)) {
					System.out.println("(" + prime + ", " + twinPrime + ")");
				}
			}
		}

	}

}
