/**
 * 
 */
package chapter10;
import java.io.Serializable;
import java.util.*;

/**
 * @author jslapnicka
 * @Date & @Time 7. 7. 2014 2014 10:08:42 
 */
@SuppressWarnings("serial")
public class L1002_Loan implements Serializable {

	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private Date loanDate;
	
	
	/* Default constructor */
	public L1002_Loan() {
		this(2.5, 1, 1000);
	}
	
	/* Construct a loan with specified annual interest rate, number of years and amount of the loan */
	public L1002_Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
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
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;		
	}
	
	/* Return number of years */
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}
	
	/* Set loan amount */
	public void setLoanAmount(double loanAmount) {
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
