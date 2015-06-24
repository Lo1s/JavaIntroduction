/**
 * 
 */
package chapter22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author hydRa
 * @Date & @Time 17. 12. 2014 2014 10:59:38 
 */
public class PE2208_Lottery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lottery = 100 + (int)(Math.random() * ((999 - 100) + 1));
		ArrayList<Integer> lotteryList = new ArrayList<Integer>();
		ArrayList<Integer> guessList = new ArrayList<Integer>();

		// Creates the scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lottery pick (three digits): ");
		int guess = input.nextInt();
		input.close();

		// Get digits from lottery
		int lotteryDigit1 = lottery / 100;
		int lotteryDigit2 = (lottery % 100) / 10;
		int lotteryDigit3 = lottery % 10;
		lotteryList.add(lotteryDigit1);
		lotteryList.add(lotteryDigit2);
		lotteryList.add(lotteryDigit3);

		// Get digits from guess
		int guessDigit1 = guess / 100;
		int guessDigit2 = (guess % 100) / 10;
		int guessDigit3 = guess % 10;
		guessList.add(guessDigit1);
		guessList.add(guessDigit2);
		guessList.add(guessDigit3);

		// Sort the lists in order to know how many digits matched
		Collections.sort(lotteryList);
		Collections.sort(guessList);

		System.out.println("The lottery number is: " + lottery + " (" + lotteryDigit1 + "-" + lotteryDigit2 + "-" + lotteryDigit3 + ")");

		// Check the guess 
		if (guess == lottery) {
			System.out.print("Exact match: you win $10 000 !");
		} else if (lotteryList.equals(guessList)) {
			System.out.print("Match all digits: you win $3 000 !"); 
		} else if (lotteryList.containsAll(guessList.subList(0, 2))) {
			System.out.print("Matched two digits: you win $2 000 !");
		} else if (lotteryList.containsAll(guessList.subList(1, 3))) {
			System.out.print("Matched two digits: you win $2 000 !");
		} else if (guessDigit1 == lotteryDigit1 || guessDigit2 == lotteryDigit2 || guessDigit3 == lotteryDigit3 || guessDigit1 == lotteryDigit2 || guessDigit2 == lotteryDigit1 || guessDigit3 == lotteryDigit1 || guessDigit3 == lotteryDigit2 || guessDigit1 == lotteryDigit3 || guessDigit2 == lotteryDigit3) {
			System.out.print("Match one digit. you win $1 000 !");
		} else {
			System.out.println("Sorry, no match !");
		}

	}

	/** guessDigit1 == lotteryDigit1 && guessDigit2 == lotteryDigit3 && guessDigit3 == lotteryDigit2 ||
		             guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit1 && guessDigit3 == lotteryDigit3 ||
		             guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit3 && guessDigit3 == lotteryDigit1 ||
		             guessDigit1 == lotteryDigit3 && guessDigit2 == lotteryDigit1 && guessDigit3 == lotteryDigit2 ||
		             guessDigit1 == lotteryDigit3 && guessDigit2 == lotteryDigit2 && guessDigit3 == lotteryDigit1
	 */

}
