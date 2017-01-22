package XsAndOsGame.exceptions;// Created by Mateusz Płuciennik on 22.01.17.

public class FieldIsNotEmptyException extends Exception {
    public FieldIsNotEmptyException() {}

    //Constructor that accepts a message
    public FieldIsNotEmptyException(String message)
    {
        super(message);
    }
}
