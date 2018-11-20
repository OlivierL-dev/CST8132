package rps;

/*
* Name: Olivier Lauzon
* Student ID: 040918796
* Course & Section: CST8132 303
* Assignment: Lab 5
* Date: Oct 26, 2018
*/

/**
 * Player is an abstract class that keeps track of and updates the statistics of its subclasses
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public abstract class Player {
	
	/**
	 * The name of the player
	 */
	private String name;
	
	/**
	 * The last move played
	 */
	protected HandSign lastMove;
	
	/**
	 * The amount of rounds won
	 */
	private int wins;
	
	/**
	 * The amount of tie rounds
	 */
	public static int ties = 0;

	/**
	 * Constructor initializes the name parameter of the player
	 * @param x The name of the player
	 */
	public Player(String x) {
		this.name = x;
	}

	/**
	 * Returns the name of the player
	 * @return String name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the last move played
	 * @return HandSign lastMove
	 */
	public HandSign getLastMove() {
		return lastMove;
	}

	/**
	 * Returns the current number of ties
	 * @return int wins
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * Returns the current number of ties
	 * @return int ties
	 */
	public static int getTies() {
		return ties;
	}

	/**
	 * Increments the win count by one every time it is called
	 */
	public void win() {
		wins += 1;
	}

	/**
	 * Increments the tie count by one every time it is called
	 */
	public static void tie() {
		ties += 1;
	}
	
	/**
	 * Returns the final score as a string
	 * @return String
	 */
	@Override
	public String toString() {
		return (getName() + ": " + getWins());
	}

	/**
	 * prompts the player to take a turn
	 * @return boolean to confirm whether or not the turn has been taken
	 */
	public abstract boolean takeTurn();

}
