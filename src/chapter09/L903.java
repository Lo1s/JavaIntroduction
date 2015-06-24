/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 26. 6. 2014 2014 10:35:09 
 */
public class L903 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.nextLine();
		
		int[] counts = countLetters(s.toLowerCase());
		
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > 0)
				System.out.println((char)('a' + i) + " appears " + counts[i] + ((counts[i] == 1) ? " time" : " times"));
		}
	}
	// Counts the occurence of the letters in the string
	public static int[] countLetters(String s) {
		int[] counts = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i)))
				counts[s.charAt(i) - 'a']++;
		}
		return counts;
	}

}
