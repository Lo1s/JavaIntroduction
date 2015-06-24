/**
 * 
 */
package chapter09;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 2. 7. 2014 2014 10:09:45 
 */
public class PE923 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a credit card number: ");
		String cardNumber = input.next();
		
		System.out.print("Credit card is valid " + isValid(cardNumber));
	}
	/** Return true if the card number is valid */
	public static boolean isValid(String cardNumber) {
		int sumTheResults = sumOfOddPlace(cardNumber) + sumOfDoubleEvenPlace(cardNumber);
		if (sumTheResults % 10 == 0 && prefixMatched(cardNumber))
			return true;
		else
			return false;
	}
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(String cardNumber) {
		int digit = 0;
		int sum = 0;
		char[] number = cardNumber.toCharArray();
		for (int i = 14; i > 0; i = i - 2) {
			digit = (int)(getDigit((int)number[i])) * 2;
			if (digit < 10)
				sum += digit;
			else if (digit >= 10) {
				sum += (digit / 10) + (digit % 10);
			}
		}
		return sum;	
	}
	/** Return this number if it is a single digit; otherwise,
	 * return the sum of the two digits */
	public static int getDigit(int number) {
		if (number < 10)
			return number;
		else 
			return number % 10 + number / 10;
	}
	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(String cardNumber) {
		int sum = 0;
		char[] number = cardNumber.toCharArray();
		for (int i = 15; i > 0; i = i - 2) {
			sum += (int)number[i];
		}
		return sum;
	}
	public static boolean prefixMatched(String cardNumber) {		
		if (cardNumber.charAt(0) == '4')
			return true;
		else if (cardNumber.charAt(0) == '5')
			return true;
		else if (cardNumber.charAt(0) == '6')
			return true;
		else if (cardNumber.charAt(0) == '3' && cardNumber.charAt(1) == '7')
			return true;
		
		return false;		
	}
}
