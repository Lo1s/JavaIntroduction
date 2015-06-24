/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE507 {

	/**
	 * 
	 */
	public PE507() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("The amount invested: ");
		int investmentAmount = input.nextInt();
		System.out.print("Annual interest rate: ");
		int annualInterestRate = input.nextInt();
		double monthlyInterestRate = (double)annualInterestRate/1200;
				
		System.out.println("Years      Future Value");
		
		for (int year = 1; year <= 30; year++) {
			System.out.printf("%2d", year);
			System.out.printf("%20.2f\n", futureInvestmentValue(investmentAmount, monthlyInterestRate, year));
		}


	}
	
	public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int year) {
		double futureInvestmentValue = investmentAmount * Math.pow((1 + monthlyInterestRate), (year * 12));
		return futureInvestmentValue;
	}
	

}
