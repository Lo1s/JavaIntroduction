/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 27. 6. 2014 2014 14:29:06 
 */
public class PE908 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a binary string: ");
		String s = input.nextLine();
		
		System.out.print(binaryToDecimal(s));
	}
	// Converts a binary number to a decimal
	public static int binaryToDecimal(String binaryString) {
		int binaryToDecimal = 0;
		
		for (int i = 0; i < binaryString.length(); i++) {
			if (binaryString.charAt(i) == '1')
				binaryToDecimal += 1 * Math.pow(2, (binaryString.length() - 1 - i));
			else if (binaryString.charAt(i) == '0')
				binaryToDecimal += 0 * Math.pow(2, (binaryString.length() - 1 - 1));
				
		}
		return binaryToDecimal;
	}
}
