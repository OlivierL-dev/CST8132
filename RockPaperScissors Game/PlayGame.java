package rps;

/*
* Name: Olivier Lauzon
* Student ID: 040918796
* Course & Section: CST8132 303
* Assignment: Lab 5
* Date: Oct 26, 2018
*/

/**
 * Executes the game
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public class PlayGame {
	
	/**
	 * Main method executes the play and displayResults methods of the RockPaperScissors class
	 * @param args
	 */
	public static void main(String[] args) {
		Playable lab5 = new RockPaperScissors(3);
		lab5.play();
		lab5.displayResults();
	}
}
