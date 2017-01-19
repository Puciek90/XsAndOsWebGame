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
        int amount = 0;
        String lastSymbol = board.getLastMoveFieldSymbol();
        Field checkingField = board.getLastMoveField();

        for (int i = 0; i < board.getHeight(); i++) {
            checkingField.setFieldYCoordinate(i);

            if (board.getFieldSymbol(checkingField).equals(lastSymbol)) {
                amount++;
            } else {
                amount = 0;
            }

            if (amount == amountToVictory) {
                return board.getFieldSymbol(checkingField);
            }
        }
        return "";
    }

    //poziomo
    public String isWinnerInRow() {
        int amount = 0;
        Field checkingField = board.getLastMoveField();
        String lastSymbol = board.getLastMoveFieldSymbol();

        for (int i = 0; i < board.getWidth(); i++) {
            checkingField.setFieldXCoordinate(i);
            if (board.getFieldSymbol(checkingField).equals(lastSymbol)) {
                amount++;
            } else {
                amount = 0;
            }

            if (amount == amountToVictory) {
                return board.getFieldSymbol(checkingField);
            }
        }
        return "";
    }

    // TODO: 19.01.17 dziala w nieskonczonosc!
    public String isWinnerInRightUpSlant() {
        Field checkField = findLeftDownFieldFromLastMoveField();
        int checkFieldXCoordinate = checkField.getFieldXCoordinate();
        int checkFieldYCoordinate = checkField.getFieldYCoordinate();
        String lastMoveSymbol = board.getLastMoveFieldSymbol();
        int amount = 0;

        while (!(checkField.getFieldXCoordinate() == board.getWidth()-1 || checkField.getFieldYCoordinate() == 0)) {
            if (board.getFieldSymbol(checkField).equals(lastMoveSymbol)) {
                amount++;
            } else {
                amount = 0;
            }

            if (amount == amountToVictory){
                return lastMoveSymbol;
            }

            checkFieldXCoordinate++;
            checkFieldYCoordinate--;
            checkField.setFieldXCoordinate(checkFieldXCoordinate);
            checkField.setFieldYCoordinate(checkFieldYCoordinate);
        }
        return "";
    }

    public String isWinnerInRightDownSlant() {
        return "";
    }

    // TODO: 19.01.17 zrobiono warunek graniczny!!!!!
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

    public void help() {
        board.setFieldSymbol(new Field(4, 0), "Z");
        board.setFieldSymbol(new Field(3, 0), "Z");
        board.setFieldSymbol(new Field(2, 0), "Z");

        board.setLastMoveFieldXCoordinate(2);
        board.setLastMoveFieldYCoordinate(0);

        System.out.println(isWinnerInRow());
    }
}
