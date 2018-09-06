package com.nishilua.mastermind.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.nishilua.mastermind.controller.NonExistingGameException;

/**
 * Manages the creation and bookkeeping of games.
 * The IDs of games are kept here, as reference to each game in a hashmap.
 */
@Component
public class GamesManager {

	protected Map<String, Game> games = new HashMap<>();
	
	/**
	 * Creates a new Game
	 * @return The new game ID
	 */
	public String createNewGame() {
		Game newGame = new Game() ;
		String gameId = UUID.randomUUID().toString();
		games.put(gameId, newGame);
		return gameId;
	}
	
	/**
	 * Retrieves a game by ID
	 * @return The game
	 * @throws NonExistingGameException if the game ID is not found
	 */
	public Game getGame(String gameId) throws NonExistingGameException {
		Game game = games.get(gameId);
		if (game == null) {
			throw new NonExistingGameException(gameId);
		}
		return game;
	}
	
	/**
	 * Retrieves all the games IDs
	 * @return The set of all games IDs
	 */
	public Set<String> getGamesIds() {
		return games.keySet();
	}
	
}
