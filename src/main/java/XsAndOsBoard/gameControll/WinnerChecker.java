package XsAndOsBoard.gameControll;// Created by Mateusz Płuciennik on 17.01.17.

import XsAndOsBoard.board.Board;
import XsAndOsBoard.board.Field;

public class WinnerChecker {
    // TODO: 17.01.17 autowired?
    private Board board;
    private int moves;
    private int amountToVictory;

    public WinnerChecker(Board board, int amountToVictory) {
        this.board = board;
        this.amountToVictory = amountToVictory;
    }

    //pionowo
    public String isWinnerInColumn() {
        int identicalInARowSymbolNumber = 0;
        String lastSymbol = board.getLastMoveFieldSymbol();
        Field checkingField = board.getLastMoveField();

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

    //poziomo
    public String isWinnerInRow() {
        int identicalInARowSymbolNumber = 0;
        Field checkingField = board.getLastMoveField();
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

    public String isWinnerInRightUpSlant() {
        Field checkField = findLeftDownFieldFromLastMoveField();
        int checkFieldXCoordinate = checkField.getFieldXCoordinate();
        int checkFieldYCoordinate = checkField.getFieldYCoordinate();
        String lastMoveSymbol = board.getLastMoveFieldSymbol();
        int identicalInARowSymbolNumber = 0;

        while ((checkField.getFieldXCoordinate() < board.getWidth() || checkField.getFieldYCoordinate() > 0)) {
            if (board.getFieldSymbol(checkField).equals(lastMoveSymbol)) {
                identicalInARowSymbolNumber++;
            } else {
                identicalInARowSymbolNumber = 0;
            }

            if (identicalInARowSymbolNumber == amountToVictory){
                return lastMoveSymbol;
            }

            checkField.setFieldXCoordinate(++checkFieldXCoordinate);
            checkField.setFieldYCoordinate(--checkFieldYCoordinate);
        }
        return "";
    }

    public String isWinnerInRightDownSlant() {
        Field checkField = findLeftUpFieldFromLastMoveField();
        int checkFieldXCoordinate = checkField.getFieldXCoordinate();
        int checkFieldYCoordinate = checkField.getFieldYCoordinate();
        String lastMoveSymbol = board.getLastMoveFieldSymbol();
        int identicalInARowSymbolNumber = 0;

        while ((checkField.getFieldXCoordinate() < board.getWidth() || checkField.getFieldYCoordinate() < board.getHeight())) {
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

    public Field findLeftUpFieldFromLastMoveField() {
        Field lastMoveField = board.getLastMoveField();
        int xCoordinate = lastMoveField.getFieldXCoordinate();
        int yCoordinate = lastMoveField.getFieldYCoordinate();

        while (!(xCoordinate == 0 || yCoordinate == 0)) {
            xCoordinate--;
            yCoordinate--;
        }
        return new Field(xCoordinate, yCoordinate);
    }
}
