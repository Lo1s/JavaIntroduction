/**
 * 
 */
package chapter05;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE537 {

	/**
	 * 
	 */
	public PE537() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		System.out.print("Enter the width: ");
		int width = input.nextInt();
		
		System.out.print("Formated number: " + format(number, width));
		
	}
	public static String format(int number, int width) {
		int numberPos = number;
		int countPos = 0;
		String output = ""; 
		while (numberPos != 0) {
			numberPos /= 10;
			countPos++;
		}
		if ((number / (Math.pow(10, width) / 10)) < 1) {
			for (int i = 1; i <= (width - countPos); i++) {
				output += "0";
			}
		}
		output += number; 
		return output;
	}

}
