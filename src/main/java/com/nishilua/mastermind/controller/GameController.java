package com.nishilua.mastermind.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nishilua.mastermind.game.GamesManager;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/game")
public class GameController {
    
	@Autowired
	GamesManager gamesManager;
	/*
	 * GET  /game - Returns the list of all games
	 * POST /game - Creates a new game and return the ID of the game
	 * GET  /game/{id} - Returns the history of a game
	 * POST /guess/{game_id} - Tries a new guess
	 */

	@RequestMapping(value= "", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of games", responseContainer="Set", response = String.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success")
            }) 
	public Set<String> getGamesList() {
		return gamesManager.getGamesIds();
	}
	
	
	
}
