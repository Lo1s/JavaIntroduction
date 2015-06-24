/**
 * 
 */
package chapter15;

import java.math.BigInteger;

/**
 * @author jslapnicka
 * @Date & @Time 9. 9. 2014 2014 7:58:49 
 */
public class PE1522_UseRational {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1517_RationalWithBigInteger result = new PE1517_RationalWithBigInteger();
		for (int i = 1; i <= 18; i++) {
			result = result.add(new PE1517_RationalWithBigInteger(new BigInteger((i - 1) + ""), new BigInteger(i + "")));
			// show iteration
			System.out.println(i + ". iteration");
		}
		System.out.print(result.doubleValue());
	}

}
