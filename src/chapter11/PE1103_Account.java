/**
 * 
 */
package chapter11;

import java.util.Date;

/**
 * @author jslapnicka
 * @Date & @Time 17. 7. 2014 2014 9:16:56 
 */
public class PE1103_Account {
	/** Private data field */
	private int iD = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	Date date = new Date();
	private String dateCreated;
	
	/** No-arg Constructor */
	public PE1103_Account() {
		// TODO Auto-generated constructor stub
		dateCreated = date.toString();
	}
	
	/** Constructor with specified id, balance and annual interest rate */
	public PE1103_Account(int newId, double newBalance, double newAnnualInterestRate) {
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
	
	@Override
	public String toString() {
		return "Main Account:\n" + "ID: " + getiD() + "\nBalance: " + getBalance() + "\nCreated on: " + getDateCreated();
	}
		
}

class PE1103_CheckingAccount extends PE1103_Account {
	Date date = new Date();
	String dateCreated;
	double limit;
	
	public PE1103_CheckingAccount() {
		dateCreated = date.toString();
	}
	
	public PE1103_CheckingAccount(int newID, double newBalance, double newAnnualInterestRate, double newLimit) {
		super.setiD(newID);
		super.setBalance(newBalance);
		super.setAnnualInterestRate(newAnnualInterestRate);
		dateCreated = date.toString();
		limit = newLimit;
	}
	
	public double getLimit() {
		return limit;
	}
	
	public void setLimit(double newLimit) {
		this.limit = newLimit;
	}
	
	@Override
	public void withdraw(double amount) {
		if (amount <= super.getBalance() + limit)
			super.withdraw(amount);
		else
			System.out.println("You don't have sufficient funds on your account !");
	}
	
	@Override
	public String toString() {
		return "Checking Account:\n" + "ID: " + getiD() + "\nBalance: " + getBalance() + "\nCreated on: " + getDateCreated();
	}

}

class PE1103_SavingsAccount extends PE1103_Account {
	Date date = new Date();
	String dateCreated;
	
	public PE1103_SavingsAccount() {
		// TODO Auto-generated constructor stub
		dateCreated = date.toString();
	} 
	
	public PE1103_SavingsAccount(int newID, double newBalance, double newAnnualInterestRate) {
		super.setiD(newID);
		super.setBalance(newBalance);
		super.setAnnualInterestRate(newAnnualInterestRate);
		dateCreated = date.toString();
	}
	
	
	@Override
	public void withdraw(double amount) {
		if (amount <= super.getBalance())
			super.withdraw(amount);
		else
			System.out.println("You don't have sufficient funds on your account !");
	}
	
	@Override
	public String toString() {
		return "Savings Account:\n" + "ID: " + getiD() + "\nBalance: " + getBalance() + "\nCreated on: " + getDateCreated();
	}
}