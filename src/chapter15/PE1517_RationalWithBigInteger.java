/**
 * 
 */
package chapter15;

import java.math.BigInteger;

/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 9:20:48 
 */
public class PE1517_RationalWithBigInteger extends Number implements Comparable<PE1517_RationalWithBigInteger> {
	// Data fields for numerator and denominator

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BigInteger numerator;
	BigInteger denominator;

	/** Construct a PE1517_RationalWithBigInteger with default properties */
	public PE1517_RationalWithBigInteger() {
		this(BigInteger.ZERO, BigInteger.ONE);
	}

	/** Construct a PE1517_RationalWithBigInteger with specified numerator and denominator */
	public PE1517_RationalWithBigInteger(BigInteger numerator, BigInteger denominator) {
		this.numerator = BigInteger.ZERO;
		this.denominator = BigInteger.ONE;
		BigInteger gcd = gcd(numerator, denominator);
		if (denominator.compareTo(BigInteger.ZERO) < 0) {
			this.numerator = numerator.multiply(new BigInteger("-1").divide(gcd));
		} else {
			this.numerator = numerator.divide(gcd);
		}
		this.denominator = denominator.abs().divide(gcd);
	}

	/** Find GCD of two numbers */
	private static BigInteger gcd(BigInteger n, BigInteger d) {
		BigInteger n1 = n.abs();
		BigInteger n2 = d.abs();
		BigInteger gcd = BigInteger.ONE;

		for (BigInteger k = BigInteger.ONE; k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0; k = k.add(BigInteger.ONE)) {
			if (n1.remainder(k).equals(BigInteger.ZERO) && n2.remainder(k).equals(BigInteger.ZERO)) 
				gcd = k;
		}

		return gcd;
	}

	/** Return numerator */
	public BigInteger getNumerator() {
		return numerator;
	}

	/** Return denominator */
	public BigInteger getDenominator() {
		return denominator;
	}

	/** Add a PE1517_RationalWithBigInteger number to this PE1517_RationalWithBigInteger */
	public PE1517_RationalWithBigInteger add(PE1517_RationalWithBigInteger secondPE1517_RationalWithBigInteger) {
		BigInteger n = numerator.multiply(secondPE1517_RationalWithBigInteger.getDenominator()).add(denominator.multiply(secondPE1517_RationalWithBigInteger.getNumerator()));
		BigInteger d = denominator.multiply(secondPE1517_RationalWithBigInteger.getDenominator());
		return new PE1517_RationalWithBigInteger(n, d);
	}

	/** Subtract a PE1517_RationalWithBigInteger number from this PE1517_RationalWithBigInteger */
	public PE1517_RationalWithBigInteger subtract(PE1517_RationalWithBigInteger secondPE1517_RationalWithBigInteger) {
		BigInteger n = numerator.multiply(secondPE1517_RationalWithBigInteger.getDenominator()).subtract(denominator.multiply(secondPE1517_RationalWithBigInteger.getNumerator()));
		BigInteger d = denominator.multiply(secondPE1517_RationalWithBigInteger.getDenominator());
		return new PE1517_RationalWithBigInteger(n, d);
	}

	/** Multiply a PE1517_RationalWithBigInteger number to this PE1517_RationalWithBigInteger */
	public PE1517_RationalWithBigInteger multiply(PE1517_RationalWithBigInteger secondPE1517_RationalWithBigInteger) {
		BigInteger n = numerator.multiply(secondPE1517_RationalWithBigInteger.getNumerator());
		BigInteger d = denominator.multiply(secondPE1517_RationalWithBigInteger.getDenominator());
		return new PE1517_RationalWithBigInteger(n, d);
	}

	/** Divide a PE1517_RationalWithBigInteger number from this PE1517_RationalWithBigInteger */
	public PE1517_RationalWithBigInteger divide(PE1517_RationalWithBigInteger secondPE1517_RationalWithBigInteger) {
		BigInteger n = numerator.multiply(secondPE1517_RationalWithBigInteger.getDenominator());
		BigInteger d = denominator.multiply(secondPE1517_RationalWithBigInteger.numerator);
		return new PE1517_RationalWithBigInteger(n, d);
	}

	@Override  
	public String toString() {
		if(denominator.equals(BigInteger.ONE))	{
			return (new StringBuilder()).append(numerator).toString();
		} else	{
			return (new StringBuilder()).append(numerator).append("/").append(denominator).toString();
		}
	}

	@Override // Override the equals method in the Object class 
	public boolean equals(Object other) {
		 return subtract((PE1517_RationalWithBigInteger)other).getNumerator().equals(BigInteger.ONE);
	}

	 public int intValue()
     {
         return (int)doubleValue();
     }

     public float floatValue()
     {
         return (float)doubleValue();
     }

     public double doubleValue()
     {
         return numerator.doubleValue() / denominator.doubleValue();
     }

     public long longValue()
     {
         return (long)doubleValue();
     }
     
     public int compareTo(PE1517_RationalWithBigInteger o)
     {
         if(subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0)
         {
             return 1;
         }
         return subtract(o).getNumerator().compareTo(BigInteger.ZERO) >= 0 ? 0 : -1;
     }
}