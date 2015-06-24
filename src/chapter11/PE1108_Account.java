/**
 * 
 */
package chapter11;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author jslapnicka
 * @Date & @Time 18. 7. 2014 2014 15:09:14 
 */
public class PE1108_Account {
	/** Private data field */
	private int iD = 0;
	private String name;
	private double balance = 0;
	private double annualInterestRate = 0;	
	Date date = new Date();
	private String dateCreated;
	public ArrayList<PE1108_Transaction> transaction = new ArrayList<PE1108_Transaction>();
	private int count = 1;
	
	/** No-arg Constructor */
	public PE1108_Account() {
		// TODO Auto-generated constructor stub
		dateCreated = date.toString();
	}

	/** Constructor with specified id, balance and annual interest rate */
	public PE1108_Account(int newId, double newBalance, double newAnnualInterestRate) {
		iD = newId;
		balance = newBalance;
		annualInterestRate = newAnnualInterestRate / 100;
		dateCreated = date.toString();
	}
	
	/** Constructor with specified name, id and balance **/
	public PE1108_Account(int newID, String name, double balance) {
		this.iD = newID;
		this.name = name;
		this.balance = balance;
	}
	
	/** Withdraw method */
	public void withdraw(double amount) {
		balance = balance - amount;
		transaction.add(new PE1108_Transaction('W', amount, balance, (count++ + ". transaction")));
	}
	/** Deposit method */
	public void deposit(double amount) {
		balance = balance + amount;
		transaction.add(new PE1108_Transaction('D', amount, balance, (count++ + ". transaction")));
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return "ID: " + getiD()
				+ "\nName: " + getName()
				+ "\nAnnual Interest Rate: " + getAnnualInterestRate()
				+ "\nDate created: " + getDateCreated();
	}
	
}
