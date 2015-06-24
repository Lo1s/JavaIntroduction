package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE438 {

	/**
	 * 
	 */
	public PE438() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.print("Enter an integer: ");
		int number = input.nextInt();
		int remainder = 0;
		String hexString = "";
		
		while (number != 0) {
			remainder = number % 16;
			if (remainder > 10) {
				switch (remainder) {
				case 10: hexString = "A" + hexString; break;
				case 11: hexString = "B" + hexString; break;
				case 12: hexString = "C" + hexString; break;
				case 13: hexString = "D" + hexString; break;
				case 14: hexString = "E" + hexString; break;
				case 15: hexString = "F" + hexString; break;
				}
			} else {
				hexString = remainder + hexString;
			}
			number = number / 16;		
		}
		System.out.print("The hexadecimal value is: " + hexString);
	}

}
