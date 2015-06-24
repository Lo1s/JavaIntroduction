/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 30. 6. 2014 2014 8:02:13 
 */
public class PE911 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.nextLine();
		
		System.out.print(sort(s));		
	}
	// Sort the characters inside the passed String
	public static String sort(String s) {
		char[] charArray = s.toCharArray();
		char temp = 'a';
		int tempIndex = 0;
		for (int i = 0; i < charArray.length; i++) {
			char min = charArray[i];
			for (int j = i; j < charArray.length; j++) {
				if (min > charArray[j]) {
					min = charArray[j];
					tempIndex = j;
				}
			}
			if (min < charArray[i]) {
				temp = charArray[i];
				charArray[i] = min;
				charArray[tempIndex] = temp;
			}
		}
		StringBuilder sorted = new StringBuilder();
		for (int i = 0; i < charArray.length; i++)
			sorted.append(charArray[i]);
		return sorted.toString();
	}
}
