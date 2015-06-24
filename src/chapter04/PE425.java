package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
public class PE425 {

	/**
	 * 
	 */
	public PE425() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double fractions;
		double pi = 0;
		for (int i = 1; i <= 100000; i++) {
			fractions = ((Math.pow(-1, i + 1))/((2 * i) - 1));
			pi += fractions;
			if (i == 10000)
				System.out.println("For i = 10 000, pi is: " + (4.0 * pi));
			else if (i == 20000)
				System.out.println("For i = 20 000, pi is: " + (4.0 * pi));
			else if (i == 100000)
				System.out.println("For i = 100 000, pi is: " + (4.0 * pi));
		}

	}

}
