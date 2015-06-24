/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 27. 6. 2014 2014 15:19:40 
 */
public class PE909 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a binary string: ");
		String s = input.nextLine();

		System.out.print(binaryToHex(s));
	}
	// Converts a binary number to hexadecimal
	public static String binaryToHex(String binaryValue) {
		int binaryToDecimal = PE908.binaryToDecimal(binaryValue);
		StringBuilder hexValue = new StringBuilder();
		for (int i = binaryToDecimal; i > 0 ; i /= 16) {
			if (i % 16 > 9)
				hexValue.append((char)((i % 16 - 10) + 'A'));
			else
				hexValue.append(i % 16);
		}
		hexValue.reverse();
		return hexValue.toString();
	}

}
