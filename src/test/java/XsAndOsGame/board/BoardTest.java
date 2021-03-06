package XsAndOsGame.board;

// Created by Mateusz Płuciennik on 17.01.17.

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void shouldInitBoard(){
        //given
        Integer width = 4;
        Integer height = 5;
        Board board = new Board(height, width);
        String[] rowInBoard = new String[]{"0","0","0","0"};

        //then
        assertThat(board.getBoard(), hasSize(height));
        for (List<String> row : board.getBoard()) {
            assertThat(row, hasSize(width));
            assertTrue(row.equals(Arrays.asList(rowInBoard)));
        }
    }

    @Test
    public void shouldSetLastMoveFieldCoordinates(){
        //given
        Board board = new Board(3,3);

        //when
        board.setLastMoveFieldYCoordinate(1);
        board.setLastMoveFieldXCoordinate(2);

        //then
        assertTrue(board.getLastMoveField().getFieldYCoordinate() == 1);
        assertTrue(board.getLastMoveField().getFieldXCoordinate() == 2);

        Field field = board.getLastMoveField();
        assertTrue(field.getFieldYCoordinate() == 1);
        assertTrue(field.getFieldXCoordinate() == 2);
    }

    @Test
    public void shouldSetLastMovieFieldSymbol(){
        //given
        Board board = new Board(3,3);

        //when
        board.setLastMoveField(new Field(1,1));
        board.setLastMoveFieldSymbol("Z");

        //then
        assertTrue(board.getBoard().get(1).get(1).equals("Z"));
        assertTrue(board.getLastMoveFieldSymbol().equals("Z"));
    }

    @Test
    public void shouldSetLastMovieFieldXCoordinate(){
        //given
        Board board = new Board(3,3);

        //when
        board.setLastMoveFieldXCoordinate(1);

        //then
        assertTrue(board.getLastMoveFieldXCoordinate() == 1);
    }


    @Test
    public void shouldSetLastMovieFieldYCoordinate(){
        //given
        Board board = new Board(3,3);

        //when
        board.setLastMoveFieldYCoordinate(1);

        //then
        assertTrue(board.getLastMoveFieldYCoordinate() == 1);
    }

}