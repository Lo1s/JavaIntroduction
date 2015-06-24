package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */

import javax.swing.JOptionPane;
public class PE430 {

	/**
	 * 
	 */
	public PE430() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String amountString = JOptionPane.showInputDialog(null, "Enter a saving amount: ", "Savings Amount", JOptionPane.QUESTION_MESSAGE);
		double amount = Double.parseDouble(amountString);
		String interestRateString = JOptionPane.showInputDialog(null, "Enter the annual interest rate: ", "Interest Rate", JOptionPane.QUESTION_MESSAGE );
		double interestRateP = Double.parseDouble(interestRateString);
		double interestRate = (double)interestRateP / 1200;
		String numberOfmonthsString = JOptionPane.showInputDialog(null, "Enter number of months of your savings plan: ", "Time table", JOptionPane.QUESTION_MESSAGE);
		int numberOfMonths = Integer.parseInt(numberOfmonthsString);
		double savings = 0;
		
		int i = 1;
		while (i <= numberOfMonths) {
			savings = (amount + savings) * (1 + interestRate);
			i++;
		}
		System.out.print("For the amount of " + amount + " for " + numberOfMonths + " months the savings will be: ");
		System.out.printf("%6.2f", savings);

	}

}
