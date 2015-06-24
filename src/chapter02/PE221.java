package chapter02;
import java.util.Scanner;

public class PE221 {
  @SuppressWarnings("resource")
public static void main(String[] args) {
  
  Scanner input = new Scanner(System.in);
  System.out.print("Enter investment amount: ");
  int investmentValue = input.nextInt();
  
  System.out.print("Enter annual interest rate in percentage: ");
  double annualInterestRate = input.nextDouble();
  double monthlyInterestRate = annualInterestRate / 1200D;

  System.out.print("Enter number of years: ");
  int numberOfyears = input.nextInt();

  double futureInvestmentValue = investmentValue * Math.pow((1.0D + monthlyInterestRate), numberOfyears * 12);

  System.out.print("Accumulated value is " + futureInvestmentValue);
  }
}