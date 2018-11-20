import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Name: Olivier Lauzon
 * Student ID: 040918796
 * Course & Section: CST8132 303
 * Assignment: Lab 8
 * Date: Nov 19, 2018
 */

/**
 * Runs the main method that allows account operations - Utilizes ArrayList
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public class BankBonus {
	/**
	 * Name of the bank
	 */
	String bankName;
	
	/**
	 * Used to query for user input
	 */
	static Scanner input = new Scanner(System.in);
	
	/**
	 * Ensures proper printing format for the monetary values
	 */
	static DecimalFormat df = new DecimalFormat("#,###.##");
	
	/**
	 * Create an Array List for our accounts
	 */
	static ArrayList<Account> accounts = new ArrayList<Account>(4);

	/**
	 * Prompts the user to enter the values for the accounts
	 */
	public BankBonus() {
		input = new Scanner(System.in);
		System.out.print("Please enter the bank name: ");
		bankName = input.nextLine();
		
		Client client = new Client("John", "Smith", 123456789, "hello@hotmail.com");
		accounts.add(new ChequingAccount(client, 500));
		accounts.add(new ChequingAccount(client, 100));
		accounts.add(new SavingsAccount(client, 97));
		accounts.add(new SavingsAccount(client, 4000));
	}

	/**
	 * Prints the account information for all accounts in the bank
	 */
	public void printAccounts() {
		// this for loop prints all of the information related to all the accounts
		for (int i = 0; i < accounts.toArray().length; i++) {
			System.out.println(accounts.toArray()[i].toString());
		}
	}
	
	/**
	 * Processes all monthly transactions
	 * @throws Exception if the monthly fee cannot be charged
	 */
	public void monthlyProcess() throws Exception {
		for (Account i : accounts) {
			i.monthlyProcess();
		}
	}

	/**
	 * Runs the operations menu
	 * @param args Main method requirement
	 * @throws Exception if the monthly fee cannot be charged 
	 */
	public static void main(String[] args) throws Exception {
		BankBonus lab8 = new BankBonus();
		// this while loop lets the user do multiple operations until the quit command
		// is inputed
		int counter = 0;
		while (counter == 0) {
			System.out.print("\nP ---- Print Accounts\nW ---- Make a withdrawl\nD ---- Make a deposit\nM ---- Monthly Process\nQ ---- Quit\n");
			String choice = input.next();
			switch (choice.toUpperCase()) {

			// this case will print the client's account information
			case "P":
				lab8.printAccounts();
				break;

			// this case withdraws money from the desired account
			case "W":
				System.out.print("\nFrom which account would you like to withdraw?: ");
				int index = input.nextInt() - 1;
				System.out.print("How much would you like to withdraw?: ");
				if (((Account) accounts.toArray()[index]).withdraw(input.nextDouble()) == false) {
					System.out.println("Insufficient Funds! Balance is " + df.format(((Account) accounts.toArray()[index]).getBalance()) + ".");
				}
				break;

			// this case deposits money into the desired account
			case "D":
				System.out.print("\nInto which account would you like to deposit?: ");
				index = input.nextInt() - 1;
				System.out.print("How much would you like to deposit?: ");
				((Account) accounts.toArray()[index]).deposit(input.nextDouble());
				break;
				
			case "M":
				lab8.monthlyProcess();
				break;

			// this case quit's the bank interface
			case "Q":
				System.out.print("\nThank you for your business");
				counter = 1;
				break;

			// this case is for invalid inputs and prompts the user for a different input
			default:
				System.out.println("Invalid selection. Please try again.");
				break;
			}
		}
	}
}
