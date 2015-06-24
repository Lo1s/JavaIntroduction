/**
 * 
 */
package chapter09;

/**
 * @author jslapnicka
 * @Date & @Time 30. 6. 2014 2014 9:10:01 
 */
public class PE913 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = args[0];
		
		if (isPalindrome(s))
			System.out.print(s + " is a palindrome.");
		else
			System.out.print(s + " is not a palindrome.");
	}
	public static boolean isPalindrome(String s) {
		int low = 0;
		int high = s.length() - 1;
		
		while (low < high) {
			if (s.charAt(low) != s.charAt(high))
				return false;
		low++;
		high--;
		}
		return true;
	}

}