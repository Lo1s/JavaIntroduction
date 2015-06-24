/**
 * 
 */
package chapter14;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 21. 8. 2014 2014 13:50:28 
 */
public class PE1408_HexFormatException {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a hex: ");
		String hex = input.nextLine();
		input.close();
		try {
			System.out.print("The decimal value for a hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
		}
		catch (HexFormatException ex) {
			System.out.println("Wrong input, only chars and digits are allowed !");
		}

	}
	public static int hexToDecimal(String hex) throws HexFormatException {
		hex.toUpperCase();
		for (int i = 0; i < hex.length(); i++) {
			if (!Character.isLetter(hex.charAt(i)) && !Character.isDigit(hex.charAt(i)))
				throw new HexFormatException();
			if (Character.isLetter(hex.charAt(i)))
				if ((hex.charAt(i) < 'A') || (hex.charAt(i) > 'F'))
					throw new HexFormatException();
			if (Character.isDigit(hex.charAt(i)))
				if ((Character.getNumericValue(hex.charAt(i)) > 9) || (Character.getNumericValue(hex.charAt(i)) < 1))
					throw new HexFormatException();
		}		
		int decimal = 0;
		for (int i = 0; i < hex.length(); i++) {
			char ch = hex.charAt(i);
			decimal = decimal * 16 + hexCharToDecimal(ch);
		}
		return decimal;
	}

	public static int hexCharToDecimal(char ch) {
		if (ch >= 'A' && ch <= 'F')
			return 10 + ch - 'A';
		else
			return ch - '0';
	}

}


class HexFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HexFormatException() {
		System.out.println("The input is not a hex string");
	}
}