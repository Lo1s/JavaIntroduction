/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 4. 7. 2014 2014 13:55:40 
 */
public class PE930 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String s = input.nextLine();
		title(s);
		
	}
	// Changes the first character in a string to uppercase
	public static void title(String s) {
		StringBuilder builder = new StringBuilder(s);
		for (int i = 0; i < builder.length(); i++) {
			char ch = builder.charAt(i);
			if (i == 0 && Character.isLowerCase(ch) || (i > 0) && builder.charAt(i - 1) == ' ' && Character.isLowerCase(ch)) {
				builder.replace(i,  i + 1, Character.toUpperCase(ch) + "");
			}
		}
		System.out.println(builder.toString());
	}

}
