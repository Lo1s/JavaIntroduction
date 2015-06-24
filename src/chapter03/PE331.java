package chapter03;
import java.util.Scanner;

public class PE331 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);
  System.out.print("Enter the exchange rate from dollars to RMB: ");
  double exchangeRate = input.nextDouble();

  System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
  int conversion = input.nextInt();
  String value = "";

  if (conversion == 0) {
    value = "dollar";
  } else if (conversion == 1) {
    value = "RMB";
  } else {
    System.out.print("Incorrect input");
    System.exit(0);
  } 

  System.out.print("Enter the " + value + " amount: ");
  double amount = input.nextDouble();

  double convertedValue = 0; 

  if (conversion == 0) {
    convertedValue = amount * exchangeRate;
  } else if (conversion == 1) {
    convertedValue = amount / exchangeRate;
  }

    System.out.printf(amount + " yuan is $%.2f", convertedValue);
  }
}    