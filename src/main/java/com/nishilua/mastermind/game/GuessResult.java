package com.nishilua.mastermind.game;

/**
 * Holds the result of a guess: how many balls are correct both in color and position, and how many are correct in color but no position.
 */
public class GuessResult {

	/**
	 * The guess tested
	 */
	private Guess guess;
	
	/**
	 * Number of correct position and color balls
	 */
	private int correctBoth;
	
	/**
	 * Number of correct color balls (but wrong position)
	 */
	private int correctColor;
	
	
	
	public GuessResult(Guess guess, int correctBoth, int correctColor) {
		this.guess = guess;
		this.correctBoth = correctBoth;
		this.correctColor = correctColor;
	}
	
	public Guess getGuess() {
		return guess;
	}

	public void setGuess(Guess guess) {
		this.guess = guess;
	}

	public int getCorrectBoth() {
		return correctBoth;
	}
	
	public void setCorrectBoth(int correctBoth) {
		this.correctBoth = correctBoth;
	}
	
	public int getCorrectColor() {
		return correctColor;
	}
	
	public void setCorrectColor(int correctColor) {
		this.correctColor = correctColor;
	}
		
}
