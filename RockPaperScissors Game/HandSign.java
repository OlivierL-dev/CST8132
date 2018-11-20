package rps;

/*
* Name: Olivier Lauzon
* Student ID: 040918796
* Course & Section: CST8132 303
* Assignment: Lab 5
* Date: Oct 26, 2018
*/

/**
 * Define an enumeration called Sign, with 5 elements, referred to as:
 * HandSign.SCISSORS, HandSign.PAPER, HandSign.ROCK, HandSign.LIZARD, HandSign.SPOCK.
 * @author Olivier Lauzon
 * @author Angela Giddings
 * @version 1.1
 * @since 1.8
 */
public enum HandSign {
	
	ROCK, PAPER, SCISSORS, LIZARD, SPOCK;
	
	/**
	 * Get the HandSign for a given letter.
	 * @param firstLetter The letter(s) representing a HandSign value (R, P, SC, L, SP).
	 * @return The HandSign value which corresponds to the given letter(s), otherwise return null.
	 */
	public static HandSign getHandSign(String firstLetter) {
		//returns the full handsign name based on the player input
		for (HandSign h : HandSign.values())
			if (h.name().startsWith(firstLetter.toUpperCase()))
				return h;
		return null;
	}
	
	/**
	 * getWinner checks the moves of the round and determines the winner.
	 * @param moves An array of the moves played during the current round.
	 * @return Returns an int of either -1, 0, or 1.
	 */
	public static int getWinner(HandSign[] moves) {
		if (moves[0] == moves[1]){
			return -1;
		}
		//case verification for all the potential round outcomes
		else if ((moves[0] == HandSign.SCISSORS && moves[1] == HandSign.PAPER) ||
				 (moves[0] == HandSign.SCISSORS && moves[1] == HandSign.LIZARD) ||
				 (moves[0] == HandSign.PAPER && moves[1] == HandSign.ROCK) ||
				 (moves[0] == HandSign.PAPER && moves[1] == HandSign.SPOCK) ||
				 (moves[0] == HandSign.ROCK && moves[1] == HandSign.SCISSORS) ||
				 (moves[0] == HandSign.ROCK && moves[1] == HandSign.LIZARD) ||
				 (moves[0] == HandSign.LIZARD && moves[1] == HandSign.SPOCK) ||
				 (moves[0] == HandSign.LIZARD && moves[1] == HandSign.PAPER) ||
				 (moves[0] == HandSign.SPOCK && moves[1] == HandSign.SCISSORS) ||
				 (moves[0] == HandSign.SPOCK && moves[1] == HandSign.ROCK)) {
			return 0;
		} 
		else {
			return 1;
		}
	}
}
