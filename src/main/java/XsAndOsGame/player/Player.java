package XsAndOsGame.player;// Created by Mateusz Płuciennik on 20.01.17.

public class Player implements PlayerInterface {
    private String playerName;
    private String symbol;
    private boolean token;

    public Player(String playerName, String symbol, boolean token) {
        this.playerName = playerName;
        this.symbol = symbol;
        this.token = token;
    }

    public boolean hasToken() {
        return token;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setToken(boolean token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", symbol='" + symbol + '\'' +
                ", token=" + token +
                '}';
    }
}