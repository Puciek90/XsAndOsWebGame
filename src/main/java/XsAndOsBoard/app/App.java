package XsAndOsBoard.app;

import XsAndOsBoard.board.Board;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Board board = new Board(3,5,3);
        board.help();
        board.showBoard();
    }
}
