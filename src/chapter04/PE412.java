/**
 * 
 */
package chapter04;

/**
 * @author Jura
 *
 */
public class PE412 {

	/**
	 * 
	 */
	public PE412() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter = 0;
		double result = 0;
		for (int n = 0; counter < 1; n++) {
			result = Math.pow(n, 2);
			if (result >= 12000) {
				counter++;
				System.out.println(n);
			}
		}

	}

}
