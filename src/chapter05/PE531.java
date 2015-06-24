/**
 * 
 */
package chapter05;
import java.util.Scanner;

/**
 * @author Jura
 *
 */
public class PE531 {

	/**
	 * 
	 */
	public PE531() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a credit card number as a long integer: ");
		long number = input.nextLong();
		String output = "";
		
		if (PE531.isValid(number))
			output = "a valid";
		else
			output = "an invalid";
		
		// Visa, MasterCard, American Express, Discover as output
		int prefix;
		if (PE531.getDigit(number, 1) == 3)
			prefix = (int)PE531.getDigit(number, 2);
		else
			prefix = (int)PE531.getDigit(number, 1);
		
		if (prefix == 37)
			output += " American Express Credit Card.";
		else if (prefix == 4)
			output += " Visa Credit Card.";
		else if (prefix == 5)
			output += " MasterCard Credit Card.";
		else if (prefix == 6)
			output += " Discover Credit Card.";
		else 
			output += " Credit Card.";
		
		if (hdR.mtd.numberOfPos(number) == 16)
			System.out.print(number + " is " + output);
		else
			System.out.print("You have entered a wrong credit card number !");

	}
	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		int sumTheResults = PE531.sumOffOddPlace(number) + PE531.sumOfDoubleEvenPlace(number);
		if (sumTheResults % 10 == 0 && PE531.prefixMatched(number))
			return true;
		else
			return false;
	}
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		int digit = 0;
		int sum = 0;
		for (int i = 15; i > 0; i = i - 2) {
			digit = (int)(PE531.getDigit(number, i)) * 2;
			if (digit < 10)
				sum += digit;
			else if (digit >= 10) {
				sum += (digit / 10) + (digit % 10);
			}
		}
		return sum;		
	}
	/** Return sum of odd-place digits in number */
	public static int sumOffOddPlace(long number) {
		int sum = 0;
		for (int i = 16; i > 0; i = i - 2) {
			sum += PE531.getDigit(number, i);
		}
		return sum;
	}
	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number) {
		int prefix;
		if (PE531.getDigit(number, 1) == 3)
			prefix = (int)PE531.getDigit(number, 2);
		else
			prefix = (int)PE531.getDigit(number, 1);
		
		if (prefix == 37 || prefix == 4 || prefix == 5 || prefix == 6)
			return true;
		else
			return false;		
	}
	/** Return the number of digits in number */
	public static int numberOfPos(long number) {
		int countPos = 0;
		while (number != 0) {
			number /= 10;
			countPos++;
		}
		return countPos;
	}
	/** Return the first k number of digits from number. If the
	* number of digits in number is less than k, return number. */
	public static long getDigit(long number, int k) {
		long choppedNumber;
		if (hdR.mtd.numberOfPos(number) < k)
			return number;
		else {
			int numberOfDigits = (17 - k);
			choppedNumber = (number % (long)Math.pow(10, numberOfDigits)) / (long)Math.pow(10, numberOfDigits - 1);
		}	
		return choppedNumber;
	}
}
