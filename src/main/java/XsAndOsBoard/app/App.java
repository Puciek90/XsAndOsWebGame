package XsAndOsBoard.app;

import XsAndOsBoard.board.Board;
import XsAndOsBoard.gameControll.GameController;
import XsAndOsBoard.gameControll.WinnerChecker;
import XsAndOsBoard.player.Player;

import java.util.LinkedList;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Hello world! :)");
        Player player1 = new Player("mateusz", "X", true);
        Player player2 = new Player("marek", "O", false);
        Player player3 = new Player("patryk", "Z", false);

        LinkedList<Player> players = new LinkedList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        Board board = new Board(3,3);
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);
        GameController gameController = new GameController(winnerChecker, 3);

        gameController.setPlayers(players);
        gameController.displayPlayers();
        gameController.passTokenToNextPlayer();
        System.out.println();
        gameController.displayPlayers();

    }
}
