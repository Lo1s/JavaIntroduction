/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE614 {

	/**
	 * 
	 */
	public PE614() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(45, 75, 100, 1000));
	}

	public static int gcd(int... numbers) {
		int gcd = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			gcd = hdR.mtd.gcd(gcd, numbers[i]);
		}
		
		return gcd;
	}
}
