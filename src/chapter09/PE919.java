/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 1. 7. 2014 2014 12:05:25 
 */
public class PE919 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter two strings: ");
		String s1 = input.next();
		String s2 = input.next();
		
		System.out.print("The common prefix is: " + prefix(s1, s2));
	}
	// Returns the common prefix of two Strings
	public static String prefix(String s1, String s2) {
		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < (s1.length() > s2.length() ? s1.length() : s2.length()); i++) {
			if (s1.charAt(i) == s2.charAt(i))
				prefix.append(s1.charAt(i));
			else
				return prefix.toString();
		}
		return prefix.toString();
	}
}
