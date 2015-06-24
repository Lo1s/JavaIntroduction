/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 26. 6. 2014 2014 10:45:31 
 */
public class L904 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.nextLine();
		
		System.out.print("Ignoring nonalphanumeric characters, is " + s + " a palindrome ? " + isPalindrome(s));
		
	}
	// Checks if the string is a palindrome
	public static boolean isPalindrome(String s) {
		String s1 = filter(s);
		String s2 = reverse(s1);
		return s1.equals(s2);
	}
	// Filters or non-alphanumeric characters
	public static String filter(String s) {
		StringBuilder filtered = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetterOrDigit(s.charAt(i))) {
				filtered.append(s.charAt(i));
			}
		}
		return filtered.toString();
	}
	// Reverse a string
	public static String reverse(String s) {
		StringBuilder reversed = new StringBuilder(s);
		reversed.reverse();
		return reversed.toString();
	}

}
