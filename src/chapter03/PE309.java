package chapter03;
import java.util.Scanner;

public class PE309 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Please enter the first 9 digits of an ISBN as integer: ");
		int digits = input.nextInt();

		// check if input is 9 digits

		if (digits >= 000000000 && digits <= 999999999) {

			int firstDigit = digits / 100000000;
			int secondDigit = (digits % 100000000) / 10000000;
			int thirdDigit = (digits % 10000000) / 1000000;
			int fourthDigit = (digits % 1000000) / 100000;
			int fifthDigit = (digits % 100000) / 10000;
			int sixthDigit = (digits % 10000) / 1000;
			int seventhDigit = (digits % 1000) / 100;
			int eighthDigit = (digits % 100) / 10;
			int ninthDigit = (digits % 10);

			int tenthDigit = (firstDigit * 1 
					+ secondDigit * 2
					+ thirdDigit * 3
					+ fourthDigit * 4
					+ fifthDigit * 5
					+ sixthDigit * 6
					+ seventhDigit * 7
					+ eighthDigit * 8
					+ ninthDigit * 9) % 11;      

			if (tenthDigit != 10) {
				System.out.print("The ISBN-10 number is " + firstDigit + secondDigit +
						thirdDigit + fourthDigit + fifthDigit + sixthDigit + seventhDigit +
						eighthDigit + ninthDigit + tenthDigit);
			} else {
				System.out.print("The ISBN-10 number is " + firstDigit + secondDigit +
						thirdDigit + fourthDigit + fifthDigit + sixthDigit + seventhDigit +
						eighthDigit + ninthDigit + "X"); 
			}


				
		}


	}
}