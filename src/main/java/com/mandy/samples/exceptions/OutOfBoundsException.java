package com.mandy.samples.exceptions;

/**
 * Indicates a move that will take the robot off the board.
 *
 * @author Mandy Warren
 */
public class OutOfBoundsException extends Exception {

    /**
     * Constructs a new instance with the specified detail.
     *
     * @param message the message
     */
    public OutOfBoundsException(String message) {
        super(message);
    }

}
