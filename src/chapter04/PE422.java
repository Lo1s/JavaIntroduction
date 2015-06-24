package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE422 {


	/**
	 * 
	 */
	public PE422() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Loan Amount: ");
		double amount = input.nextDouble();
		System.out.print("Number of years. ");
		double years = input.nextDouble();
		System.out.print("Annual Interest Rate: ");
		double interest = input.nextDouble();
		double monthlyInterestRate = interest / 1200;
		double balance = amount;
		double monthlyPayment = amount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
		double principal = 0;
		int i = 0;
		
		System.out.println("Payment#" + "\tInterest" + "\tPrincipal" + "\tBalance");	
		
		for (i = 1; i <= years * 12; i++) {
			interest = monthlyInterestRate * balance;
			principal = monthlyPayment - interest;
			balance = balance - principal;
			System.out.printf("%1d" + "\t\t%2.2f" + "\t\t%3.2f" + "\t\t%4.2f\n", i, interest, principal, balance);
			}		
	}

}
