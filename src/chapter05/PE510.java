/**
 * 
 */
package chapter05;

/**
 * @author Jura
 *
 */
public class PE510 {

	/**
	 * 
	 */
	public PE510() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 2;
		int lineCheck = 0;
		while (number < 10000) {
			if (hdR.mtd.isPrime(number)) {
				System.out.print(number + " ");
				lineCheck++;
			}
			number++;
			if (lineCheck == 10) {
				System.out.println();
				lineCheck = 0;
			}
			
		}
	}

}
