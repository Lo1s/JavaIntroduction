/**
 * 
 */
package chapter04;

/**
 * @author Jura
 *
 */
public class PE413 {

	/**
	 * 
	 */
	public PE413() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter = 0;
		int n = 0;
		int number = 0;
		while (counter < 1) {
			if (Math.pow(n, 3) < 12000) {
				number = n;
			} else
				counter++;
			n++;
		}
		System.out.println(number);

	}

}
