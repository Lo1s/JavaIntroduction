/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 27. 6. 2014 2014 10:03:06 
 */
public class PE902 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter two strings: ");
		String subString = input.nextLine();
		String inputString = input.nextLine();
		
		System.out.print("Is the first string a substring of the second one ? " + isSubstring(subString, inputString));
	}
	public static boolean isSubstring(String subString, String inputString) {
		for (int i = 0; i < inputString.length(); i++) {
			if ((i + subString.length() <= inputString.length()) && subString.charAt(0) == inputString.charAt(i)) {
				for (int j = 0; j < subString.length(); j++) {
					if (inputString.charAt(i + j) != subString.charAt(j))
						break;
					else if (j == subString.length() - 1 && subString.charAt(subString.length() - 1) == inputString.charAt(j + i))
						return true;
				}
			}
		}
		return false;
	}
}
