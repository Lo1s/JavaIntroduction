package chapter02;
import java.util.Scanner;

public class PE220 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  System.out.print("Enter balance and interest rate(e.g., 3 for 3%): ");
  
  Scanner input = new Scanner(System.in);
  int balance = input.nextInt();
  double interestRate = input.nextDouble();

  double interest = balance * (interestRate / 1200);

  System.out.print("The interest is " + interest);
  }
}