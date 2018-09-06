package com.nishilua.mastermind.controller;

public class NonExistingGameException extends Exception {

	private static final long serialVersionUID = -1856631067354741018L;

	public NonExistingGameException(String gameId) {
		super("The game with id " + gameId + " does not exist.");
	}
	
}
