/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
public class PE526 {

	/**
	 * 
	 */
	public PE526() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		int lineCheck = 0;
		while (count < 100) {
			for (int number = 2; count < 100; number++) {
				if (hdR.mtd.isPrime(number) && hdR.mtd.isPalidrome(number)) {
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
