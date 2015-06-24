/**
 * 
 */
package chapter10;

import java.math.BigInteger;

/**
 * @author jslapnicka
 * @Date & @Time 14. 7. 2014 2014 14:05:14 
 */
public class PE1018 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger max = new BigInteger("0");
		max = max.add(BigInteger.valueOf(Long.MAX_VALUE));
		int count = 0;

		for (BigInteger i = new BigInteger("2"); count != 5; i = i.add(BigInteger.ONE)) {
			for (BigInteger j = new BigInteger("2"); j.compareTo(i) <= 0; j = j.add(BigInteger.ONE)) {
				if (!i.equals(j) && i.remainder(j).equals(BigInteger.ZERO))
					break;
				else if (i.equals(new BigInteger("2")) || j.equals(i.subtract(BigInteger.ONE))) {
					System.out.print(i + " ");
					count++;
				}
			}
		}
	}

}
