/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 4. 9. 2014 2014 9:09:44 
 */
public class L1513_Rational extends Number implements Comparable<L1513_Rational> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Data fields for numerator and denominator
	  private long numerator = 0;
	  private long denominator = 1;

	  /** Construct a L1513_Rational with default properties */
	  public L1513_Rational() {
	    this(0, 1);
	  }

	  /** Construct a L1513_Rational with specified numerator and denominator */
	  public L1513_Rational(long numerator, long denominator) {
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

	  /** Add a L1513_Rational number to this L1513_Rational */
	  public L1513_Rational add(L1513_Rational secondL1513_Rational) {
	    long n = numerator * secondL1513_Rational.getDenominator() +
	      denominator * secondL1513_Rational.getNumerator();
	    long d = denominator * secondL1513_Rational.getDenominator();
	    return new L1513_Rational(n, d);
	  }

	  /** Subtract a L1513_Rational number from this L1513_Rational */
	  public L1513_Rational subtract(L1513_Rational secondL1513_Rational) {
	    long n = numerator * secondL1513_Rational.getDenominator()
	      - denominator * secondL1513_Rational.getNumerator();
	    long d = denominator * secondL1513_Rational.getDenominator();
	    return new L1513_Rational(n, d);
	  }

	  /** Multiply a L1513_Rational number to this L1513_Rational */
	  public L1513_Rational multiply(L1513_Rational secondL1513_Rational) {
	    long n = numerator * secondL1513_Rational.getNumerator();
	    long d = denominator * secondL1513_Rational.getDenominator();
	    return new L1513_Rational(n, d);
	  }

	  /** Divide a L1513_Rational number from this L1513_Rational */
	  public L1513_Rational divide(L1513_Rational secondL1513_Rational) {
	    long n = numerator * secondL1513_Rational.getDenominator();
	    long d = denominator * secondL1513_Rational.numerator;
	    return new L1513_Rational(n, d);
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
	    if ((this.subtract((L1513_Rational)(other))).getNumerator() == 0)
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
	  public int compareTo(L1513_Rational o) {
	    if (this.subtract(o).getNumerator() > 0)
	      return 1;
	    else if (this.subtract(o).getNumerator() < 0)
	      return -1;
	    else
	      return 0;
	  }
	}