package rps;

import java.util.Random;

/*
* Name: Olivier Lauzon
* Student ID: 040918796
* Course & Section: CST8132 303
* Assignment: Lab 5
* Date: Oct 2 6, 2018
*/


/**
 * Computer class is a concrete subclass of the abstract Player class.
 * Will be utilized in the RockPaperScissors class
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public class Computer extends Player {
	
	/**
	 * Computer constructor initializes the value of
	 * the player name of the new object of Computer to "HAL"
	 */
	public Computer() {
		//this gives the computer the name of "HAL"
		super("HAL");
		// It would be impossible to use the implicit default constructor of the class
		// since the constructor of the superclass must run first and it requires a
		// String parameter
	}

	/**
	 * takeTurn method generates a random move for the computer player and prints the move.
	 * @return true to ensure completion of method
	 */
	public boolean takeTurn() {
		Random var = new Random();
		// Var is a reference type variable. THis variable is used to utilize methods
		// from the Random class. It does not require Javadoc since Random already has
		// its own Javadoc
		
		//this assigns a random handsign to lastMove
		lastMove = HandSign.values()[var.nextInt(5)];
		System.out.println(getName() + ", it's your turn!");
		System.out.println(getName() + " played " + getLastMove());
		return true;
	}

}
