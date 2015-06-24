package chapter04;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
public class PE432 {

	/**
	 * 
	 */
	public PE432() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int lotteryDigit1 = (int)(Math.random() * 10);
		  int lotteryDigit2 = (int)(Math.random() * 10);
		  
		  while (lotteryDigit1 == lotteryDigit2)
			  lotteryDigit2 = (int)(Math.random() *10);

		  // Creates the scanner
		  Scanner input = new Scanner(System.in);
		  System.out.print("Enter your lottery pick (two digits): ");
		  int guess = input.nextInt();

		  // Get digits from guess
		  int guessDigit1 = guess / 10;
		  int guessDigit2 = guess % 10;

		  System.out.println("The lottery number is: " + lotteryDigit1 + lotteryDigit2);

		  // Check the guess 
		  if (guessDigit1 == lotteryDigit1 && guessDigit2 == lotteryDigit2 || guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit1 ) {
		    System.out.print("Exact match: you win $10 000 !");
		  } else if (guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit1) {	// check if only one statement is printed to the console
		    System.out.print("Match all digits: you win $3 000 !");
		  } else if (guessDigit1 == lotteryDigit1 || guessDigit2 == lotteryDigit2 || guessDigit1 == lotteryDigit2 || guessDigit2 == lotteryDigit1) {
		    System.out.print("Match one digit. you win $1 000 !");
		  } else {
		    System.out.println("Sorry, no match !");
		  }

	}

}
