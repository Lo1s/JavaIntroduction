/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 30. 6. 2014 2014 8:50:58 
 */
public class PE912 {

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
		
		if (isAnagram(s1, s2))
			System.out.print("two strings are anagrams");
		else
			System.out.print("two strings are not anagrams");
	}
	// Checks if two words are anagrams (they include the same characters)
	public static boolean isAnagram(String s1, String s2) {
		String sorted1 = PE911.sort(s1);
		String sorted2 = PE911.sort(s2);
		return sorted1.equals(sorted2);
	}
}
