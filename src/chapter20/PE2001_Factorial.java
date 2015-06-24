/**
 * 
 */
package chapter20;

import java.math.BigInteger;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 8:34:08 
 */
public class PE2001_Factorial {

	public static BigInteger factorial(BigInteger n) {
		if (n.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		else 
			return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}
	
	// Tail recursion (adding auxiliary parameters)
	public static BigInteger factorial(BigInteger n, BigInteger result) {
		if (n.equals(BigInteger.ZERO))
			return result;
		else
			return factorial(n.subtract(BigInteger.ONE), n.multiply(result));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(new BigInteger("100")) + "\n");
		
		System.out.println(factorial(new BigInteger("100"), new BigInteger("1")));		
	}

}
