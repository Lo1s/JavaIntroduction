/**
 * 
 */
package chapter10;

import java.math.BigInteger;

/**
 * @author jslapnicka
 * @Date & @Time 15. 7. 2014 2014 10:11:56 
 */
public class PE1021 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger number = new BigInteger("0");
		number = number.add(BigInteger.valueOf(Long.MAX_VALUE));

		int count = 0;
		while (count != 10) {
			if(number.remainder(new BigInteger("5")).equals(BigInteger.ZERO) || number.remainder(new BigInteger("6")).equals(BigInteger.ZERO)) {
				System.out.println(number);
				count++;
			}
			number = number.add(BigInteger.ONE);
		}
	}

}
