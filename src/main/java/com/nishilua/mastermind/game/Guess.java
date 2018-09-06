package com.nishilua.mastermind.game;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * Holds a guess as a List of color numbers where index 0 is the left-most.
 */
@ApiModel(description = "List of integers with the color of each ball")
public class Guess implements Cloneable {
	
	private List<Integer> balls ;

	public List<Integer> getBalls() {
		return balls;
	}

	public void setBalls(List<Integer> balls) {
		this.balls = balls;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Guess newGuess = new Guess() ;
		newGuess.setBalls(new ArrayList<Integer>(balls));
		return newGuess;
	}

}
