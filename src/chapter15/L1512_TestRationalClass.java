/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 4. 9. 2014 2014 9:23:11 
 */
public class L1512_TestRationalClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		L1513_Rational r1 = new L1513_Rational(4, 2);
		L1513_Rational r2 = new L1513_Rational(2, 3);
		
		// Display results
		System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
		System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
		System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
		System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
		System.out.println(r1 + " is " + r2 + " = " + r2.doubleValue());
	}

}
