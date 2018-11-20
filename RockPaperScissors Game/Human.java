package rps;

import java.util.Scanner;

/*
* Name: Olivier Lauzon
* Student ID: 040918796
* Course & Section: CST8132 303
* Assignment: Lab 5
* Date: Oct 26, 2018
*/

/**
 * Human class is a concrete subclass of the abstract Player class.
 * Will be utilized in the RockPaperScissors class to process the player turn.
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public class Human extends Player {
	
	/**
	 * in is used to read player input
	 */
	private Scanner in;
	
	/**
	 * The constructor asks the user to enter his name and uses that string to run the super constructor.
	 * @param x A query for the user to input his name.
	 */
	public Human(Scanner x) {
		super(x.next());
		in = x;
		// 2 Java Scanners exist in memory at the moment
	}
	
	/**
	 * takeTurn queries the user for their move and prints it out.
	 * @return boolean of false to quit and true to continue
	 */
	public boolean takeTurn() {
		// the Human class will not be able to run since it needs to implement all of
		// the abstract methods of the abstract superclass
		boolean test;
		do {
			System.out.println(
					getName() + ", it's your turn (Enter R for Rock, P for Paper, S for Scissors, L for Lizard, and K for Spock or Q to quit):");
			String choice = in.next().toUpperCase().substring(0, 1); 
			test = true;
			switch (choice) {
			
			//ROCK case
			case "R":
				lastMove = HandSign.getHandSign("R");
				System.out.println(getName() + " played " + getLastMove());
				break;
			
			//PAPER case
			case "P":
				lastMove = HandSign.getHandSign("P");
				System.out.println(getName() + " played " + getLastMove());
				break;
			
			//SCISSORS case
			case "S":
				lastMove = HandSign.getHandSign("SC");
				System.out.println(getName() + " played " + getLastMove());
				break;
			
			//LIZARD case
			case "L":
				lastMove = HandSign.getHandSign("L");
				System.out.println(getName() + " played " + getLastMove());
				break;
			
			//SPOCK case
			case "K":
				lastMove = HandSign.getHandSign("SP");
				System.out.println(getName() + " played " + getLastMove());
				break;
			
			//Quit case
			case "Q":
				return false;
			
			//Wrong input case
			default:
				System.out.println("Invalid input, please try again");
				test = false;
			}
		} while (!test);
		return true;
	}
}
