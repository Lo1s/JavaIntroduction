package chapter05;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class L508 {

	/**
	 * 
	 */
	public L508() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.print("Enter a decimal number: ");
		int decimal = input.nextInt();
		
		System.out.print("The hex number for decimal " + decimal + " is: " + decimalToHex(decimal));
	}
	
	public static String decimalToHex(int decimal) {
		String hex = "";
		
		while (decimal != 0) {
			int hexValue = decimal % 16;
			hex = toHexChar(hexValue) + hex;
			decimal = decimal / 16;
		}
		
		return hex;
	}
	
	public static char toHexChar(int hexValue) {
		if (hexValue <= 9 && hexValue >= 0)
			return (char)(hexValue + '0');
		else
			return (char)(hexValue - 10 + 'A');
	}

}
