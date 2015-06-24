package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;

public class PE421 {

	/**
	 * 
	 */
	public PE421() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Loan amount: ");
		double amount = input.nextInt();
		System.out.print("Number of Years: ");
		int years = input.nextInt();
		input.close();
		double increment = 1.000 / 8.000;
		double interestRate = 5.000;		
				
		System.out.println("Interest rate\t" + "Monthly Payment\t  " + "Total Payment" + "\n");
		
		while (interestRate <= 8.0) {
			double monthlyInterestRate = interestRate / 1200;
			double monthlyPayment = amount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
			double totalPayment = monthlyPayment * years * 12;

			System.out.printf("%2.3f%1s" + "\t\t%3.2f" + "\t\t  %5.2f\n", interestRate, "%", monthlyPayment, totalPayment);
			interestRate = interestRate + increment;
		}
		
		

	}

}
