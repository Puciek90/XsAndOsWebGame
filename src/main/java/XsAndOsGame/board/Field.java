package XsAndOsGame.board;// Created by Mateusz Płuciennik on 17.01.17.

public class Field {
    private int fieldXCoordinate;
    private int fieldYCoordinate;

    public Field(int fieldXCoordinate, int fieldYCoordinate) {
        this.fieldXCoordinate = fieldXCoordinate;
        this.fieldYCoordinate = fieldYCoordinate;
    }

    public int getFieldXCoordinate() {
        return fieldXCoordinate;
    }

    public void setFieldXCoordinate(int fieldXCoordinate) {
        this.fieldXCoordinate = fieldXCoordinate;
    }

    public int getFieldYCoordinate() {
        return fieldYCoordinate;
    }

    public void setFieldYCoordinate(int fieldYCoordinate) {
        this.fieldYCoordinate = fieldYCoordinate;
    }
}
