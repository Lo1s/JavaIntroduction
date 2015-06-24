/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 10:51:01 
 */
public class PE2009_ReverseString {

	public static void reverseDisplay(String s) {
		if (s.length() <= 1)
			System.out.print(s);
		else {
			System.out.print(s.charAt(s.length() - 1));
			reverseDisplay(s.substring(0, s.length() - 1));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseDisplay("Mississippi");
	}

}
