package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE437 {

	/**
	 * 
	 */
	public PE437() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.println("Enter an integer: ");
		int number = input.nextInt();
		System.out.print("The binary value is: ");
	
		while (number / 2 != 0) {
			if (number % 2 == 1) 
				System.out.print("1 ");
			else if (number % 2 == 0)
				System.out.print("0 ");	
			number = number / 2;
		}
		System.out.print(number % 2);
	}

}
