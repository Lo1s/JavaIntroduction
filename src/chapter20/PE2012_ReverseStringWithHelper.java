/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 13:05:28 
 */
public class PE2012_ReverseStringWithHelper {

	public static void reverseDisplay(String s) {
		reverseDisplay(s, s.length() - 1);
	}
	
	public static void reverseDisplay(String s, int high) {
		if (s.length() <= 1)
			System.out.print(s);
		else {
			System.out.print(s.charAt(high));
			reverseDisplay(s.substring(0, high--));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseDisplay("Mississippi");
		System.out.println();
		reverseDisplay("Mississippi", 5);
	}

}
