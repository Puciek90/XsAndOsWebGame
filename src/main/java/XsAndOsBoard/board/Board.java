package XsAndOsBoard.board;// Created by Mateusz Płuciennik on 15.01.17.

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<String>> board;
    private Field lastMoveField;
    private int height;
    private int width;

    public Board(int height, int width) {
        board = new ArrayList<ArrayList<String>>();
        this.height = height;
        this.width = width;
        initBoard();
    }

    private void initBoard() {
        for (int j = 0; j < height; j++) {
            ArrayList<String> column = new ArrayList<String>(width);
            for (int i = 0; i < width; i++) {
                column.add("0");
            }
            board.add(column);
        }
        lastMoveField = new Field(0,0);
    }
    
    public ArrayList<ArrayList<String>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<String>> board) {
        this.board = board;
    }

    public Field getLastMoveField() {
        return this.lastMoveField;
    }

    public void setLastMoveField(Field lastMoveField) {
        this.lastMoveField = lastMoveField;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    public String getLastMoveFieldSymbol(){
        return board.get(lastMoveField.getFieldYCoordinate()).get(lastMoveField.getFieldXCoordinate());
    }

    public void setLastMoveFieldSymbol(String symbol){
         board.get(lastMoveField.getFieldYCoordinate()).set(lastMoveField.getFieldXCoordinate(), symbol);
    }

    public int getLastMoveFieldXCoordinate(){
        return lastMoveField.getFieldXCoordinate();
    }

    public int getLastMoveFieldYCoordinate(){
        return lastMoveField.getFieldYCoordinate();
    }

    public void setFieldSymbol(Field field, String symbol) {
        board.get(field.getFieldYCoordinate()).set(field.getFieldXCoordinate(), symbol);
    }

    public String getFieldSymbol(Field field) {
        return board.get(field.getFieldYCoordinate()).get(field.getFieldXCoordinate());
    }

    public void setLastMoveFieldXCoordinate(int lastMoveXCoordinate){
        lastMoveField.setFieldXCoordinate(lastMoveXCoordinate);
    }

    public void setLastMoveFieldYCoordinate(int lastMoveYCoordinate){
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



}
