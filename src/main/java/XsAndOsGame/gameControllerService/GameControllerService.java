package XsAndOsGame.gameControllerService;// Created by Mateusz Płuciennik on 22.01.17.

import XsAndOsGame.board.Board;
import XsAndOsGame.player.Player;

import java.util.LinkedList;

public interface GameControllerService {
    LinkedList<Player> getPlayers();
    Board getBoard();
    void addPlayer(Player player);
}
