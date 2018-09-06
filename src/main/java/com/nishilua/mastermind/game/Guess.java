package com.nishilua.mastermind.game;

import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * Holds a guess as a List of color numbers where index 0 is the left-most.
 */
@ApiModel(description = "List of integers with the color of each ball")
public class Guess {
	
	private List<Integer> balls ;

	public List<Integer> getBalls() {
		return balls;
	}

	public void setBalls(List<Integer> balls) {
		this.balls = balls;
	}

}
