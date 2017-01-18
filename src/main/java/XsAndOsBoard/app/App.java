package XsAndOsBoard.app;

import XsAndOsBoard.board.Board;
import XsAndOsBoard.gameControll.GameController;


public class App 
{
    public static void main( String[] args )
    {
        Board board = new Board(3,5);
        GameController gameController = new GameController(board, 3);
        gameController.help();
        board.showBoard();
    }
}
