package XsAndOsGame.winnerChecker;// Created by Mateusz Płuciennik on 17.01.17.

import XsAndOsGame.board.Board;
import XsAndOsGame.board.Field;

public class WinnerChecker {
    // TODO: 17.01.17 autowired?
    private Board board;
    private int amountToVictory;

    public WinnerChecker(Board board, int amountToVictory) {
        this.board = board;
        this.amountToVictory = amountToVictory;
    }

    // TODO: 20.01.17 should be private
    public String isWinnerInColumn() {
        int identicalInARowSymbolNumber = 0;
        String lastSymbol = board.getLastMoveFieldSymbol();
        Field checkingField = new Field(board.getLastMoveFieldXCoordinate(), board.getLastMoveFieldYCoordinate());

        for (int i = 0; i < board.getHeight(); i++) {
            checkingField.setFieldYCoordinate(i);

            if (board.getFieldSymbol(checkingField).equals(lastSymbol)) {
                identicalInARowSymbolNumber++;
            } else {
                identicalInARowSymbolNumber = 0;
            }

            if (identicalInARowSymbolNumber == amountToVictory) {
                return board.getFieldSymbol(checkingField);
            }
        }
        return "";
    }
    // TODO: 20.01.17 should be private
    public String isWinnerInRow() {
        int identicalInARowSymbolNumber = 0;
        Field checkingField = new Field(board.getLastMoveFieldXCoordinate(), board.getLastMoveFieldYCoordinate());
        String lastSymbol = board.getLastMoveFieldSymbol();

        for (int i = 0; i < board.getWidth(); i++) {
            checkingField.setFieldXCoordinate(i);
            if (board.getFieldSymbol(checkingField).equals(lastSymbol)) {
                identicalInARowSymbolNumber++;
            } else {
                identicalInARowSymbolNumber = 0;
            }

            if (identicalInARowSymbolNumber == amountToVictory) {
                return board.getFieldSymbol(checkingField);
            }
        }
        return "";
    }
    // TODO: 20.01.17 should be private
    public String isWinnerInRightUpSlant() {
        Field checkingField = findLeftDownFieldFromLastMoveField();
        int checkFieldXCoordinate = checkingField.getFieldXCoordinate();
        int checkFieldYCoordinate = checkingField.getFieldYCoordinate();
        String lastMoveSymbol = board.getLastMoveFieldSymbol();
        int identicalInARowSymbolNumber = 0;

        while (checkFieldXCoordinate < board.getWidth() && checkFieldYCoordinate >= 0) {
            if (board.getFieldSymbol(checkingField).equals(lastMoveSymbol)) {
                identicalInARowSymbolNumber++;
            } else {
                identicalInARowSymbolNumber = 0;
            }

            if (identicalInARowSymbolNumber == amountToVictory){
                return lastMoveSymbol;
            }

            checkingField.setFieldXCoordinate(++checkFieldXCoordinate);
            checkingField.setFieldYCoordinate(--checkFieldYCoordinate);
        }
        return "";
    }
    // TODO: 20.01.17 should be private
    public String isWinnerInRightDownSlant() {
        Field checkField = findLeftUpFieldFromLastMoveField();
        int checkFieldXCoordinate = checkField.getFieldXCoordinate();
        int checkFieldYCoordinate = checkField.getFieldYCoordinate();
        String lastMoveSymbol = board.getLastMoveFieldSymbol();
        int identicalInARowSymbolNumber = 0;

        while (checkFieldXCoordinate < board.getWidth() && checkFieldYCoordinate < board.getHeight()) {
            if (board.getFieldSymbol(checkField).equals(lastMoveSymbol)) {
                identicalInARowSymbolNumber++;
            } else {
                identicalInARowSymbolNumber = 0;
            }

            if (identicalInARowSymbolNumber == amountToVictory){
                return lastMoveSymbol;
            }

            checkField.setFieldXCoordinate(++checkFieldXCoordinate);
            checkField.setFieldYCoordinate(++checkFieldYCoordinate);
        }
        return "";
    }
    // TODO: 20.01.17 should be private
    public Field findLeftDownFieldFromLastMoveField() {
        Field lastMoveField = board.getLastMoveField();
        int xCoordinate = lastMoveField.getFieldXCoordinate();
        int yCoordinate = lastMoveField.getFieldYCoordinate();

        while (!(xCoordinate == 0 || yCoordinate == board.getHeight()-1)) {
            xCoordinate--;
            yCoordinate++;
        }
        return new Field(xCoordinate, yCoordinate);
    }
    // TODO: 20.01.17 should be private
    public Field findLeftUpFieldFromLastMoveField() {
        Field lastMoveField = board.getLastMoveField();
        int xCoordinate = lastMoveField.getFieldXCoordinate();
        int yCoordinate = lastMoveField.getFieldYCoordinate();

        while (!(xCoordinate ==0 || yCoordinate == 0)) {
            xCoordinate--;
            yCoordinate--;
        }
        return new Field(xCoordinate, yCoordinate);
    }

    public String giveWinnersSymbolIfWinnerExist(){
        String winnerSymbol = isWinnerInColumn();
        if (!winnerSymbol.equals("")) return winnerSymbol;

        winnerSymbol = isWinnerInRow();
        if (!winnerSymbol.equals("")) return winnerSymbol;

        winnerSymbol = isWinnerInRightDownSlant();
        if (!winnerSymbol.equals("")) return winnerSymbol;

        winnerSymbol = isWinnerInRightUpSlant();
        if (!winnerSymbol.equals("")) return winnerSymbol;

        return "";
    }
}
