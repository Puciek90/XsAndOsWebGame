package XsAndOsBoard.gameControll.winnerChcecker;// Created by Mateusz Płuciennik on 21.01.17.

import XsAndOsBoard.board.Board;
import XsAndOsBoard.board.Field;
import XsAndOsBoard.gameControll.WinnerChecker;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WinnerCheckerRightUpSlantTest {

    @Test
    public void shouldFindWinnerInRightUpSlantWhenSlantIsFull(){
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
        assertTrue(winnerChecker.isWinnerInRightUpSlant().equals(symbol));
    }

    @Test
    public void shouldFindWinnerInRightUpSlantWhenLastMoveBeginsSlant(){
        //given
        String symbol = "X";
        Board board = new Board(4,4);
        Field lastMoveField = new Field(0,3);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(0,3), symbol);
        board.setFieldSymbol(new Field(1,2), symbol);
        board.setFieldSymbol(new Field(2,1), symbol);

        WinnerChecker winnerChecker = new WinnerChecker(board,3);
        //when
        //then
        assertTrue(winnerChecker.isWinnerInRightUpSlant().equals(symbol));
    }

    @Test
    public void shouldFindWinnerInRightUpSlantWhenLastMoveEndsSlant(){
        //given
        String symbol = "X";
        Board board = new Board(4,4);
        Field lastMoveField = new Field(3,0);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(1,2), symbol);
        board.setFieldSymbol(new Field(2,1), symbol);
        board.setFieldSymbol(new Field(3,0), symbol);

        WinnerChecker winnerChecker = new WinnerChecker(board,3);
        //when
        //then
        assertTrue(winnerChecker.isWinnerInRightUpSlant().equals(symbol));
    }

    @Test
    public void shouldFindWinnerInRightUpSlantWhenWinnerIsInTheMiddle(){
        //given
        String symbol = "X";
        Board board = new Board(5,5);
        Field lastMoveField = new Field(2,2);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(1,3), symbol);
        board.setFieldSymbol(new Field(2,2), symbol);
        board.setFieldSymbol(new Field(3,1), symbol);

        WinnerChecker winnerChecker = new WinnerChecker(board,3);
        //when
        //then
        assertTrue(winnerChecker.isWinnerInRightUpSlant().equals(symbol));
    }

    @Test
    public void  shouldNotFindWinnerWhenLastMoveFieldIsInRightBoardCorner(){
        //given
        Board board = new Board(3,3);
        Field lastMoveField = new Field(2,2);
        board.setLastMoveField(lastMoveField);

        WinnerChecker winnerChecker = new WinnerChecker(board,3);
        //when
        //then
        assertTrue(winnerChecker.isWinnerInRightUpSlant().equals(""));
    }

    @Test
    public void  shouldNotFindWinnerWhenLastMoveFieldIsInLeftUpBoardCorner(){
        //given
        Board board = new Board(3,3);
        Field lastMoveField = new Field(0,0);
        board.setLastMoveField(lastMoveField);

        WinnerChecker winnerChecker = new WinnerChecker(board,3);
        //when
        //then
        assertTrue(winnerChecker.isWinnerInRightUpSlant().equals(""));
    }

    @Test
    public void  shouldNotFindWinnerWhenLastMoveFieldIsInCenter(){
        //given
        Board board = new Board(3,3);
        Field lastMoveField = new Field(1,1);
        board.setLastMoveField(lastMoveField);
        board.setLastMoveFieldSymbol("");

        WinnerChecker winnerChecker = new WinnerChecker(board,3);
        //when
        //then
        assertTrue(winnerChecker.isWinnerInRightUpSlant().equals(""));
    }
}
