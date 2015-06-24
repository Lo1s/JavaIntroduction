/**
 * 
 */
package chapter04;

/**
 * @author Jura
 *
 */
import java.util.Scanner;
public class PE416 {

	/**
	 * 
	 */
	public PE416() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		int i = 2;
		while (i <= number) {
			if (number % i == 0) {
				number = number / i;
				System.out.print(i + " ");
			} else {
				i++;
			}
		}
		input.close();

	}

}
