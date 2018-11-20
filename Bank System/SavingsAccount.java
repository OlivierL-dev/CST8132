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
 * Specifies a savings account with an interest rate
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public class SavingsAccount extends Account{
	/**
	 * The interest rate
	 */
	public double interestRate = new Random().nextDouble() * 2 + 3;
	
	/**
	 * Creates an account of type Savings
	 * @param client The owner of the account
	 * @param balance balance of the account
	 */
	public SavingsAccount(Client client, double balance) {
		super(client, balance);
	}

	/**
	 * Deducts the monthly fee
	 * @throws Exception If there is not enough money to pay the fee
	 */
	@Override
	public void monthlyProcess() {
		deposit(balance * (0.01 * interestRate));
	}
	
	/**
	 * Returns the account info with monthly process
	 * @return String Account info with monthly process
	 */
	@Override
	public String toString() {
		return(super.toString() + " | Interest Rate: " + df.format(interestRate) + "%");
	}
}
