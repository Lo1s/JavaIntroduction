/**
 * 
 */
package chapter10;
import java.util.*;
/**
 * @author jslapnicka
 * @Date & @Time 7. 7. 2014 2014 10:44:16 
 */
public class L1001_TestLoan {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter annual interest rate, for example, 8.25: ");
		double annualInterestRate = input.nextDouble();
		
		System.out.println("Enter number of years as integer: ");
		int numberOfYears = input.nextInt();
		
		System.out.println("Enter loan amount, for example, 12000.95: ");
		double loanAmount = input.nextDouble();
		
		// Create a loan object
		L1002_Loan loan1 = new L1002_Loan(annualInterestRate, numberOfYears, loanAmount);
		
		System.out.println("The loan was created on " + loan1.getLoanDate() + "\n"
				+ "The monthly payment is: " + loan1.getMonthlyPayment() + "\n"
				+ "The total payment is: " + loan1.getTotalPayment());
	}

}
