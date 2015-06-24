/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE712 {

	/**
	 * 
	 */
	public PE712() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your income: ");
		int income = input.nextInt();
		System.out.print("Enter your bracket\n"
				+ "0 for Single filler \n"
				+ "1 for Married jointly or qualifying widow(er) \n"
				+ "2 for Married separately \n"
				+ "3 for Head of the household ");
		int bracket = input.nextInt();

		// Creating array for a tax rates
		double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

		// Creating two-dimensional array for a brackets
		int[][] brackets = {
				{8350, 33950, 82250, 171550, 372950},   // Single filer
				{16700, 67900, 137050, 208851, 372950}, // Married jointly
				{8350, 33950, 68525, 104425, 186475}, 	// Married separately
				{11950, 45500, 117450, 190200, 372950} 	// Head of household
		};

		// Calculating the tax
		double tax = 0;

		for (int i = 1; i < brackets[0].length; i++) {
			if (income < brackets[bracket][0]) {
				tax = income * rates[0];
				break;
			}			
			if (income > brackets[bracket][i])
				tax += (brackets[bracket][i] - brackets[bracket][i - 1]) * rates[i];
			else {
				tax += (income - brackets[bracket][i - 1]) * rates[i];
				break;
			}
		}
		// Computing tax for the first bracket
		if (income > brackets[bracket][0])
			tax += brackets[bracket][0] * rates[0];
		// Computing tax for last bracket if necessary
		if (income > brackets[bracket][3])
			tax += (income - brackets[bracket][3]) * rates[5];

		System.out.print("The tax is: " + tax);
	}

}
