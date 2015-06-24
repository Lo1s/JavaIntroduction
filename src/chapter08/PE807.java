/**
 * 
 */
package chapter08;
import java.util.*;
/**
 * @author jslapnicka
 * @Date & @Time 11. 6. 2014 2014 13:51:27 
 */
public class PE807 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc = new Account(1122, 20000, 4.5);
		acc.withdraw(2500);
		acc.deposit(3000);
		System.out.println("Account ID: " + acc.getiD() + "\n"
				+ "Balance: " + acc.getBalance() + "\n"
				+ "Monthly interest: " + acc.getMonthlyInterest() + "\n"
				+ "Date: " + acc.getDateCreated());
	}

}

class Account {
	/** Private data field */
	private int iD = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	Date date = new Date();
	private String dateCreated;
	
	/** No-arg Constructor */
	public Account() {
		// TODO Auto-generated constructor stub
		dateCreated = date.toString();
	}
	
	/** Constructor with specified id, balance and annual interest rate */
	public Account(int newId, double newBalance, double newAnnualInterestRate) {
		iD = newId;
		balance = newBalance;
		annualInterestRate = newAnnualInterestRate / 100;
		dateCreated = date.toString();
	}
	/** Withdraw method */
	public void withdraw(double amount) {
		balance = balance - amount;
	}
	/** Deposit method */
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	/** Accessor for date created */
	public String getDateCreated() {
		return dateCreated;
	}
	/** Accessor for the monthly interest rate */
	public double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}
	/** Accessor for the monthly interest */
	public double getMonthlyInterest() {
		return balance * getAnnualInterestRate();
	}
	
	/**
	 * @return the iD
	 */
	public int getiD() {
		return iD;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setiD(int iD) {
		this.iD = iD;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the annualInterestRate
	 */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	/**
	 * @param annualInterestRate the annualInterestRate to set
	 */
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
		
}
