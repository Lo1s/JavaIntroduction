/**
 * 
 */
package chapter09;

/**
 * @author jslapnicka
 * @Date & @Time 30. 6. 2014 2014 10:14:38 
 */
public class PE915 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter = 0;
		for (int i = 0; i < args[0].length(); i++) {
			if (args[0].charAt(i) >= 'A' && args[0].charAt(i) <= 'Z')
				counter++;
		}
		System.out.print("The number of upper case letters is: " + counter);
	}

}
