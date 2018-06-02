package com.mandy.samples.exceptions;

/**
 * Indicates a move that will take the robot off the board.
 *
 * @author Mandy Warren
 */
public class OutOfBoundsException extends Exception {

    public OutOfBoundsException(String message) {
        super(message);
    }

}
