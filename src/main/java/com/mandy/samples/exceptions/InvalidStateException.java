package com.mandy.samples.exceptions;

/**
 * Indicates a command cannot be executed as a required precondition has not been met.
 *
 * @author Mandy Warren
 */
public class InvalidStateException extends Exception {

    public InvalidStateException(String message) {
        super(message);
    }

}
