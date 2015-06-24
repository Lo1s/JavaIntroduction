/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 27. 6. 2014 2014 10:50:24 
 */
public class PE904 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = input.nextLine();
		System.out.print("Enter a character: ");
		char ch = input.nextLine().charAt(0);
		
		System.out.println("The occurence of the '" + ch + "' is: " + count(word, ch));
	}
	// Counts the occurence of the character in the given word
	public static int count(String word, char ch) {	
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == ch)
				count++;
		}
		return count;
	}

}
