import java.text.DecimalFormat;
import java.util.Random;

/*
 * Name: Olivier Lauzon
 * Student ID: 040918796
 * Course & Section: CST8132 303
 * Assignment: Lab 7
 * Date: Nov 19, 2018
 */

/**
 * An abstract class that has all the tools and properties for an account
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public abstract class Account {

	/**
	 * Number of the account
	 */
	public long accountNum;
	
	/**
	 * Balance of the account
	 */
	public double balance;
	
	/**
	 * The client associated with the account
	 */
	public Client client;
	
	/**
	 * Ensures proper printing format for the monetary values
	 */
	 public static DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * This parameterized constructor holds the client information as well as the account information
	 * @param client Sets the client information
	 * @param balance Sets the balance of the account
	 */
	public Account(Client client, double balance) {
		this.client = client;
		this.balance = balance;
		this.accountNum = new Random().nextLong();
	}

	/**
	 * This method adds the desired amount of funds to the account balance
	 * @param amt Amount to deposit
	 */
	public void deposit(double amt) {
		balance += amt;
	}

	/**
	 * Withdraws the desired amount of funds from the account balance
	 * @param amt amount to withdraw
	 * @return True if the withdrawal was successful. False if it failed
	 */
	public boolean withdraw(double amt) {
		if (amt <= balance) {
			balance -= amt;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the account number for the account
	 * @return account number for the account
	 */
	public long getAccountNum() {
		return this.accountNum;
	}

	/**
	 * Returns the client information of the account holder
	 * @return the account owner
	 */
	public Client getClient() {
		return this.client;
	}

	/**
	 * Returns the balance of the account
	 * @return balance of the account
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * Returns the full name of the client
	 * @return full name of the client
	 */
	public String getName() {
		return client.getName();
	}
	
	/**
	 * Returns the entire account information
	 * @return String Entire account information
	 */
	@Override
	public String toString() {
		return ("Name: " + getName() + " | Phone#: " + getClient().getPhoneNum() + " | EMail: " + 
		getClient().getEmail() + " | Account#: " + getAccountNum() + " | Balance: " + df.format(getBalance()));
	}
	
	/**
	 * Processes the monthly transactions
	 * @throws Exception If there monthly fee cannot be charged
	 */
	public abstract void monthlyProcess() throws Exception;
}
