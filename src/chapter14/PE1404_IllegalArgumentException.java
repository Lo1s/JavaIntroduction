/**
 * 
 */
package chapter14;

import java.util.Date;

/**
 * @author jslapnicka
 * @Date & @Time 21. 8. 2014 2014 10:23:08 
 */
public class PE1404_IllegalArgumentException {

	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private Date loanDate;


	/* Default constructor */
	public PE1404_IllegalArgumentException() {
		this(2.5, 1, 1000);
	}

	/* Construct a loan with specified annual interest rate, number of years and amount of the loan */
	public PE1404_IllegalArgumentException(double annualInterestRate, int numberOfYears, double loanAmount) {
		setAnnualInterestRate(annualInterestRate);
		setNumberOfYears(numberOfYears);
		setLoanAmount(loanAmount);
		loanDate = new Date();
	}

	/* Return annual interest rate */
	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}

	/* Return number of years */
	public int getNumberfYears() {
		return this.numberOfYears;
	}

	/* Return loan amount */
	public double getLoanAmount() {
		return this.loanAmount;
	}

	/* Return annual interest rate */
	public void setAnnualInterestRate(double annualInterestRate) throws IllegalArgumentException {
		if (annualInterestRate <= 0)
			throw new IllegalArgumentException("Annual Interest rate <= 0");
		else
			this.annualInterestRate = annualInterestRate;		
	}

	/* Return number of years */
	public void setNumberOfYears(int numberOfYears) throws IllegalArgumentException {
		if (numberOfYears <= 0)
			throw new IllegalArgumentException("Number of Years <= 0");
		else
			this.numberOfYears = numberOfYears;
	}

	/* Set loan amount */
	public void setLoanAmount(double loanAmount) {
		if (loanAmount <= 0)
			throw new IllegalArgumentException("Loan Amount <= 0");
		else
			this.loanAmount = loanAmount;
	}

	/* Return monthly payment */
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		return monthlyPayment;
	}

	/* Return total payment */
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}

	/* Return date */
	public Date getLoanDate() {
		return loanDate;
	}

}