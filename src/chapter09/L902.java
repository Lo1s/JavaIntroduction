/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 26. 6. 2014 2014 10:14:29 
 */
public class L902 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a hex: ");
		String hex = input.nextLine();
		
		System.out.print("The decimal value for a hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
	}
	public static int hexToDecimal(String hex) {
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
