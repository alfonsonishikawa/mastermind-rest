package com.nishilua.mastermind.controller;

/**
 * Exception thrown when the user guess input has the wrong format
 */
public class WrongGuessException extends Exception {

	private static final long serialVersionUID = -89229755257212804L;

	public WrongGuessException(String message) {
		super(message);
	}
}
