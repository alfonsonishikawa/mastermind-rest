package com.nishilua.mastermind.controller.responses;

import java.util.Set;

import io.swagger.annotations.ApiModel;

/**
 * Response class to hold the list of games IDs
 */
@ApiModel(description = "Holds a list of games IDs")
public class GamesIdsList {

	private Set<String> games;
	
	/**
	 * Don't allow to instantiate manually
	 */
	private GamesIdsList(Set<String> gamesIds) {
		this.games = gamesIds;
	} ;

	public Set<String> getGames() {
		return games;
	}

	public void setGames(Set<String> games) {
		this.games = games;
	}
	
	public static GamesIdsList wrap(Set<String> gamesIds) {
		return new GamesIdsList(gamesIds) ;
	}
}
