package chapter04;
/**
 * 
 */

/**
 * @author Jura
 *
 */
public class PE423 {

	/**
	 * 
	 */
	public PE423() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double leftToRight = 0;
		double rightToLeft = 0;
		double fragLR;
		double fragRL;
		for (int i = 1; i <= 50000; i++) {
			fragRL = 1/(double)i;
			rightToLeft = rightToLeft + fragRL;
			if (i == 50000) {
				System.out.println("Right to left is " + rightToLeft);
			}
		}
		
		for (int i = 50000; i >= 1; i--) {
			fragLR = 1/(double)i;
			leftToRight = leftToRight + fragLR;
			if (i == 1) {
				System.out.println("Left to right is: " + leftToRight);
			}
		}
		
	}

}
