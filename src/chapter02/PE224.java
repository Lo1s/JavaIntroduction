package chapter02;
import java.util.Scanner;

public class PE224 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("Enter an amount (for example, 1156 is 11 dollars and 56 cents): ");    
    int amount = input.nextInt();
    
    int dollars = amount / 100;
    int cents = amount % 100;

    // Display the results

    
    System.out.println("Your amount " + amount + " consists of " + dollars + " dollars" + " and " + 
	cents + " cents.");

  }
}
