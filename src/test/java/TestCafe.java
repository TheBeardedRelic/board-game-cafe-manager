package test.java;

import java.util.List;

import manager.CafeManager;
import model.BoardGame;

public class TestCafe {
    public static void main(String[] args) {
        CafeManager cm = new CafeManager();

        // --- CREATE TEST GAMES ---
        BoardGame g1 = new BoardGame("G001", "Catan", 3, 4, "Strategy");
        g1.setPlayTime(60);
        g1.setPublisher("Kosmos");
        g1.setDesigner("Klaus Teuber");
        g1.setYearPublished(1995);

        BoardGame g2 = new BoardGame("G002", "Azul", 2, 4, "Abstract");
        g2.setPlayTime(30);
        g2.setPublisher("Next Move Games");
        g2.setDesigner("Michael Kiesling");
        g2.setYearPublished(2017);

        cm.addBoardGame(g1);
        cm.addBoardGame(g2);

        // ----- TESTS -----
        printSection("Games for 3 Players");
        printList(cm.getGamesForPlayerCount(3));

        printSection("Strategy Games");
        printList(cm.getGamesByGenre("strategy"));

        printSection("Available Games");
        printList(cm.getAvailableGames());
    }

    // --- HELPER METHODS ---

    private static void printSection(String title) {
        System.out.println("\n=== " + title + " ===\n");
    }

    private static void printList(List<BoardGame> games) {
        for (BoardGame game : games) {
            System.out.println(game);
            System.out.println(); // blank line between games
        }
    }
}