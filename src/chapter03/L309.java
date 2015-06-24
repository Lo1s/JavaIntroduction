package chapter03;
import java.util.Scanner;

public class L309 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  int lottery = (int)(Math.random() * 100);

  // Creates the scanner
  Scanner input = new Scanner(System.in);
  System.out.print("Enter your lottery pick (two digits): ");
  int guess = input.nextInt();

  // Get digits from lottery
  int lotteryDigit1 = lottery / 10;
  int lotteryDigit2 = lottery % 10;

  // Get digits from guess
  int guessDigit1 = guess / 10;
  int guessDigit2 = guess % 10;

  System.out.println("The lottery number is: " + lottery);

  // Check the guess 
  if (guess == lottery) {
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
