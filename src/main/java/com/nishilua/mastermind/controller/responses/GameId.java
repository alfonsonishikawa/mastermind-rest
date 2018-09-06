package com.nishilua.mastermind.controller.responses;

import io.swagger.annotations.ApiModel;

/**
 * Response class to hold the list of games IDs
 */
@ApiModel(description = "Holds a gameId")
public class GameId {

	private String gameId;
	
	/**
	 * Don't allow to instantiate manually
	 */
	private GameId(String gameId) {
		this.gameId = gameId;
	} ;
	
	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public static GameId wrap(String gameId) {
		return new GameId(gameId) ;
	}
}
