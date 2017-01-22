package XsAndOsGame.gameControll;// Created by Mateusz Płuciennik on 20.01.17.

import XsAndOsGame.board.Board;
import XsAndOsGame.board.Field;
import XsAndOsGame.exceptions.FieldIsNotEmptyException;
import XsAndOsGame.player.Player;
import XsAndOsGame.winnerChecker.WinnerChecker;

import java.util.LinkedList;
import java.util.ListIterator;

public class GameController {
    private LinkedList<Player> players;
    private int moves = 0;
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

    public void addMove(){
        moves++;
    }

    public Player giveWinnerIfExist(){
        String winnerSymbol = winnerChecker.giveWinnersSymbolIfWinnerExist();

        if (!winnerSymbol.equals("")){
            for(Player player : players){
                if(player.getSymbol().equals(winnerSymbol)) {
                    return player;
                }
            }
        }
        return null;
    }

    public void addPlayer(Player player){
     players.add(player);
    }

    public void makeMove(Field field, String symbol) throws FieldIsNotEmptyException {

        if (board.getFieldSymbol(field).equals("0")){
            throw new FieldIsNotEmptyException();
        } else {
            board.setLastMoveFieldSymbol(symbol);
            board.setLastMoveField(field);
            board.setFieldSymbol(field,symbol);
            addMove();
        }
    }


}
