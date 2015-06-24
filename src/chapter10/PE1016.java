/**
 * 
 */
package chapter10;

import java.math.BigInteger;

/**
 * @author jslapnicka
 * @Date & @Time 14. 7. 2014 2014 12:30:46 
 */
public class PE1016 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger test = new BigInteger("10000000000000000000000000000000000000000000000000");
		int count = 0;
		BigInteger two = new BigInteger("2");
		BigInteger three = new BigInteger("3");
		
		while (count != 10) {
			if (test.remainder(two).equals(BigInteger.ZERO) || test.divide(three).equals(BigInteger.ZERO)) {
				System.out.println(test);
				count++;
			}
			test = test.add(BigInteger.ONE);
		}
		System.out.print("\nCounter: " + count);
	}

}
