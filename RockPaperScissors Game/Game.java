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
 * Game is an abstract class that initializes the players array as well as a scanner its subclasses
 * It implements the interface "Playable"
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public abstract class Game implements Playable {
	
	/**
	 * numRounds is the value that represents the max number of rounds
	 */
	protected int numRounds;
	
	/**
	 * players is an array of type Player and contains all competitors
	 */
	protected Player[] players;
	
	/**
	 * in is used to read player input
	 */
	protected Scanner in;
	
	/**
	 * initializes the rounds and players for a game
	 * @param x The number of rounds that will be played
	 */
	public Game(int x) {
		this.numRounds = x;
		//initializes the player array to the size of the amount of players
		players = new Player[NUM_PLAYERS];
		in = new Scanner(System.in);
		initPlayers();
		//Because the method initPlayers is abstract in the interface
	}
	
	/**
	 * finalize attempts to close the Scanner "in"
	 * in the case where the close in unsuccessful, the program keeps going
	 */
	@Override
	public void finalize() {
		try {
			in.close();
		} catch (Exception e) { }
	}
}
