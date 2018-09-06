package com.nishilua.mastermind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nishilua.mastermind.game.Game;
import com.nishilua.mastermind.game.GamesManager;
import com.nishilua.mastermind.game.Guess;
import com.nishilua.mastermind.game.GuessResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Operation on guesses:
 * 
 * - Perform a guess
 * - Retrieve the guess history
 *
 */
@RestController
@Api(value = "/game", description = "Operations on guesses")
@RequestMapping("/v1/guess")
public class GuessController {
    
	@Autowired
	GamesManager gamesManager;
	
	/*
	 * GET  /guess/{game_id} - Returns the history of a game
	 * POST /guess/{game_id} - Tries a new guess
	 */

	
	
	@RequestMapping(value="/{game_id}", method = RequestMethod.GET)
	@ApiOperation(value = "Returns a list of guesses ordered from first to last with the guess, the number of correct color and position balls, and the number of correct color balls.")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success")
        })
	public List<GuessResult> getHistory(@ApiParam(value="ID of the game to get all the guess history") @PathVariable("game_id") String gameId) throws NonExistingGameException{
		return gamesManager.getGame(gameId).getHistory();
	}
	

	
	@RequestMapping(path="/{game_id}", method = RequestMethod.POST)
	@ApiOperation(value = "Test a guess for the given game")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success")
        })
	public GuessResult guess(
			@ApiParam(value="ID of the game to make a guess") @PathVariable("game_id") String gameId,
			@ApiParam(value="Guess in array format from left to right") @RequestBody Guess guessBalls
		) throws NonExistingGameException, WrongGuessException {
		if (guessBalls.getBalls().size() < Game.numBalls) {
			throw new WrongGuessException("Incorrect guess size: expected " + Game.numBalls + " balls guess.");
		}
		Game game = gamesManager.getGame(gameId) ;
		return game.checkGuess(guessBalls) ;
	}
	
}
