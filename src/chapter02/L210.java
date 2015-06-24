package chapter02;
import java.util.Scanner;

public class L210 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("Enter an amount, for example, 11,56: ");    
    double amount = input.nextDouble();
    
    int remainingAmount = (int)(amount * 100);
    
    int numberOfOneDollars = remainingAmount / 100;
    remainingAmount = remainingAmount % 100;
    
    int numberOfQuarters = remainingAmount / 25;
    remainingAmount = remainingAmount % 25;

    int numberOfDimes = remainingAmount / 10;
    remainingAmount = remainingAmount % 10;

    int numberOfNickles = remainingAmount / 5;
    remainingAmount = remainingAmount % 5;

    int numberOfPennies = remainingAmount;

    // Display the results

    
    System.out.println("Your amount " + amount + " consists of \n" + 
	"\t" + numberOfOneDollars + " dollars\n" +
	"\t" + numberOfQuarters + " quarters\n" +
	"\t" + numberOfDimes + " dimes\n" +
	"\t" + numberOfNickles + " nickels\n" +
	"\t" + numberOfPennies + " pennies");
  }
}
