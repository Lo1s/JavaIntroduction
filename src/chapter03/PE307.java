package chapter03;
import java.util.Scanner;

public class PE307 {
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

    String dollar = "";
    String quarter = "";
    String dime = "";
    String nickel = "";
    String penny = "";

    if (numberOfOneDollars > 0) {
      dollar = "dollars";
    } else {
      dollar = "dollar";
    }

    if (numberOfQuarters > 0) {
      quarter = "quarters";
    } else {
      quarter = "quarterr";
    }    

    if (numberOfDimes > 0) {
      dime = "dimes";
    } else {
      dime = "dime";
    }

    if (numberOfNickles > 0) {
      nickel = "nickles";
    } else {
      nickel = "nickel";
    }

    if (numberOfPennies > 0) {
      penny = "pennies";
    } else {
      penny = "penny";
    }


    // Display the results

    if (numberOfOneDollars == 0 && numberOfQuarters == 0 && 
        numberOfDimes == 0 && numberOfNickles == 0 && numberOfPennies == 0) {
        System.out.println("You have entered a zero value !");

    } else if (numberOfOneDollars > 0 && numberOfQuarters > 0 && 
        numberOfDimes > 0 && numberOfNickles > 0 && numberOfPennies > 0) {
        System.out.println("Your amount " + amount + " consists of \n" + 
	"\t" + numberOfOneDollars + dollar + "\n" +
	"\t" + numberOfQuarters + quarter + "\n" +
	"\t" + numberOfDimes + dime + "\n" +
	"\t" + numberOfNickles + nickel + "\n" +
	"\t" + numberOfPennies + penny);
    }
  }
}
