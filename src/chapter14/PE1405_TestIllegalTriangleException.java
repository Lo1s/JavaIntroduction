/**
 * 
 */
package chapter14;

/**
 * @author jslapnicka
 * @Date & @Time 21. 8. 2014 2014 12:09:17 
 */
public class PE1405_TestIllegalTriangleException {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IllegalTriangleException {
		// TODO Auto-generated method stub
		try {
		PE1405_IllegalTriangleException triangle = new PE1405_IllegalTriangleException(1, 2, 4);
		System.out.println(triangle.getArea());
		}
		catch (IllegalTriangleException ex) {
			System.out.println("Wrong input !");
		}
	}

}
