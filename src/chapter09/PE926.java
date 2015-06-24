/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 4. 7. 2014 2014 7:48:02 
 */
public class PE926 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the first 9 digits of the ISBN number: ");
		String isbn = input.next();
		
		System.out.println("ISBN: " + tenthnumber(isbn) );
	}
	// Calculates the 10th number of the ISBN
	public static String tenthnumber(String isbn) {
		int number = 0;
		for (int i = 0; i < isbn.length(); i++) {
			number += (isbn.charAt(i) - '0') * (i + 1);
		}
		number %= 11;
		
		if (number == 10)
			isbn += "X";
		else
			isbn += number;
		return isbn;
	}

}
