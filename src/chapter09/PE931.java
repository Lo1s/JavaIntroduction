/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 4. 7. 2014 2014 15:22:04 
 */
public class PE931 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String s = input.nextLine();
		
		System.out.println(swapCase(s));
	}
	// Swaps the lower case to upper case and vice versa
	public static String swapCase(String s) {
		StringBuilder builder = new StringBuilder(s);
		for (int i = 0; i < builder.length(); i++) {
			if (Character.isLowerCase(builder.charAt(i)))
				builder.replace(i, (i + 1), Character.toUpperCase(builder.charAt(i)) + "");
			else
				builder.replace(i, (i + 1), Character.toLowerCase(builder.charAt(i)) + "");
		}
		
		return builder.toString();
	}
}
