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
    private ArrayList<Integer> lastMove;
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
        lastMove = new ArrayList<Integer>(2);
        lastMove.add(0);
        lastMove.add(0);
    }

    //funkcja sprawdzajaca czy jest zwyciesca. Sprawdza w pionie od punktu ostatniego ruchu
    //pionowo
    private String checkVertical(){
        int amount = 0;
        int lastMoveXCoordinate = getLastMoveXCoordinate();
        String lastSymbol = getLastMoveSymbol();


        for (int i =0; i<height; i++){
            if (getFieldSymbol(lastMoveXCoordinate, i).equals(lastSymbol)){
                amount++;
            } else {
                lastSymbol=getFieldSymbol(lastMoveXCoordinate, i);
                amount =0;
            }

            if (amount == amountToVictory) {
                return getFieldSymbol(lastMoveXCoordinate, i);
            }
        }
        return "";
    }

    //poziomo
    private String checkHorizontal(){
        int amount = 0;
        int lastMoveYCoordinate = getLastMoveYCoordinate();
        String lastSymbol = getLastMoveSymbol();


        for (int i = 0; i<width; i++){
            if (getFieldSymbol(i, lastMoveYCoordinate).equals(lastSymbol)){
                amount++;
            } else {
                amount =0;
            }

            if (amount == amountToVictory) {
                return getFieldSymbol(i, lastMoveYCoordinate);
            }
        }
        return "";
    }

    private String checkSlants() {
        return "";
    }

    private String getLastMoveSymbol(){
        return board.get(lastMove.get(1)).get(lastMove.get(0));
    }

    private void setFieldSymbol(int xCoordinate, int yCoordinate, String symbol) {
        board.get(yCoordinate).set(xCoordinate, symbol);
    }

    private String getFieldSymbol(int xCoordinate, int yCoordinate) {
        return board.get(yCoordinate).get(xCoordinate);
    }

    private int getLastMoveXCoordinate(){
        return lastMove.get(0);
    }

    private int getLastMoveYCoordinate(){
        return lastMove.get(1);
    }

    private void setLastMoveXCoordinate(int lastMoveXCoordinate){
        lastMove.set(0,lastMoveXCoordinate);
    }

    private void setLastMoveYCoordinate(int lastMoveYCoordinate){
        lastMove.set(1,lastMoveYCoordinate);
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
        setFieldSymbol(4,0,"Z");
        setFieldSymbol(3,0,"Z");
        setFieldSymbol(2,0,"Z");

        setLastMoveXCoordinate(2);
        setLastMoveYCoordinate(0);

        System.out.println(checkHorizontal());
    }

}
