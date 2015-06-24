/**
 * 
 */
package chapter04;

/**
 * @author Jura
 *
 */
public class PE415 {

	/**
	 * 
	 */
	public PE415() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter = 0;
		for (int i = 33; i <= 126; i++) {
			System.out.print((char)i + " ");
			counter++;
			if (counter == 10) {
				System.out.println();
				counter = 0;
			}
			
		}
		

	}

}
