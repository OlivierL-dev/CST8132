import java.util.Random;

/*
 * Name: Olivier Lauzon
 * Student ID: 040918796
 * Course & Section: CST8132 303
 * Assignment: Lab 8
 * Date: Nov 19, 2018
 */

/**
 * A subclass of the Account class.
 * Specifies a checking account with a monthly fee
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public class ChequingAccount extends Account {
	/**
	 * The monthly fee
	 */
	public double monthlyFee = new Random().nextDouble() * 5 + 5;
	
	/**
	 * Creates an account of type Chequing
	 * @param client The owner of the account
	 * @param balance balance of the account
	 */
	public ChequingAccount(Client client, double balance) {
		super(client, balance);
	}

	/**
	 * Deducts the monthly fee
	 * @throws Exception If there is not enough money to pay the fee
	 */
	@Override
	public void monthlyProcess() throws Exception {
		
		try {
			if (monthlyFee > balance) {
				throw new Exception("Account #: " + getAccountNum() + " | Balance: " + getBalance() + " | Fee: " + df.format(monthlyFee));
			}
			withdraw(monthlyFee);
		} catch(Exception e) {
			System.err.println(e);
		}
		
	}
	
	/**
	 * Returns the account info with monthly process
	 * @return String Account info with monthly process
	 */
	@Override
	public String toString() {
		return(super.toString() + " | Monthly Fee: " + df.format(monthlyFee) + "$");
	}
}
