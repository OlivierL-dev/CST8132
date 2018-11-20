/*
 * Name: Olivier Lauzon
 * Student ID: 040918796
 * Course & Section: CST8132 303
 * Assignment: Lab 8
 * Date: Nov 19, 2018
 */

/**
 * Contains the contact information of a client
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public class Client {
	/**
	 * The clients first name
	 */
	String firstName;
	
	/**
	 * The clients last name
	 */
	String lastName;
	
	/**
	 * The clients phone number
	 */
	long phoneNum;
	
	/**
	 * The clients email
	 */
	String email;

	/**
	 * Parameterized constructor that hold all the client information
	 * @param firstName First name
	 * @param lastName Last name
	 * @param phoneNum Phone number
	 * @param email Email address
	 */
	public Client(String firstName, String lastName, long phoneNum, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	/**
	 * Returns the full name of the client
	 * @return full name of the client
	 */
	public String getName() {
		String fullName = (this.firstName + " " + this.lastName);
		return fullName;
	}

	/**
	 * Returns the phone number of the client
	 * @return Phone number
	 */
	public long getPhoneNum() {
		return this.phoneNum;
	}

	/**
	 * Returns the email of the client
	 * @return Email
	 */
	public String getEmail() {
		return this.email;
	}
}
