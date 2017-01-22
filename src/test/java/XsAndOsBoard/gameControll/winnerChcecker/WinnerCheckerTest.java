package XsAndOsBoard.gameControll.winnerChcecker;

import XsAndOsBoard.board.Board;
import XsAndOsBoard.board.Field;
import XsAndOsBoard.gameControll.WinnerChecker;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
// Created by Mateusz Płuciennik on 17.01.17.

public class WinnerCheckerTest {
    // TODO: 21.01.17 test for every scenario
    @Test
    public void shouldGiveWinnerSymbolWhenWinnerIsInRow(){
        //given
        Board board = new Board(3,3);
        Field lastMoveField = new Field(1,1);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(0,1), "Z");
        board.setFieldSymbol(new Field(1,1), "Z");
        board.setFieldSymbol(new Field(2,1), "Z");

        board.showBoard();

        WinnerChecker winnerChecker = new WinnerChecker(board,3);

        //then
        assertTrue(winnerChecker.giveWinnersSymbolIfWinnerExist().equals("Z"));
    }
}