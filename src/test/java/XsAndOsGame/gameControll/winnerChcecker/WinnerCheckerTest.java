package XsAndOsGame.gameControll.winnerChcecker;

import XsAndOsGame.board.Board;
import XsAndOsGame.board.Field;
import XsAndOsGame.winnerChecker.WinnerChecker;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
// Created by Mateusz Płuciennik on 17.01.17.

public class WinnerCheckerTest {
    @Test
    public void shouldGiveWinnerSymbolWhenWinnerIsInRow(){
        //given
        String symbol = "X";
        Board board = new Board(3,3);
        Field lastMoveField = new Field(1,1);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(0,1), symbol);
        board.setFieldSymbol(new Field(1,1), symbol);
        board.setFieldSymbol(new Field(2,1), symbol);

        WinnerChecker winnerChecker = new WinnerChecker(board,3);
        //when
        //then
        assertTrue(winnerChecker.giveWinnersSymbolIfWinnerExist().equals(symbol));
    }

    @Test
    public void shouldGiveWinnerSymbolWhenWinnerIsInColumn(){
        //given
        String symbol = "X";
        Board board = new Board(3,3);
        Field lastMoveField = new Field(1,1);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(1,0), symbol);
        board.setFieldSymbol(new Field(1,1), symbol);
        board.setFieldSymbol(new Field(1,2), symbol);

        WinnerChecker winnerChecker = new WinnerChecker(board,3);
        //when
        //then
        assertTrue(winnerChecker.giveWinnersSymbolIfWinnerExist().equals(symbol));
    }

    @Test
    public void shouldGiveWinnerSymbolWhenWinnerIsInRightUpSlant(){
        //given
        String symbol = "X";
        Board board = new Board(3,3);
        Field lastMoveField = new Field(1,1);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(0,0), symbol);
        board.setFieldSymbol(new Field(1,1), symbol);
        board.setFieldSymbol(new Field(2,2), symbol);

        WinnerChecker winnerChecker = new WinnerChecker(board,3);
        //when
        //then
        assertTrue(winnerChecker.giveWinnersSymbolIfWinnerExist().equals(symbol));
    }

    @Test
    public void shouldGiveWinnerSymbolWhenWinnerIsInRightDownSlant(){
        //given
        String symbol = "X";
        Board board = new Board(3,3);
        Field lastMoveField = new Field(1,1);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(0,2), symbol);
        board.setFieldSymbol(new Field(1,1), symbol);
        board.setFieldSymbol(new Field(2,0), symbol);

        WinnerChecker winnerChecker = new WinnerChecker(board,3);
        //when
        //then
        assertTrue(winnerChecker.giveWinnersSymbolIfWinnerExist().equals(symbol));
    }
}