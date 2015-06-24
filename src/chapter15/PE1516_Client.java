/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 9:18:36 
 */
public class PE1516_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1516_RationalRewritten r1 = new PE1516_RationalRewritten(4, 2);
		PE1516_RationalRewritten r2 = new PE1516_RationalRewritten(2, 3);
		
		// Display results
		System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
		System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
		System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
		System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
		System.out.println(r1 + " is " + r2 + " = " + r2.doubleValue());
	}

}
