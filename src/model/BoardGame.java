package model;

import java.util.Objects;

/**
 * A class representing a single board game in the cafes collection.
 *
 * @author Stephen Dawes
 * @version 10th June 2026
 */
public class BoardGame implements Comparable<BoardGame> {
    // instance variables
    private final String gameID; // A unique ID to identify the board game.
    private String gameName = ""; // The board games title.
    private int minPlayers = 0; // The minimum number of players needed to play the game.
    private int maxPlayers = 0; // The maximum number of players that can play the game.
    private String genre = ""; // The category or genre type of the board game.
    private int playTime = 0; // The average expected playtime in minutes.
    private String publisher = ""; // The name of the board game publisher.
    private String designer = ""; // The name of the designer(s).
    private int yearPublished = 0; // The year this version was first published.
    private boolean isAvailable = true; // The board game's availability status.

    /**
     * Constructor for objects of class BoardGame.
     * 
     * @param gameID     the unique identifier for the board game
     * @param minPlayers the minimum number of players required
     * @param maxPlayers the maximum number of players allowed
     * @param genre      the genre or category of the board game
     */
    public BoardGame(String gameID, String gameName, int minPlayers, int maxPlayers, String genre) {
        // initialise instance variables
        this.gameID = gameID;
        this.gameName = (gameName == null || gameName.isBlank()) ? gameID : gameName;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.genre = genre;
    }

    /**
     * Updates the board game's name.
     * 
     * @param gameName the new title for the board game.
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * Updates the minimum player count.
     * 
     * @param minPlayers the new minimum number of players.
     */
    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    /**
     * Updates the maximum player count.
     * 
     * @param maxPlayers the new maximum number of players.
     */
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * Updates the category for the game.
     * 
     * @param genre the new category or genre for the game.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Updates the expected playtime for the game.
     * 
     * @param playTime the expected playtime.
     */
    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    /**
     * Updates the publisher of the board game.
     * 
     * @param publisher the publisher of the game.
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Updates the designer(s) of the boardgame.
     * 
     * @param designer the designer of the boardgame.
     */
    public void setDesigner(String designer) {
        this.designer = designer;
    }

    /**
     * Updates the games published year.
     * 
     * @param yearPublished the year this version was first published.
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Updates the board games availablity status.
     * 
     * @param isAvailable the status of the games availability.
     */
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * Returns the board games unique name.
     * 
     * @return gameID the board games unique name.
     */
    public String getGameID() {
        return gameID;
    }

    /**
     * Returns the board games name.
     * 
     * @return gameID the board games name.
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * Returns the minimum number of players required.
     * 
     * @return minPlayers the board games minimum player count.
     */
    public int getMinPlayers() {
        return minPlayers;
    }

    /**
     * Returns the maximum number of players allowed.
     * 
     * @return maxPlayers the board games maximum player count.
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Returns the board game category or genre.
     * 
     * @return genre the board games category.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns the expected average playing time in minutes.
     * 
     * @return playTime the board games play time.
     */
    public int getPlayTime() {
        return playTime;
    }

    /**
     * Returns the publisher of the board game.
     * 
     * @return publisher the board games publisher.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Returns the designer(s) of the board game.
     * 
     * @return designer the board games designer(s).
     */
    public String getDesigner() {
        return designer;
    }

    /**
     * Returns the year this version of the game was released.
     * 
     * @return yearPublished the year the board game was released.
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Returns whether the board game is currently available.
     * 
     * @return isAvailable the board games current availability status.
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Return a string representation of the board game including its genre,
     * minimum and maximum player count.
     * 
     * @return a string represntation of the board game.
     */
    public String toString() {
        return ("Game ID: " + gameID + "\n" + "Name: " + gameName + "\n" + "Minimum players: " + minPlayers
                + "\n" + "Maximum players: " + maxPlayers + "\n" + "Genre(s): " + genre + "\n" + "Play time: "
                + playTime + "\n" + "Publisher: " + publisher + "\n" + "Designer(s): " + designer + "\n"
                + "Year published: " + yearPublished + "\n" + "Available: " + isAvailable);
    }

    /**
     * Determines whether this object is equal to another.
     * Two BoardGame objects are equal if they have the same gameID.
     * 
     * @param obj the object to compare with this BoardGame.
     * @return true if the objects are the same, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof BoardGame))
            return false;

        BoardGame other = (BoardGame) obj;
        return Objects.equals(gameID, other.gameID);
    }

    /**
     * Compares this board game with another to sort alphabetically
     * from A-Z by gameID.
     * 
     * @param other the BoardGame object to compare with this.
     * @return a negative value if this gameID comes before the other,
     *         zero if equal, or positive if it comes after.
     */
    @Override
    public int compareTo(BoardGame other) {
        return this.gameID.compareTo(other.gameID);
    }

    /**
     * Returns a hash code value for this BoardGame object.
     * 
     * @return the hash code for this BoardGame.
     */
    @Override
    public int hashCode() {
        return Objects.hash(gameID);
    }
}
