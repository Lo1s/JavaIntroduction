/**
 * 
 */
package chapter14;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 21. 8. 2014 2014 13:17:00 
 */
public class PE1407_NumberFormatException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a binary string: ");
		String s = input.nextLine();
		input.close();
		try {
			for (int i = 0; i < s.length(); i++) {
				if (!Character.isDigit(s.charAt(i)))
					throw new NumberFormatException();
				if ((Character.getNumericValue(s.charAt(i)) < 0) || (Character.getNumericValue(s.charAt(i)) > 1))
					throw new NumberFormatException();
			}
			System.out.print(binaryToDecimal(s));
		}
		catch (NumberFormatException ex) {
			System.out.println("Only digits 0 & 1 are allowed !");
		}

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