import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * Name: Olivier Lauzon
 * Student ID: 040918796
 * Course & Section: CST8132 303
 * Assignment: Lab 7
 * Date: Nov 19, 2018
 */

/**
 * Runs the main method that allows account operations
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public class Bank {

	/**
	 * Name of the bank
	 */
	public String bankName;
	
	Client client = new Client("Bill", "Johnson", 123456789, "hello@hotmail.com");
	
	/**
	 * Used to query for user input
	 */
	public static Scanner input;
	
	/**
	 * Scans the documents
	 */
	private static Scanner fileInput;
	
	/**
	 * Ensures proper printing format for the monetary values
	 */
	public static DecimalFormat df = new DecimalFormat("#,###.##");
	
	/**
	 * Create a generic array for our accounts
	 */
	public static GenericArray<Account> accounts;
	
	/**
	 * Formats the bank records for a text file 
	 */
	private static Formatter output;

	/**
	 * Prompts the user to enter the values for the accounts
	 */
	public Bank() {
		accounts = new GenericArray<Account>(4);
		input = new Scanner(System.in);
		System.out.print("Please enter the bank name: ");
		bankName = input.nextLine();
		
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
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println(accounts.get(i).toString());
		}
		
		openOutputFile();
		
		for (int i = 0; i < accounts.size(); i++) {
			Account acnt = (Account) accounts.get(i);
			String type = null;
			if(accounts.get(i) instanceof SavingsAccount) {
				type = "S";
			}
			else if(accounts.get(i) instanceof ChequingAccount){
				type = "C";
			}
			
			output.format("%s %s %d %s %s%n",type, acnt.getName(), acnt.getClient().phoneNum, acnt.getClient().email, df.format(acnt.getBalance()));
		}
		
		closeOutputFile();
	}
	
	/**
	 * Processes all monthly transactions
	 * @throws Exception if the monthly fee cannot be charged
	 */
	public void monthlyProcess() throws Exception {
		for (int i = 0; i < accounts.capacity(); i++) {
			((Account) accounts.tArray[i]).monthlyProcess();
		}
	}
	
	/**
	 * Opens the input file
	 */
	public void openInputFile() {
		try {
			fileInput = new Scanner(Paths.get("bankinput.txt"));
		} catch (IOException ioException) {
			System.err.println("Error opening file");
		}
	}
	
	/**
	 * Closes the input file
	 */
	public void closeInputFile() {
		if (fileInput != null) {
			fileInput.close();
		}
	}
	
	/**
	 * Opens the output file
	 */
	public void openOutputFile() {
		try {
			output = new Formatter("bankoutput.txt");
		}
		catch (SecurityException securityException){
			System.err.println("Write permission denied");
		}
		catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file");
		}
	}
	
	/**
	 * Closes the output file
	 */
	public void closeOutputFile() {
		if (output != null) {
			output.close();
		}
	}
	
	/**
	 * Prints the bank records contained in a file
	 */
	public void readRecords() {
		 if (fileInput == null) {
		      return;
		 }
		
		 try {
			while(fileInput.hasNext()) {
				String type = fileInput.next();
				String fName = fileInput.next();
				String lName = fileInput.next();
				long pNum = fileInput.nextLong();
				String email = fileInput.next();
				double balance = fileInput.nextDouble();
				Client tempClient = new Client(fName, lName, pNum, email);
				
				switch(type) {
					case "C":
						Account acct = new ChequingAccount(tempClient, balance);
						accounts.add(acct);
						break;
					case"S":
						Account act = new SavingsAccount(tempClient, balance);
						accounts.add(act);
						break;
					default:
						System.err.println("No such file type");
						break;
				}
			}
		}
		catch(NoSuchElementException noSuchElementException) {
			System.err.println("File improperly formed");
		}
		catch(IllegalStateException illegalStateException) {
			System.err.println("Error reading from file");
		}
	}
	
	/**
	 * Runs the operations menu
	 * @param args Main method requirement
	 * @throws Exception if the monthly fee cannot be charged 
	 */
	public static void main(String[] args) throws Exception {
		Bank lab8 = new Bank();
		// this while loop lets the user do multiple operations until the quit command
		// is inputed
		int counter = 0;
		while (counter == 0) {
			System.out.print("\nP ---- Print Accounts\nW ---- Make a withdrawl\nD ---- Make a deposit\nM ---- Monthly Process\nR ---- Read Records\nQ ---- Quit\n");
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
				if (((Account) accounts.tArray[index]).withdraw(input.nextDouble()) == false) {
					System.out.println("Insufficient Funds! Balance is " + df.format(((Account) accounts.tArray[index]).getBalance()) + ".");
				}
				break;

			// this case deposits money into the desired account
			case "D":
				System.out.print("\nInto which account would you like to deposit?: ");
				index = input.nextInt() - 1;
				System.out.print("How much would you like to deposit?: ");
				((Account) accounts.get(index)).deposit(input.nextDouble());
				break;
			
			//this case is to do the monthly process
			case "M":
				lab8.monthlyProcess();
				break;
			
			//this case is to read the input file and add its accounts to the list
			case "R":
				lab8.openInputFile();
				lab8.readRecords();
				lab8.closeInputFile();
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
