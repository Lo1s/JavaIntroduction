/**
 * 
 */
package chapter11;

import java.util.Date;

/**
 * @author jslapnicka
 * @Date & @Time 21. 7. 2014 2014 8:04:11 
 */
public class PE1108_Transaction extends PE1108_Account {
	private Date date;
	private char type;

	private double amount;
	private double balance;
	private String description;

	PE1108_Transaction(char type, double amount, double balance, String description) {
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the type
	 */
	public char getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(char type) {
		this.type = type;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "\nType of the transaction: " + (type == 'W' ? "Withdraw" : "Deposit")
				+ "\nAmount of the transaction: " + amount 
				+ "\nBalance: " + balance
				+ "\nDescription: " + description + "\n";
	}
}
