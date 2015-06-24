/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 4. 7. 2014 2014 13:00:45 
 */
public class PE929 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
		String isbn = input.next();

		System.out.println(isbn(isbn));
	}
	// Calculates the 10th number of the ISBN
	public static String isbn(String isbn) {
		int number = 0;
		for (int i = 0; i < isbn.length(); i++) {
			if (i % 2 != 0)
				number += 3 * (isbn.charAt(i) - '0');
			else
				number += (isbn.charAt(i) - '0');
		}
		number = 10 - (number) % 10;

		if (number == 10)
			isbn += "0";
		else
			isbn += number;
		return isbn;
	}
}
