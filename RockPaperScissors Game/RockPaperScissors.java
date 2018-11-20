package rps;

/*
* Name: Olivier Lauzon
* Student ID: 040918796
* Course & Section: CST8132 303
* Assignment: Lab 5
* Date: Oct 26, 2018
*/

/**
 * RockPaperScissors is a subclass of the abstract class Game
 * It executes a full game of rock paper scissors
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public class RockPaperScissors extends Game {
	
	/**
	 * Calls the constructor for the superclass
	 * @param x The number of turns desired
	 */
	public RockPaperScissors(int x) {
		super(x);
	}
	
	/**
	 * Prompts user for an name and populates the array of players
	 */
	public void initPlayers() {
		System.out.print("Please enter a player name: ");
		players[0] = new Human(in);
		players[1] = new Computer();
	}
	
	/**
	 * Plays all of the rounds and prints the outcome each time
	 */
	public void play() {
		for (int i = 0; i < numRounds; i++) {
			System.out.println("Round " + (i + 1) + " of " + numRounds);
			if (players[0].takeTurn() == false) {
				break;
			}
			else {
				players[1].takeTurn();
			}
			evaluateRound();
			//Sore loser clause verifies is the player wants to add 2 more rounds at the end of the game
			if (i == numRounds - 1) {
				System.out.print("Would you like to increase the number of rounds? y for Yes ");
				if(in.next().toUpperCase().equals("Y")) {
					numRounds += 2;
				}
			}
		}
	}
	
	/**
	 * Determines the winner or declares a tie
	 */
	public void evaluateRound() {
		HandSign[] moves = new HandSign[] {players[0].getLastMove(), players[1].getLastMove()};
		int winner = HandSign.getWinner(moves);
		//tie condition
		if (winner == -1) {
			Player.tie();
			System.out.println("It's a tie! | Ties: " + Player.getTies());
		}
		else {
			int loser = Math.abs(winner - 1);
			System.out.println(moves[winner] + " beats " + moves[loser] + "! " + players[winner].getName() + " wins!\n");
			players[winner].win();
		}
	}
	
	/**
	 * Prints the final score of the game
	 */
	public void displayResults() {
		Player winner = null;
		
		//runs through the player array and determines the winner
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i].toString());
			if (players[i].getWins() > (numRounds/2)) {
				winner = players[i];
			}
		}
		System.out.println("Ties: " + Player.getTies());
		//tie condition
		if (winner == null) {
			System.out.println("It's a tie game!");
		}
		else {
			System.out.println("The winner is " + winner.getName() + "!");
		}
		System.out.println("Thanks for playing Rock, Paper, Scissors. Bye!");
	}
}
