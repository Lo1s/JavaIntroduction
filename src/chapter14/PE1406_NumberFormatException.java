/**
 * 
 */
package chapter14;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 21. 8. 2014 2014 12:13:09 
 */
public class PE1406_NumberFormatException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a hex: ");
		String hex = input.nextLine();
		input.close();
		try {
			System.out.print("The decimal value for a hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
		}
		catch (NumberFormatException ex) {
			System.out.println("Wrong input, only chars and digits are allowed !");
		}

	}
	public static int hexToDecimal(String hex) throws NumberFormatException {
		for (int i = 0; i < hex.length(); i++) {
			if (!Character.isLetter(hex.charAt(i)) && !Character.isDigit(hex.charAt(i)))
				throw new NumberFormatException();
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
