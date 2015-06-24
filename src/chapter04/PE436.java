package chapter04;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
public class PE436 {

	/**
	 * 
	 */
	public PE436() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter the first 9 digits of an ISBN as integer: ");
		int digit = input.nextInt();
		int tenthDigit = 0;

		// check if input is 9 digits

		if (digit >= 000000000 && digit <= 999999999) {
			int firstDigit = digit / 100000000;
			System.out.print("The ISBN-10 number is " + firstDigit);
			int multiplier = 1;
			for (int count = 100000000; count >= 10; count = count / 10) {
				int digits = (digit % count) / (count / 10);
				multiplier++;
				tenthDigit += digits * multiplier; 
				System.out.print(digits);
			}
			tenthDigit = firstDigit + (tenthDigit % 11);
			
			if (tenthDigit == 10)
				System.out.print("X");
			else
				System.out.print(tenthDigit);
		
		} else {
		System.out.print("You have entered a wrong format. Try again !");
		}
	}

}
