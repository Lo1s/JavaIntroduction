/**
 * 
 */
package chapter10;

import java.math.BigInteger;

/**
 * @author jslapnicka
 * @Date & @Time 14. 7. 2014 2014 13:08:08 
 */
public class PE1017 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger nSquare = new BigInteger("2");
		BigInteger max = new BigInteger("0");
		max = BigInteger.valueOf(Long.MAX_VALUE);

		int count = 0;

		for (BigInteger i = new BigInteger("1"); count != 10; i = i.add(BigInteger.ONE)) {
			nSquare = nSquare.multiply(i);
			if (nSquare.compareTo(max) > 0) {
				System.out.println(nSquare);
				count++;
			}
		}
	}

}
