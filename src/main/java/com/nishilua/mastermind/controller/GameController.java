package com.nishilua.mastermind.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nishilua.mastermind.controller.responses.GameId;
import com.nishilua.mastermind.game.GamesManager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "/game", description = "Operations on games")
@RequestMapping("/v1/game")
public class GameController {
    
	@Autowired
	GamesManager gamesManager;
	
	/*
	 * GET  /game - Returns the list of all games
	 * POST /game - Creates a new game and return the ID of the game
	 */

	
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of games IDs", responseContainer = "Set", response = String.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success")
    })
	public Set<String> getGamesList() {
		return gamesManager.getGamesIds();
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new game and returns its ID")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Game created successfully")	
		})
	public GameId createNewGame() {
		return GameId.wrap(gamesManager.createNewGame());
	}
	
}
