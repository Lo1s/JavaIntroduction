/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 27. 6. 2014 2014 14:01:49 
 */
public class PE907 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.nextLine().toUpperCase();
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i)))
				System.out.print(getNumber(s.charAt(i)));
			else
				System.out.print(s.charAt(i));
		}
	}
	// Converts a letter to a number
	public static int getNumber(char letter) {
		int number = 0;
		String[] keypad = {"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
		for (int i = 0; i < keypad.length; i++) {
			for (int j = 0; j < keypad[i].length(); j++) {
				if (keypad[i].charAt(j) == letter)
					number = i;
			}
		}
		return number;
	}
}
