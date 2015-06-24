/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 27. 6. 2014 2014 11:16:11 
 */
public class PE906 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.nextLine();
		
		System.out.print("The number of letters in a string is: " + countLetters(s));
	}
	// Counts letters in a string
	public static int countLetters(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i)))
				count++;
		}
		
		return count;
	}

}
