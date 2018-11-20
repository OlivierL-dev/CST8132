package rps;

/*
* Name: Olivier Lauzon
* Student ID: 040918796
* Course & Section: CST8132 303
* Assignment: Lab 5
* Date: Oct 26, 2018
*/

/**
 * Playable is an interface that contains the methods for a subclass that is playable.
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public interface Playable {
	
	/**
	 * number of players playing the game
	 */
	static int NUM_PLAYERS = 2;
	// The property has an access level of Public and it is a Class property
	
	/**
	 * initializes the player in the game
	 */
	void initPlayers();
	
	/**
	 * plays the entire game
	 */
	void play();
	
	/**
	 * checks to see who won
	 */
	void evaluateRound();
	
	/**
	 * prints the final scores
	 */
	void displayResults();
	// The methods have an access level of Public and are abstract
}
