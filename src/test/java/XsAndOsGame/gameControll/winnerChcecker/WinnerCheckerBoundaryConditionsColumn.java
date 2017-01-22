package XsAndOsGame.gameControll.winnerChcecker;// Created by Mateusz Płuciennik on 21.01.17.

import XsAndOsGame.board.Board;
import XsAndOsGame.board.Field;
import XsAndOsGame.winnerChecker.WinnerChecker;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WinnerCheckerBoundaryConditionsColumn {
    @Test
    public void shouldFindWinnerInColumnWhenLastMoveBeginsColumn(){
        //given
        String symbol = "X";
        Field lastMovieField = new Field(0,0);
        Board board = new Board(3,1);

        board.setFieldSymbol(new Field(0,0), symbol);
        board.setFieldSymbol(new Field(0,1), symbol);
        board.setFieldSymbol(new Field(0,2), symbol);
        board.setLastMoveField(lastMovieField);

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);

        //then
        assertTrue(winnerChecker.isWinnerInColumn().equals(symbol));
    }

    @Test
    public void shouldFindWinnerInColumnWhenLastMoveEndsColumn(){
        //given
        String symbol = "X";
        Field lastMovieField = new Field(0,2);
        Board board = new Board(3,1);

        board.setFieldSymbol(new Field(0,0), symbol);
        board.setFieldSymbol(new Field(0,1), symbol);
        board.setFieldSymbol(new Field(0,2), symbol);
        board.setLastMoveField(lastMovieField);

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);

        //then
        assertTrue(winnerChecker.isWinnerInColumn().equals(symbol));
    }

    @Test
    public void shouldFindWinnerInColumnWhenWinnerIsInTheMiddle() {
        //given
        String symbol = "X";
        Field lastMovieField = new Field(0,2);
        Board board = new Board(5, 1);

        board.setFieldSymbol(new Field(0, 1), symbol);
        board.setFieldSymbol(new Field(0, 2), symbol);
        board.setFieldSymbol(new Field(0, 3), symbol);
        board.setLastMoveField(lastMovieField);

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);

        //then
        assertTrue(winnerChecker.isWinnerInColumn().equals(symbol));
    }

    @Test
    public void shouldFindWinnerWhereColumnIsFull() {
        //given
        String symbol = "X";
        Field lastMovieField = new Field(0,2);
        Board board = new Board(5, 1);

        board.setFieldSymbol(new Field(0, 0), symbol);
        board.setFieldSymbol(new Field(0, 1), symbol);
        board.setFieldSymbol(new Field(0, 2), symbol);
        board.setFieldSymbol(new Field(0, 3), symbol);
        board.setFieldSymbol(new Field(0, 4), symbol);
        board.setLastMoveField(lastMovieField);

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 5);

        //then
        assertTrue(winnerChecker.isWinnerInColumn().equals(symbol));
    }

    @Test
    public void shouldNotFindWinnerInColumn(){
        //given
        Field lastMoveField = new Field(0,2);
        Board board = new Board(5,1);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(0,2), "Z");

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);

        //then
        assertTrue(winnerChecker.isWinnerInRow().equals(""));
    }
}
