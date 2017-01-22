package XsAndOsGame.gameControll.winnerChcecker;// Created by Mateusz Płuciennik on 21.01.17.

import XsAndOsGame.board.Board;
import XsAndOsGame.board.Field;
import XsAndOsGame.winnerChecker.WinnerChecker;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WinnerCheckerBoundaryConditionsLeftAndUpEdgesFieldsFinding {
    @Test
    public void shouldFindFieldWhenLastMoveFieldIsInTopLeftCorner(){
        //given
        Board board = new Board(2,2);
        Field lastMoveField = new Field(0,0);
        board.setLastMoveField(lastMoveField);

        WinnerChecker winnerChecker = new WinnerChecker(board,1);

        //when
        Field field = winnerChecker.findLeftUpFieldFromLastMoveField();

        //then
        assertTrue(field.getFieldXCoordinate()==0);
        assertTrue(field.getFieldYCoordinate()==0);

    }

    @Test
    public void shouldFindFieldWhenLastMoveFieldIsInTopRightCorner(){
        //given
        Board board = new Board(2,2);
        Field lastMoveField = new Field(1,0);
        board.setLastMoveField(lastMoveField);

        WinnerChecker winnerChecker = new WinnerChecker(board,1);

        //when
        Field field = winnerChecker.findLeftUpFieldFromLastMoveField();

        //then
        assertTrue(field.getFieldXCoordinate()==1);
        assertTrue(field.getFieldYCoordinate()==0);
    }

    @Test
    public void shouldFindFieldWhenLastMoveFieldIsInDownRightCorner(){
        //given
        Board board = new Board(2,2);
        Field lastMoveField = new Field(1,1);
        board.setLastMoveField(lastMoveField);

        WinnerChecker winnerChecker = new WinnerChecker(board,1);

        //when
        Field field = winnerChecker.findLeftUpFieldFromLastMoveField();

        //then
        assertTrue(field.getFieldXCoordinate()==0);
        assertTrue(field.getFieldYCoordinate()==0);
    }

    @Test
    public void shouldFindFieldWhenLastMoveFieldIsInDownLeftCorner(){
        //given
        Board board = new Board(2,2);
        Field lastMoveField = new Field(0,1);
        board.setLastMoveField(lastMoveField);

        WinnerChecker winnerChecker = new WinnerChecker(board,1);

        //when
        Field field = winnerChecker.findLeftUpFieldFromLastMoveField();

        //then
        assertTrue(field.getFieldXCoordinate()==0);
        assertTrue(field.getFieldYCoordinate()==1);
    }

    @Test
    public void shouldFindBoardUpEdge(){
        Board board = new Board(5,5);


        for (int i = 0; i< 5; i++) {
            Field lastMoveField = new Field(i,0);
            board.setLastMoveField(lastMoveField);
            WinnerChecker winnerChecker = new WinnerChecker(board,1);

            Field field = winnerChecker.findLeftUpFieldFromLastMoveField();

            assertTrue(field.getFieldXCoordinate() == i);
            assertTrue(field.getFieldYCoordinate() == 0);
        }
    }

    @Test
    public void shouldFindBoardLeftEdge(){
        Board board = new Board(5,5);

        for (int i = 0; i< 5; i++) {
            Field lastMoveField = new Field(i,4);
            board.setLastMoveField(lastMoveField);
            WinnerChecker winnerChecker = new WinnerChecker(board,1);

            Field field = winnerChecker.findLeftUpFieldFromLastMoveField();

            assertTrue(field.getFieldXCoordinate() == 0);
            assertTrue(field.getFieldYCoordinate() == 4-i);
        }
    }
}
