/**
 * 
 */
package chapter15;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 13:02:44 
 */
public class PE1519_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a first complex number: ");
		PE1519_ComplexClass c1 = new PE1519_ComplexClass(input.nextDouble(), input.nextDouble());

		System.out.print("Enter a second complex number: ");
		PE1519_ComplexClass c2 = new PE1519_ComplexClass(input.nextDouble(), input.nextDouble());
		c1.add(c2);
		c1.subtract(c2);
		c1.multiply(c2);
		c1.divide(c2);
		c1.abs();
		System.out.print(c1.log);
		input.close();
	}

}
