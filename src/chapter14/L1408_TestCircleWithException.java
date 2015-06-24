/**
 * 
 */
package chapter14;

/**
 * @author jslapnicka
 * @Date & @Time 18. 8. 2014 2014 16:00:56 
 */
public class L1408_TestCircleWithException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new L1407_CircleWithException(5);
			new L1407_CircleWithException(-5);
			new L1407_CircleWithException(0);
		}
		catch (IllegalArgumentException ex) {
			System.out.println(ex);
		}
		
		System.out.println("Number of objects created: " + L1407_CircleWithException.getNumberOfObjects());
	}

}
