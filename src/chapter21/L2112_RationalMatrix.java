/**
 * 
 */
package chapter21;

import chapter15.L1513_Rational;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 10:18:53 
 */
public class L2112_RationalMatrix extends L2110_GenericMatrix<L1513_Rational> {
	
	@Override /** Add two rational numbers */
	protected L1513_Rational add(L1513_Rational r1, L1513_Rational r2) {
		return r1.add(r2);
	}
	
	@Override /** Multiply two rational numbers */
	protected L1513_Rational multiply(L1513_Rational r1, L1513_Rational r2) {
		return r1.multiply(r2);
	}
	
	@Override /** Specify zero for the Rational number */
	protected L1513_Rational zero() {
		return new L1513_Rational(0, 1);
	}
	
}
