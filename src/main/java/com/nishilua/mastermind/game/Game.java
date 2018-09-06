package com.nishilua.mastermind.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Holds the information for one Game:
 * - The code to solve
 * - The guesses History ordered
 * 
 * Checks guesses, adding the guess to the history.
 */
public class Game {

	/**
	 * Number of balls for each game
	 */
	public static int numBalls = 4;
	
	/**
	 * Number of colors for each ball
	 */
	public static int numColors = 6;
	
	/**
	 * Code to crack: 4 numbers
	 * TODO: Make number of marbles configurable
	 */
	List<Integer> code = new ArrayList<>();

	/**
	 * List of Guess Results with:
	 * - The guess tested
	 * - The number of correct color and position balls
	 * - The number of correct color balls (and wrong position)
	 */
	List<GuessResult> guessHistory = new ArrayList<>();
	
	private static Random randomGenerator = new Random();
	
	/**
	 * Generates a random code to solve.
	 */
	public Game() {
		for (int i = 0; i < numBalls; i++) {
			code.add(randomGenerator.nextInt(numColors)) ; //Number 0-5
		}
	}
	
	/**
	 * Returns the guess history checked in this game
	 * @return List of guess + correct both + correct color balls.
	 */
	public List<GuessResult> getHistory() {
		return guessHistory;
	}
	
	/**
	 * Checks a guess, adds it to the guesses history, and returns the result for the test with the guess + correct both + correct color balls.
	 * 
	 */
	public GuessResult checkGuess(Guess guess) {
		
		List<Integer> guessClone = new ArrayList<>(guess.getBalls()); // Guess clone to mutate
		List<Integer> codeClone = new ArrayList<>(code); // Code clone to mutate
		
		int correctBoth = 0;
		int correctColor = 0;

		// Check for both correct
		for (int i = 0 ; i < codeClone.size() ; i++) {
			if (guessClone.get(i).equals(codeClone.get(i))) {
				// Match!
				correctBoth++;
				guessClone.set(i, -1); // Delete the balls
				codeClone.set(i, -1);
			}
		}
		// Check for color correct
		for (int i = 0 ; i < codeClone.size(); i++) {
			if (codeClone.get(i) == -1)
				continue;
			
			int codeColor = codeClone.get(i);
			int guessIndexColorMatch = guessClone.indexOf(codeColor);
			
			if (guessIndexColorMatch != -1) {
				// Color match!
				correctColor++;
				guessClone.set(guessIndexColorMatch, -1); // Delete the ball
			}
		}
		
		GuessResult guessResult = new GuessResult(guess, correctBoth, correctColor) ;
		guessHistory.add(guessResult);
		
		return guessResult;
	}
	
}
