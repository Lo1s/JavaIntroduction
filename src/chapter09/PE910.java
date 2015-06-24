/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 30. 6. 2014 2014 7:49:31 
 */
public class PE910 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a decimal number: ");
		int value = input.nextInt();
		
		System.out.print(decimalToBinary(value));
	}
	// Converts the decimal value into the binary digit
	public static String decimalToBinary(int value) {
		StringBuilder binary = new StringBuilder();
		while (value > 0) {
			binary.append(value % 2);
			value /= 2;
		}
		
		binary.reverse();
		return binary.toString();
	}
}
