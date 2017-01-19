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

    //funkcja sprawdzajaca czy jest zwyciesca. Sprawdza w pionie od punktu ostatniego ruchu
    //pionowo
    public String checkVertical(){
        int amount = 0;
        String lastSymbol = board.getLastMoveFieldSymbol();
        Field checkingField = board.getLastMoveField();

        //tu inkrementujemy Y
        for (int i =0; i<board.getHeight(); i++){
            checkingField.setFieldYCoordinate(i);

            if (board.getFieldSymbol(checkingField).equals(lastSymbol)){
                amount++;
            } else {
                amount =0;
            }

            if (amount == amountToVictory) {
                return board.getFieldSymbol(checkingField);
            }
        }
        return "";
    }

    //poziomo
    public String checkHorizontal(){
        int amount = 0;
        Field checkingField = board.getLastMoveField();
        String lastSymbol = board.getLastMoveFieldSymbol();

        for (int i = 0; i<board.getWidth(); i++){
            checkingField.setFieldXCoordinate(i);
            if (board.getFieldSymbol(checkingField).equals(lastSymbol)){
                amount++;
            } else {
                amount =0;
            }

            if (amount == amountToVictory) {
                return board.getFieldSymbol(checkingField);
            }
        }
        return "";
    }

    public String checkSlants() {
        return "";
    }


    public Field findLeftBottomBorderFromLastMoveField(){
        Field lastMoveField = board.getLastMoveField();
        int xCoordinate = lastMoveField.getFieldXCoordinate();
        int yCoordinate = lastMoveField.getFieldYCoordinate();

        while (true){
            if (xCoordinate == 0 || yCoordinate==board.getHeight()) {
                return new Field(xCoordinate, yCoordinate);
            }
            xCoordinate--;
            yCoordinate++;
        }
    }

    public Field findLeftTopBorderFromLastMoveField(){
        Field lastMoveField = board.getLastMoveField();
        int xCoordinate = lastMoveField.getFieldXCoordinate();
        int yCoordinate = lastMoveField.getFieldYCoordinate();

        while (true){
            if (xCoordinate == 0 || yCoordinate== 0) {
                return new Field(xCoordinate, yCoordinate);
            }
            xCoordinate--;
            yCoordinate--;
        }
    }

    public void help(){
        board.setFieldSymbol(new Field(4,0),"Z");
        board.setFieldSymbol(new Field(3,0),"Z");
        board.setFieldSymbol(new Field(2,0),"Z");

        board.setLastMoveFieldXCoordinate(2);
        board.setLastMoveFieldYCoordinate(0);

        System.out.println(checkHorizontal());
    }
}
