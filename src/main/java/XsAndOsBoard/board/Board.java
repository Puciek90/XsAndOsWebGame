package XsAndOsBoard.board;// Created by Mateusz Płuciennik on 15.01.17.

import java.util.ArrayList;

public class Board {

    // TODO: 15.01.17 jeżeli amoutToVictory jest większe niż mniejszy z wymiarów -> exception
    public Board(int height, int width, int amountToVictory) {
        board = new ArrayList<ArrayList<String>>();
        this.height = height;
        this.width = width;
        this.moves = 0;
        initBoard(amountToVictory);
    }

    private ArrayList<ArrayList<String>> board;
    private Field lastMoveField;
    private int height;
    private int width;
    private int moves;
    private int amountToVictory;

    public void initBoard(int amountToVictory) {
        for (int j = 0; j < height; j++) {
            ArrayList<String> column = new ArrayList<String>(width);
            for (int i = 0; i < width; i++) {
                column.add("0");
            }
            board.add(column);
            this.amountToVictory = amountToVictory;
        }

        // TODO: 15.01.17 zastanowić się czy tego gdzieś nie przenieść
        lastMoveField = new Field(0,0);
    }

    //funkcja sprawdzajaca czy jest zwyciesca. Sprawdza w pionie od punktu ostatniego ruchu
    //pionowo
    private String checkVertical(){
        int amount = 0;
        String lastSymbol = getLastMoveFieldSymbol();
        Field checkingField = lastMoveField;

        //tu inkrementujemy Y
        for (int i =0; i<height; i++){
            checkingField.setFieldYCoordinate(i);

            if (getFieldSymbol(checkingField).equals(lastSymbol)){
                amount++;
            } else {
                amount =0;
            }

            if (amount == amountToVictory) {
                return getFieldSymbol(checkingField);
            }

        }
        return "";
    }

    //poziomo
    private String checkHorizontal(){
        int amount = 0;
        Field checkingField = lastMoveField;
        String lastSymbol = getLastMoveFieldSymbol();


        for (int i = 0; i<width; i++){
            checkingField.setFieldXCoordinate(i);
            if (getFieldSymbol(lastMoveField).equals(lastSymbol)){
                amount++;
            } else {
                amount =0;
            }

            if (amount == amountToVictory) {
                return getFieldSymbol(lastMoveField);
            }
        }
        return "";
    }

    private String checkSlants() {
        return "";
    }

    private String getLastMoveFieldSymbol(){
        return board.get(lastMoveField.getFieldYCoordinate()).get(lastMoveField.getFieldXCoordinate());
    }

    private void setFieldSymbol(Field field, String symbol) {
        board.get(field.getFieldYCoordinate()).set(field.getFieldXCoordinate(), symbol);
    }

    private String getFieldSymbol(Field field) {
        return board.get(field.getFieldYCoordinate()).get(field.getFieldXCoordinate());
    }

    private int getLastMoveFieldXCoordinate(){
        return lastMoveField.getFieldXCoordinate();
    }

    private int getLastMoveFieldYCoordinate(){
        return lastMoveField.getFieldYCoordinate();
    }

    private void setLastMoveFieldXCoordinate(int lastMoveXCoordinate){
        lastMoveField.setFieldXCoordinate(lastMoveXCoordinate);
    }

    private void setLastMoveFieldYCoordinate(int lastMoveYCoordinate){
        lastMoveField.setFieldYCoordinate(lastMoveYCoordinate);
    }

    public void showBoard() {

        for (int i = 0; i<height; i++){
            for (int j = 0; j<width; j++){
                System.out.print(board.get(i).get(j));
            }
            System.out.println("");
        }
    }

    public void help(){
        setFieldSymbol(new Field(4,0),"Z");
        setFieldSymbol(new Field(3,0),"Z");
        setFieldSymbol(new Field(2,0),"Z");

        setLastMoveFieldXCoordinate(2);
        setLastMoveFieldYCoordinate(0);

        System.out.println(checkHorizontal());
    }

}
