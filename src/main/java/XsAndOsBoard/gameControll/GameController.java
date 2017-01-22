package XsAndOsBoard.gameControll;// Created by Mateusz Płuciennik on 20.01.17.

import XsAndOsBoard.board.Board;
import XsAndOsBoard.player.Player;

import java.util.LinkedList;
import java.util.ListIterator;

public class GameController {
    private LinkedList<Player> players;
    private int moves;
    // TODO: 20.01.17 Autowired
    private WinnerChecker winnerChecker;
    // TODO: 20.01.17 autowired
    private Board board;
    private int playersNumer;

    public GameController(WinnerChecker winnerChecker, int playerNumber){
        this.winnerChecker = winnerChecker;
        this.playersNumer = playerNumber;
    }

    public void displayPlayers(){
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public void passTokenToNextPlayer(){
        ListIterator<Player> iterator = players.listIterator();

        while (iterator.hasNext()){
            Player player = iterator.next();

            if (player.hasToken()) {
                player.setToken(false);

                if(iterator.hasNext()) {
                    Player nextPlayer = iterator.next();
                    nextPlayer.setToken(true);
                } else {
                    Player firstPlayerInList = players.getFirst();
                    firstPlayerInList.setToken(true);
                }
            }
        }

    }

    public boolean checkIfAnyPlayerHasToken(){
        ListIterator<Player> iterator = players.listIterator();

        while (iterator.hasNext()){
            Player player = iterator.next();
            if (player.hasToken()){
            return true;
            }
        }
        return false;
    }

    public boolean checkIfPlayerListHasOnlyOneToken() {
        ListIterator<Player> iterator = players.listIterator();
        int tokenCounter = 0;

        while (iterator.hasNext()){
            Player player = iterator.next();
            if (player.hasToken()){
                tokenCounter++;
            }
        }
        return (tokenCounter == 1);
    }

    //setting last move in board

  /*  public Player giveWinnerIfExist(){
        winnerChecker.

        return null;
    }*/
}
