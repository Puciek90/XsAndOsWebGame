package XsAndOsGame.gameControll;

import XsAndOsGame.board.Board;
import XsAndOsGame.player.Player;
import XsAndOsGame.winnerChecker.WinnerChecker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

// Created by Mateusz Płuciennik on 20.01.17.
@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {
    @Mock
    private WinnerChecker winnerChecker;

    @Mock
    private Board board;

    @Test
    public void shouldPassTokenToNextPlayer(){
        //given
        GameController gameController = new GameController(winnerChecker, 3);

        Player player1 = new Player("mateusz", "X", true); //0
        Player player2 = new Player("marek", "O", false); //1
        Player player3 = new Player("patryk", "Z", false); //2

        LinkedList<Player> players = new LinkedList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        gameController.setPlayers(players);

        //when
        gameController.passTokenToNextPlayer();

        //then
        assertTrue(gameController.getPlayers().get(1).hasToken());
        assertFalse(gameController.getPlayers().get(0).hasToken());
    }

    @Test
    public void shouldPassTokenToFirstInListPlayer(){
        //given
        GameController gameController = new GameController(winnerChecker, 3);

        Player firstPlayer = new Player("mateusz", "X", false); //0
        Player lastPlayer = new Player("patryk", "Z", true); //1

        LinkedList<Player> players = new LinkedList<Player>();
        players.add(firstPlayer);
        players.add(lastPlayer);

        gameController.setPlayers(players);

        //when
        gameController.passTokenToNextPlayer();

        //then
        assertTrue(gameController.getPlayers().get(0).hasToken());
        assertFalse(gameController.getPlayers().get(1).hasToken());
    }

    @Test
    public void shouldGiveThatSomePlayerHasToken(){
        //given
        GameController gameController = new GameController(winnerChecker, 3);

        Player firstPlayer = new Player("mateusz", "X", false); //0
        Player lastPlayer = new Player("patryk", "Z", true); //1

        LinkedList<Player> players = new LinkedList<Player>();
        players.add(firstPlayer);
        players.add(lastPlayer);
        gameController.setPlayers(players);

        //when

        //then
        assertTrue(gameController.checkIfAnyPlayerHasToken());
    }

    @Test
    public void shouldGiveThatAnyPlayerHasToken(){
        GameController gameController = new GameController(winnerChecker, 3);

        Player firstPlayer = new Player("mateusz", "X", false); //0
        Player lastPlayer = new Player("patryk", "Z", false); //1

        LinkedList<Player> players = new LinkedList<Player>();
        players.add(firstPlayer);
        players.add(lastPlayer);
        gameController.setPlayers(players);

        //when

        //then
        assertFalse(gameController.checkIfAnyPlayerHasToken());
    }

    @Test
    public void shouldDetectMoreOrLessThanOneTokenInPlayerList(){
        //given
        GameController gameController = new GameController(winnerChecker, 3);

        Player firstPlayer = new Player("mateusz", "X", false); //0
        Player lastPlayer = new Player("patryk", "Z", false); //1

        LinkedList<Player> players = new LinkedList<Player>();
        players.add(firstPlayer);
        players.add(lastPlayer);
        gameController.setPlayers(players);

        //when
        //then
        assertFalse(gameController.checkIfPlayerListHasOnlyOneToken());
    }

    @Test
    public void shouldDetectOnlyOneTokenInPlayerList(){
        GameController gameController = new GameController(winnerChecker, 2);

        Player firstPlayer = new Player("mateusz", "X", false); //0
        Player lastPlayer = new Player("patryk", "Z", true); //1

        LinkedList<Player> players = new LinkedList<Player>();
        players.add(firstPlayer);
        players.add(lastPlayer);
        gameController.setPlayers(players);

        //when
        //then
        assertTrue(gameController.checkIfPlayerListHasOnlyOneToken());
    }

    @Test
    public void shouldGiveWinningPlayer(){
        //given
        GameController gameController = new GameController(winnerChecker,2);
        Player firstPlayer = new Player("mateusz", "X", false); //0
        Player lastPlayer = new Player("patryk", "Z", true); //1

        LinkedList<Player> players = new LinkedList<Player>();
        players.add(firstPlayer);
        players.add(lastPlayer);
        gameController.setPlayers(players);

        //when
        when(winnerChecker.giveWinnersSymbolIfWinnerExist()).thenReturn("X");

        //then
        assertTrue(gameController.giveWinnerIfExist().equals(firstPlayer));
        assertFalse(gameController.giveWinnerIfExist().equals(lastPlayer));
    }

    @Test
    public void shouldNotGiveWinningPlayer(){
        //given
        GameController gameController = new GameController(winnerChecker,2);
        LinkedList<Player> players = new LinkedList<Player>();

        //when
        when(winnerChecker.giveWinnersSymbolIfWinnerExist()).thenReturn("");

        //then
        assertTrue(gameController.giveWinnerIfExist() == null);
    }

    @Test
    public void shouldAddPlayer(){
        //given
        GameController gameController = new GameController(winnerChecker,2);
        Player firstPlayer = new Player("mateusz", "X", false); //0

        LinkedList<Player> players = new LinkedList<Player>();
        gameController.setPlayers(players);

        //when
        gameController.addPlayer(firstPlayer);

        //then
        assertThat(gameController.getPlayers(), hasSize(1));
    }

    /*
    @Test
    public void shouldMakeMove() throws FieldIsNotEmptyException {
        //given
        GameController gameController = new GameController(winnerChecker, 3);
        Field field = new Field(1,1);
        String symbol = "X";

        //when
        when(board.getFieldSymbol(field)).thenReturn("0");
        gameController.makeMove(field, symbol);
        //then
        verify(board, times(1)).setLastMoveFieldSymbol(anyString());
        verify(board, times(1)).setLastMoveField(field);
        verify(board, times(1)).setFieldSymbol(field, symbol);
    } */
}