package XsAndOsBoard.gameControll;

import XsAndOsBoard.board.Board;
import XsAndOsBoard.board.Field;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
// Created by Mateusz Płuciennik on 17.01.17.

public class WinnerCheckerTest {
    @Test
    public void shouldFindWinnerInRow() {
        //given
        Field lastMovieField = new Field(0,0);
        Board board = new Board(1,3);
        board.setLastMoveField(lastMovieField);

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);

        //then
        assertTrue(winnerChecker.isWinnerInRow().equals("0"));
    }

    @Test
    public void shouldFindWinnerInRow2() {
        //given
        Field lastMoveField = new Field(2,0);
        Board board = new Board(1,5);
        board.setLastMoveField(lastMoveField);
        board.setFieldSymbol(new Field(2,0), "Z");
        board.setFieldSymbol(new Field(3,0), "Z");
        board.setFieldSymbol(new Field(4,0), "Z");

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);

        //then
        assertTrue(winnerChecker.isWinnerInRow().equals("Z"));
    }

    @Test
    public void shouldFindWinnerInRow3() {
        //given
        Field lastMoveField = new Field(2,0);
        Board board = new Board(1,6);

        board.setLastMoveField(lastMoveField);
        board.setFieldSymbol(new Field(1,0), "Z");
        board.setFieldSymbol(new Field(2,0), "Z");
        board.setFieldSymbol(new Field(3,0), "Z");
        board.setFieldSymbol(new Field(4,0), "Z");
        board.setFieldSymbol(new Field(5,0), "Z");

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 5);

        //then
        assertTrue(winnerChecker.isWinnerInRow().equals("Z"));
    }


    @Test
    public void shouldFindWinnerInColumn(){
        //given
        Field lastMovieField = new Field(0,0);
        Board board = new Board(3,1);
        board.setLastMoveField(lastMovieField);

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);

        //then
        assertTrue(winnerChecker.isWinnerInColumn().equals("0"));
    }

    @Test
    public void shouldFindWinnerInColumn2(){
        //given
        Field lastMoveField = new Field(0,2);
        Board board = new Board(5,1);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(0,2), "Z");
        board.setFieldSymbol(new Field(0,3), "Z");
        board.setFieldSymbol(new Field(0,4), "Z");

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 3);

        //then
        assertTrue(winnerChecker.isWinnerInColumn().equals("Z"));
    }

    @Test
    public void shouldFindWinnerInColumn3(){
        //given
        Field lastMoveField = new Field(0,3);
        Board board = new Board(6,1);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(0,1), "Z");
        board.setFieldSymbol(new Field(0,2), "Z");
        board.setFieldSymbol(new Field(0,3), "Z");
        board.setFieldSymbol(new Field(0,4), "Z");
        board.setFieldSymbol(new Field(0,5), "Z");

        //when
        WinnerChecker winnerChecker = new WinnerChecker(board, 5);

        //then
        assertTrue(winnerChecker.isWinnerInColumn().equals("Z"));
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

    // TODO: 19.01.17 Change function name! Present name mislead.
    // TODO: 19.01.17 test more points without code duplication 
    @Test
    public void shouldFindLeftDownFieldFromLastMoveField(){
        //given
        Board board = new Board(10,10);
        Field lastMoveField = new Field(5,5);
        board.setLastMoveField(lastMoveField);

        WinnerChecker winnerChecker = new WinnerChecker(board,3);

        //when
        Field field = winnerChecker.findLeftDownFieldFromLastMoveField();

        //then
        assertTrue(field.getFieldXCoordinate()==1);
        assertTrue(field.getFieldYCoordinate()==9);

    }

    // TODO: 19.01.17 test more points without code duplication
    @Test
    public void shouldFindTopFieldFromLastMoveField(){
        //given
        Board board = new Board(10,10);
        Field lastMoveField = new Field(8,10);
        board.setLastMoveField(lastMoveField);

        WinnerChecker winnerChecker = new WinnerChecker(board,3);

        //when
        Field field = winnerChecker.findLeftUpFieldFromLastMoveField();

        //then
        assertTrue(field.getFieldXCoordinate()==0);
        assertTrue(field.getFieldYCoordinate()==2);
    }

    @Test
    public void shouldFindWinnerInRightUpSlant(){
        //given
        Board board = new Board(10,10);
        Field lastMoveField = new Field(5,5);
        board.setLastMoveField(lastMoveField);

        board.setFieldSymbol(new Field(5,5), "Z");
        board.setFieldSymbol(new Field(6,4), "Z");
        board.setFieldSymbol(new Field(7,3), "Z");

        WinnerChecker winnerChecker = new WinnerChecker(board,3);

        //when

        //then
        assertTrue(winnerChecker.isWinnerInRightUpSlant().equals("Z"));
    }
}