/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
public class PE527 {

	/**
	 * 
	 */
	public PE527() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		int lineCheck = 0;
		int reversed = 0;
		while (count < 100) {
			for (int number = 13; count < 100; number++) {
				reversed = hdR.mtd.reverse(number);
				if (hdR.mtd.isPrime(number) && hdR.mtd.isPrime(reversed) ^ hdR.mtd.isPalidrome(number)) {
					System.out.print(number + " ");
					lineCheck++;
					count++;
				}
				if (lineCheck == 10) {
					System.out.println();
					lineCheck = 0;
				}
			}
		}

	}
}
