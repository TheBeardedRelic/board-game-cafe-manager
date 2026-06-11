package manager;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import model.BoardGame;

/**
 * A class representing a board game cafe's management actions.
 *
 * @author Stephen Dawes
 * @version 11th June 2026
 */
public class CafeManager {
    // instance variables
    private Map<String, BoardGame> boardGames;

    /**
     * Constructor for objects of class CafeManager
     */
    public CafeManager() {
        // initialise instance variables
        boardGames = new HashMap<>();
    }

    /**
     * Add a board game if it is not currently in the collection.
     * 
     * @param game the board game to add.
     * @return true if the game is successfully added to the collection.
     * @return false if the game is already inside the collection.
     */
    public boolean addBoardGame(BoardGame game) {
        String id = game.getGameID();

        if (boardGames.containsKey(id)) {
            return false; // already exists
        }

        boardGames.put(id, game);
        return true; // add to Map
    }

    /**
     * Remove a board game if it is in the collection.
     * 
     * @param the game ID of a board game.
     * @return true if the board game has been successfully removed, false
     *         otherwise.
     */
    public boolean removeBoardGame(String gameID) {
        return boardGames.remove(gameID) != null;
    }

    /**
     * Find a board game by game ID.
     * 
     * @param the game ID of a board game.
     * @return the board game object if it is in the collection.
     */
    public BoardGame findGame(String gameID) {
        return boardGames.get(gameID);
    }

    /**
     * Check if a board game is currently in the collection.
     * 
     * @param the name of a board game.
     * @return true if the game is in the collection.
     */
    public boolean containsGame(String gameID) {
        return boardGames.containsKey(gameID);
    }

    /**
     * Returns the collection of board games.
     * 
     * @return the board game collection.
     */
    public List<BoardGame> getAllGames() {
        return new ArrayList<>(boardGames.values());
    }

    /**
     * Returns the collection sorted alphabetically by gameID.
     */
    public List<BoardGame> getAllGamesSorted() {
        List<BoardGame> list = new ArrayList<>(boardGames.values());
        Collections.sort(list);
        return list;
    }

    // Helper method to clean user inputs
    private String normalise(String text) {
        return text.trim().toLowerCase();
    }

    /**
     * Searches the collection for board games whose names contain the given query.
     * Matching is case-insensitive and ignores leading/trailing spaces.
     *
     * @param query the text to search for within game names
     * @return a list of board games whose names contain the cleaned query
     */

    public List<BoardGame> searchByGameName(String query) {
        String cleaned = normalise(query); // normalise user input
        List<BoardGame> results = new ArrayList<>();

        for (BoardGame game : boardGames.values()) {
            String title = normalise(game.getGameName());

            if (title.contains(cleaned)) {
                results.add(game); // match found, include in results
            }
        }
        return results;
    }
}
