/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 27. 6. 2014 2014 11:02:36 
 */
public class PE905 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String s = input.nextLine();
		int[] counts = counts(s);
		
		for (int i = 0; i <= 10; i++) {
			if (counts[i] > 0)
				System.out.println("Occurence of the " + i + " is: " + counts[i]);
		}
	}
	// Counts the occurences of all digits within the string
	public static int[] counts(String s) {
		int[] counts = new int[11];
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)))
				counts[(s.charAt(i)) - '0']++;
		}
		return counts;
	}

}
