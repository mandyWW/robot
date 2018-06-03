package com.mandy.samples.exceptions;

/**
 * Represents an unsupported command being received.
 *
 * @author Mandy Warren
 */
public class UnsupportedCommandException extends Exception {

    /**
     * Constructs a new instance with the specified detail.
     *
     * @param message the message
     */
    public UnsupportedCommandException(String message) {
        super(message);
    }

}
