/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 9:09:13 
 */
public class PE1516_RationalRewritten extends Number implements Comparable<PE1516_RationalRewritten> {
	private static final long serialVersionUID = 1L;
	// Data fields for numerator and denominator
	long[] r = new long[2];
	private long numerator = r[0];
	private long denominator = r[1];

	/** Construct a PE1516_RationalRewritten with default properties */
	public PE1516_RationalRewritten() {
		this(0, 1);
	}

	/** Construct a PE1516_RationalRewritten with specified numerator and denominator */
	public PE1516_RationalRewritten(long numerator, long denominator) {
		long gcd = gcd(numerator, denominator);
		this.numerator = ((denominator > 0) ? 1 : -1) * numerator / gcd;
		this.denominator = Math.abs(denominator) / gcd;
	}

	/** Find GCD of two numbers */
	private static long gcd(long n, long d) {
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;

		for (int k = 1; k <= n1 && k <= n2; k++) {
			if (n1 % k == 0 && n2 % k == 0) 
				gcd = k;
		}

		return gcd;
	}

	/** Return numerator */
	public long getNumerator() {
		return numerator;
	}

	/** Return denominator */
	public long getDenominator() {
		return denominator;
	}

	/** Add a PE1516_RationalRewritten number to this PE1516_RationalRewritten */
	public PE1516_RationalRewritten add(PE1516_RationalRewritten secondPE1516_RationalRewritten) {
		long n = numerator * secondPE1516_RationalRewritten.getDenominator() +
				denominator * secondPE1516_RationalRewritten.getNumerator();
		long d = denominator * secondPE1516_RationalRewritten.getDenominator();
		return new PE1516_RationalRewritten(n, d);
	}

	/** Subtract a PE1516_RationalRewritten number from this PE1516_RationalRewritten */
	public PE1516_RationalRewritten subtract(PE1516_RationalRewritten secondPE1516_RationalRewritten) {
		long n = numerator * secondPE1516_RationalRewritten.getDenominator()
				- denominator * secondPE1516_RationalRewritten.getNumerator();
		long d = denominator * secondPE1516_RationalRewritten.getDenominator();
		return new PE1516_RationalRewritten(n, d);
	}

	/** Multiply a PE1516_RationalRewritten number to this PE1516_RationalRewritten */
	public PE1516_RationalRewritten multiply(PE1516_RationalRewritten secondPE1516_RationalRewritten) {
		long n = numerator * secondPE1516_RationalRewritten.getNumerator();
		long d = denominator * secondPE1516_RationalRewritten.getDenominator();
		return new PE1516_RationalRewritten(n, d);
	}

	/** Divide a PE1516_RationalRewritten number from this PE1516_RationalRewritten */
	public PE1516_RationalRewritten divide(PE1516_RationalRewritten secondPE1516_RationalRewritten) {
		long n = numerator * secondPE1516_RationalRewritten.getDenominator();
		long d = denominator * secondPE1516_RationalRewritten.numerator;
		return new PE1516_RationalRewritten(n, d);
	}

	@Override  
	public String toString() {
		if (denominator == 1)
			return numerator + "";
		else
			return numerator + "/" + denominator;
	}

	@Override // Override the equals method in the Object class 
	public boolean equals(Object other) {
		if ((this.subtract((PE1516_RationalRewritten)(other))).getNumerator() == 0)
			return true;
		else
			return false;
	}

	@Override // Implement the abstract intValue method in Number 
	public int intValue() {
		return (int)doubleValue();
	}

	@Override // Implement the abstract floatValue method in Number 
	public float floatValue() {
		return (float)doubleValue();
	}

	@Override // Implement the doubleValue method in Number 
	public double doubleValue() {
		return numerator * 1.0 / denominator;
	}

	@Override // Implement the abstract longValue method in Number
	public long longValue() {
		return (long)doubleValue();
	}

	@Override // Implement the compareTo method in Comparable
	public int compareTo(PE1516_RationalRewritten o) {
		if (this.subtract(o).getNumerator() > 0)
			return 1;
		else if (this.subtract(o).getNumerator() < 0)
			return -1;
		else
			return 0;
	}
}