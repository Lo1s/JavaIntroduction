/**
 * 
 */
package chapter15;

import java.math.BigInteger;

/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 10:21:37 
 */
public class PE1517_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1517_RationalWithBigInteger r1 = new PE1517_RationalWithBigInteger(new BigInteger("4"), new BigInteger("2"));
		PE1517_RationalWithBigInteger r2 = new PE1517_RationalWithBigInteger(new BigInteger("2"), new BigInteger("3"));
		System.out.println((new StringBuilder()).append(r1).append(" + ").append(r2).append(" = ").append(r1.add(r2)).toString());
		System.out.println((new StringBuilder()).append(r1).append(" - ").append(r2).append(" = ").append(r1.subtract(r2)).toString());
		System.out.println((new StringBuilder()).append(r1).append(" * ").append(r2).append(" = ").append(r1.multiply(r2)).toString());
		System.out.println((new StringBuilder()).append(r1).append(" / ").append(r2).append(" = ").append(r1.divide(r2)).toString());
		System.out.println((new StringBuilder()).append(r2).append(" is ").append(r2.doubleValue()).toString());
	}

}
