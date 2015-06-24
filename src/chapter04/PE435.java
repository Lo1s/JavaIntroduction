package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
public class PE435 {

	/**
	 * 
	 */
	public PE435() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double result = 0;
		for (int i = 2; i <= 625; i++) {
			double calc = 1 /(Math.sqrt(i - 1) + Math.sqrt(i));
			result += calc;
			if (i == 625) {
				System.out.print("\nThe n-1 is: " + (i - 1) + 
					"\n The n is: " + i + "\n" +
					"\n The result is:  " + result + 
					"\n_____________");
			}
		}

	}

}
