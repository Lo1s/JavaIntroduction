/**
 * 
 */
package chapter10;

import java.math.BigInteger;

/**
 * @author jslapnicka
 * @Date & @Time 7. 7. 2014 2014 15:30:26 
 */
public class L1011 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("50! is \n" + factorial(50));
	}
	public static BigInteger factorial(long n) {
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			result = result.multiply(new BigInteger(i + ""));
		}
		return result;
	}

}
