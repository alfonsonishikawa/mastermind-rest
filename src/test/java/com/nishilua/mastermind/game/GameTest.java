package com.nishilua.mastermind.game;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

	/**
	 * Tests that the returned guess results are right.
	 * Designed for a 4 balls games and at least 5 colors.
	 */
	@Test
	public void testGameGuessCheck() {
		
		Game game = new Game() ;
		
		Assert.assertEquals(Game.numBalls, 4);
		List<Integer> code = Arrays.asList( new Integer[] {1, 2, 4, 1} );
		game.setCode(code);
				
		Guess guess = new Guess();
		
		guess.setBalls( Arrays.asList( new Integer[] {1, 1, 1, 1} ) );
		GuessResult result = game.checkGuess(guess) ;
		Assert.assertEquals(2, result.getCorrectBoth());
		Assert.assertEquals(0, result.getCorrectColor());
		result.getGuess().equals(guess) ;
		
		guess.setBalls( Arrays.asList( new Integer[] {2, 2, 2, 2} ) );
		result = game.checkGuess(guess) ;
		Assert.assertEquals(1, result.getCorrectBoth());
		Assert.assertEquals(0, result.getCorrectColor());

		guess.setBalls( Arrays.asList( new Integer[] {5, 5, 5, 5} ) );
		result = game.checkGuess(guess) ;
		Assert.assertEquals(0, result.getCorrectBoth());
		Assert.assertEquals(0, result.getCorrectColor());
		
		guess.setBalls( Arrays.asList( new Integer[] {1, 2, 4, 1} ) );
		result = game.checkGuess(guess) ;
		Assert.assertEquals(4, result.getCorrectBoth());
		Assert.assertEquals(0, result.getCorrectColor());
		
		guess.setBalls( Arrays.asList( new Integer[] {2, 1, 1, 4} ) );
		result = game.checkGuess(guess) ;
		Assert.assertEquals(0, result.getCorrectBoth());
		Assert.assertEquals(4, result.getCorrectColor());
		
		guess.setBalls( Arrays.asList( new Integer[] {6, 5, 3, 4} ) );
		result = game.checkGuess(guess) ;
		Assert.assertEquals(0, result.getCorrectBoth());
		Assert.assertEquals(1, result.getCorrectColor());
		
		guess.setBalls( Arrays.asList( new Integer[] {4, 2, 5, 1} ) );
		result = game.checkGuess(guess) ;
		Assert.assertEquals(2, result.getCorrectBoth());
		Assert.assertEquals(1, result.getCorrectColor());
		
		guess.setBalls( Arrays.asList( new Integer[] {3, 2, 4, 1} ) );
		result = game.checkGuess(guess) ;
		Assert.assertEquals(3, result.getCorrectBoth());
		Assert.assertEquals(0, result.getCorrectColor());
		
		guess.setBalls( Arrays.asList( new Integer[] {0, 1, 4, 1} ) );
		result = game.checkGuess(guess) ;
		Assert.assertEquals(2, result.getCorrectBoth());
		Assert.assertEquals(1, result.getCorrectColor());
	}
	
	/**
	 * Tests that the returned guess results are right.
	 * Designed for a 4 balls games and at least 5 colors.
	 */
	@Test
	public void testGameGuessHistory() {
		
		Game game = new Game() ;
		
		Assert.assertEquals(Game.numBalls, 4);
		List<Integer> code = Arrays.asList( new Integer[] {1, 2, 4, 1} );
		game.setCode(code);
				
		Guess guess = new Guess();
		
		Assert.assertEquals(0, game.getHistory().size());
		
		guess.setBalls( Arrays.asList( new Integer[] {1, 1, 1, 1} ) );
		game.checkGuess(guess) ;
		Assert.assertEquals(1, game.getHistory().size());
		
		guess.setBalls( Arrays.asList( new Integer[] {3, 2, 4, 1} ) );
		game.checkGuess(guess) ;
		Assert.assertEquals(2, game.getHistory().size());
		
		guess.setBalls( Arrays.asList( new Integer[] {6, 5, 3, 4} ) );
		game.checkGuess(guess) ;
		Assert.assertEquals(3, game.getHistory().size());

		List<GuessResult> historic = game.getHistory();
		Assert.assertEquals(2, historic.get(0).getCorrectBoth());
		Assert.assertEquals(0, historic.get(0).getCorrectColor());
		Assert.assertEquals(Arrays.asList( new Integer[] {1, 1, 1, 1} ), historic.get(0).getGuess().getBalls() );

		Assert.assertEquals(3, historic.get(1).getCorrectBoth());
		Assert.assertEquals(0, historic.get(1).getCorrectColor());
		Assert.assertEquals(Arrays.asList( new Integer[] {3, 2, 4, 1} ), historic.get(1).getGuess().getBalls() );

		Assert.assertEquals(0, historic.get(2).getCorrectBoth());
		Assert.assertEquals(1, historic.get(2).getCorrectColor());
		Assert.assertEquals(Arrays.asList( new Integer[] {6, 5, 3, 4} ), historic.get(2).getGuess().getBalls() );
		
	}
	
}
