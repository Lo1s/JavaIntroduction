/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 26. 6. 2014 2014 9:52:17 
 */
public class L901 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.nextLine();
		
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
