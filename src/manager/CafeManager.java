package manager;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
     * @param gameID the game ID of a board game.
     * @return gameID the board game object if it is in the collection.
     */
    public BoardGame getGameByID(String gameID) {
        return boardGames.get(gameID);
    }

    /**
     * Check if a board game is currently in the collection.
     * 
     * @param gameID the name of a board game.
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

    /**
     * Searches the collection for board games whose publisher contain the given
     * query.
     * Matching is case-insensitive and ignore leading/trailing spaces.
     * 
     * @param publisher the text to search for within publisher names
     * @return a list of board games whose publisher contain the cleaned query
     */
    public List<BoardGame> getGamesByPublisher(String publisher) {
        String cleaned = normalise(publisher);
        List<BoardGame> results = new ArrayList<>();

        for (BoardGame game : boardGames.values()) {
            String publisherName = normalise(game.getPublisher());

            if (publisherName.contains(cleaned)) {
                results.add(game);
            }
        }
        return results;
    }

    /**
     * Searches the collection for board games whose designer contain the given
     * query.
     * Matching is case-insensitive and ignore leading/trailing spaces.
     * 
     * @param designer the text to search for within designer names
     * @return a list of board games whose designer contain the cleaned query
     */
    public List<BoardGame> getGamesByDesigner(String designer) {
        String cleaned = normalise(designer);
        List<BoardGame> results = new ArrayList<>();

        for (BoardGame game : boardGames.values()) {
            String designerName = normalise(game.getDesigner());

            if (designerName.contains(cleaned)) {
                results.add(game);
            }
        }
        return results;
    }

    /**
     * Searches the collection for board games matching the given genre.
     * Matching is case-insensitive and ignoring leading/trailing spaces.
     * 
     * @param genre the text to search for within genre names.
     * @return a list of board games whose genre contain the cleaned query.
     */
    public List<BoardGame> getGamesByGenre(String genre) {
        String cleaned = normalise(genre);
        List<BoardGame> results = new ArrayList<>();

        for (BoardGame game : boardGames.values()) {
            String genreType = normalise(game.getGenre());

            if (genreType.contains(cleaned)) {
                results.add(game);
            }
        }
        return results;
    }

    /**
     * Searches the collection for board games with a lower play time than
     * specified.
     * 
     * @param minutes the maximum number of minutes for the play time of a game.
     * @return a list of board games whose minutes are within the query.
     */
    public List<BoardGame> getGamesByMaxPlayTime(int minutes) {
        List<BoardGame> results = new ArrayList<>();

        for (BoardGame game : boardGames.values()) {

            if (game.getPlayTime() <= minutes) {
                results.add(game);
            }
        }
        return results;
    }

    /**
     * Searches the collection for board games whose minimum & maximum players are
     * included in the query.
     * 
     * @param players the number of players the board game is required to cover.
     * @return a list of board games that are suitable for the query.
     */
    public List<BoardGame> getGamesForPlayerCount(int players) {
        List<BoardGame> results = new ArrayList<>();

        for (BoardGame game : boardGames.values()) {

            if (players >= game.getMinPlayers() && players <= game.getMaxPlayers()) {
                results.add(game);
            }
        }
        return results;
    }

    /**
     * Searches the collection for board games that are currently available.
     * 
     * @return a list of board games whose availabilty status is true.
     */
    public List<BoardGame> getAvailableGames() {
        List<BoardGame> results = new ArrayList<>();

        for (BoardGame game : boardGames.values()) {

            if (game.isAvailable()) {
                results.add(game);
            }
        }
        return results;
    }

    /**
     * Updates the genre of the board game with the given ID.
     *
     * <p>
     * The method first checks whether a game with the specified ID exists in the
     * collection. If found, and the new genre string is non-null and non-blank,
     * the game's genre field is updated.
     * </p>
     *
     * @param id       the unique ID of the board game to update
     * @param newGenre the new genre value to assign to the game
     * @return true if the game exists and the genre was successfully updated;
     *         false if the ID is not found or the new genre is null/blank
     */
    public boolean updateGenre(String id, String newGenre) {
        if (!gameExists(id) || isBlank(newGenre)) {
            return false;
        }
        boardGames.get(id).setGenre(newGenre);
        return true;
    }

    /**
     * Updates the availability status of the board game with the given ID.
     *
     * @param id          the unique ID of the board game to update
     * @param isAvailable the new availability status to assign
     * @return true if the game exists and the availability was updated;
     *         false if the ID does not exist in the collection
     */
    public boolean updateAvailability(String id, boolean isAvailable) {
        if (!gameExists(id)) {
            return false;
        }
        boardGames.get(id).setAvailable(isAvailable);
        return true;
    }

    /**
     * Updates the name of the board game with the given ID.
     *
     * @param id      the unique ID of the board game to update
     * @param newName the new board game name to assign
     * @return true if the game exists and the name was updated;
     *         false if the ID does not exist in the collection or newName is blank
     */
    public boolean updateName(String id, String newName) {
        if (!gameExists(id) || isBlank(newName)) {
            return false;
        }
        boardGames.get(id).setGameName(newName);
        return true;
    }

    /**
     * Updates the minimum and maximum number of players of the board game
     * with the given ID.
     *
     * @param id     the unique ID of the board game to update
     * @param newMin the new minimum player count to assign
     * @param newMax the new maximum player count to assign
     * @return true if the game exists and the player counts were updated;
     *         false if the ID does not exist
     */
    public boolean updatePlayerCounts(String id, int newMin, int newMax) {
        if (!gameExists(id)) {
            return false;
        }
        boardGames.get(id).setMinPlayers(newMin);
        boardGames.get(id).setMaxPlayers(newMax);
        return true;
    }

    /**
     * Returns all board games sorted alphabetically by name.
     *
     * @return a list of board games sorted by game name
     */
    public List<BoardGame> getGamesSortedByName() {
        List<BoardGame> list = new ArrayList<>(boardGames.values());
        list.sort(Comparator.comparing(BoardGame::getGameName, String.CASE_INSENSITIVE_ORDER));
        return list;
    }

    /**
     * Returns all board games sorted by play time (ascending).
     *
     * @return a list of board games sorted by play time
     */
    public List<BoardGame> getGamesSortedByPlayTime() {
        List<BoardGame> list = new ArrayList<>(boardGames.values());
        list.sort(Comparator.comparing(BoardGame::getPlayTime));
        return list;
    }

    /**
     * Returns all board games sorted in numerical order by minimum player count.
     * 
     * @return a list of board games sorted by minimum player count
     */
    public List<BoardGame> getGamesSortedByMinPlayers() {
        List<BoardGame> list = new ArrayList<>(boardGames.values());
        list.sort(Comparator.comparing(BoardGame::getMinPlayers));
        return list;
    }

    /**
     * Returns all board games in alphabetical order by genre.
     * 
     * @return a list of board games sorted by genre.
     */
    public List<BoardGame> getGamesSortedByGenre() {
        List<BoardGame> list = new ArrayList<>(boardGames.values());
        list.sort(Comparator.comparing(BoardGame::getGenre,
                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)));
        return list;
    }

    // Helper method to clean user inputs
    private String normalise(String text) {
        return text.trim().toLowerCase();
    }

    // Helper method to check for valid inputs
    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    // Helper method that validates the game id
    private boolean gameExists(String id) {
        return boardGames.containsKey(id);
    }
}
