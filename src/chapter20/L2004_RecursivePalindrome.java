/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 20. 11. 2014 2014 14:23:38 
 */
public class L2004_RecursivePalindrome {

	/**
	 * @param args
	 */
	
	public static boolean isPalindrome(String s) {
		return isPalindrome(s, 0, s.length() - 1);
	}
	
	public static boolean isPalindrome(String s, int low, int high) {
		if (high <= low)
			return true;
		else if (s.charAt(low) != s.charAt(high))
			return false;
		else
			return isPalindrome(s, low + 1, high - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Is moon a palindrome ? " + isPalindrome("moon"));
		System.out.println("Is noon a palindrome ? " + isPalindrome("noon"));
		System.out.println("Is a a palindrome ? " + isPalindrome("a"));
		System.out.println("Is aba a palindrome ? " + isPalindrome("aba"));
		System.out.println("Is ab a palindrome ? " + isPalindrome("ab"));
	}

}
