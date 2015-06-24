package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
public class PE426 {

	/**
	 * 
	 */
	public PE426() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double e = 0;
		double factorial = 1;
		for (int i = 1; i <= 100000; i++) {
			factorial = 1;
			for (int j = i; j > 0; j--) {
				factorial *= j;
			}
			e += 1 / factorial;
			if (i == 10000)
				System.out.println("The e for i = " + i + " is: " + (1 + e));
			else if (i == 20000)
				System.out.println("The e for i = " + i + " is: " + (1 + e));
		}

	}

}
