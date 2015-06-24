/**
 * 
 */
package chapter10;

import java.util.Date;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 10:25:01 
 */
public class PE1007_ATM {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Creating 10 accounts into the array
		Account[] accounts = new Account[10]; 
		for (int i = 0; i < 10; i++) {
			accounts[i] = new Account(i, 100, 0);
		}
		
		// Loop for the ATM machine
		int shutdown = 0;
		while (shutdown == 0) {
			System.out.print("\nEnter an ID: ");
			int menu = 0;
			int id = input.nextInt();
			while (menu != 4) {
				if (id < 0 || id > 9) {
					System.out.println("Wrong ID !\n"
							+ "Correct ID range: 0 - 9");
					break;
				}
				printMenu();
				menu = input.nextInt();
				switch (menu) {
				case 1: System.out.println("The balance is " + accounts[id].getBalance()); 
						break;
				case 2: System.out.print("Enter an amount to withdraw: ");
						accounts[id].withdraw(input.nextDouble());
						break;
				case 3: System.out.print("Enter an amount to deposit: ");
						accounts[id].deposit(input.nextDouble());
						break;
				case 4: System.out.print("Shutdown the system ? Yes (1) / No (0): ");
						shutdown = input.nextInt();
						System.out.print("Good bye !");
				}
			}
		}
	}
	public static void printMenu() {
		// Title
		System.out.print("\nMain menu \n"
				+ "1: check balance\n"
				+ "2: withdraw\n"
				+ "3: deposit\n"
				+ "4: exit\n"
				+ "Enter a choice: ");
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