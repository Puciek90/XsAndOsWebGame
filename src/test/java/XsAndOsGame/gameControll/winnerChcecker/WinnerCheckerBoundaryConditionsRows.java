package XsAndOsGame.gameControll.winnerChcecker;// Created by Mateusz Płuciennik on 21.01.17.

import XsAndOsGame.board.Board;
import XsAndOsGame.board.Field;
import XsAndOsGame.winnerChecker.WinnerChecker;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WinnerCheckerBoundaryConditionsRows {
    @Test
    public void shouldFindWinnerInRowWhenLastMoveBeginsRow() {
        //given
        String symbol = "X";

        Field lastMovieField = new Field(0,0);
        Board board = new Board(1,3);
        board.setLastMoveField(lastMovieField);

        board.setFieldSymbol(new Field(0,0), symbol);
        board.setFieldSymbol(new Field(1,0), symbol);
        board.setFieldSymbol(new Field(2,0), symbol);

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);

        //then
        assertTrue(winnerChecker.isWinnerInRow().equals(symbol));
    }

    @Test
    public void shouldFindWinnerInRowWhenLastMoveEndsRow() {
        //given
        String symbol = "X";

        Field lastMovieField = new Field(2,0);
        Board board = new Board(1,3);
        board.setLastMoveField(lastMovieField);

        board.setFieldSymbol(new Field(0,0), symbol);
        board.setFieldSymbol(new Field(1,0), symbol);
        board.setFieldSymbol(new Field(2,0), symbol);

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);

        //then
        assertTrue(winnerChecker.isWinnerInRow().equals(symbol));
    }

    @Test
    public void shouldFindWinnerInRowWhenWinnerIsInTheMiddle() {
        //given
        String symbol = "X";
        Field lastMoveField = new Field(2,0);
        Board board = new Board(1,5);
        board.setLastMoveField(lastMoveField);
        board.setFieldSymbol(new Field(1,0), symbol);
        board.setFieldSymbol(new Field(2,0), symbol);
        board.setFieldSymbol(new Field(3,0), symbol);

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);

        //then
        assertTrue(winnerChecker.isWinnerInRow().equals(symbol));
    }

    @Test
    public void shouldFindWinnerWhereRowIsFull() {
        //given
        String symbol = "X";
        Field lastMoveField = new Field(2,0);
        Board board = new Board(1,6);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(0,0), symbol);
        board.setFieldSymbol(new Field(1,0), symbol);
        board.setFieldSymbol(new Field(2,0), symbol);
        board.setFieldSymbol(new Field(3,0), symbol);
        board.setFieldSymbol(new Field(4,0), symbol);
        board.setFieldSymbol(new Field(5,0), symbol);

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 6);

        //then
        assertTrue(winnerChecker.isWinnerInRow().equals(symbol));
    }

    @Test
    public void shouldNotFindWinnerInRow(){
        //given
        Field lastMoveField = new Field(2,0);
        Board board = new Board(1,5);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(2,0), "Z");

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);

        //then
        assertTrue(winnerChecker.isWinnerInRow().equals(""));
    }
}
