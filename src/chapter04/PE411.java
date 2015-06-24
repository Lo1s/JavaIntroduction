/**
 * 
 */
package chapter04;

/**
 * @author Jura
 *
 */
public class PE411 {

	/**
	 * 
	 */
	public PE411() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter = 0;
		for (int i = 100; i <= 200; i++) {
			if (i % 5 == 0 || i % 6 == 0) {
				System.out.print(i + " ");
				counter++;
			}
			if (counter == 10) {
				System.out.println();
				counter = 0;
			}
		}

	}
}
