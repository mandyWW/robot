package com.mandy.samples.exceptions;

/**
 * Represents an unsupported command being received.
 *
 * @author Mandy Warren
 */
public class UnsupportedCommandException extends Exception {

    public UnsupportedCommandException(String message) {
        super(message);
    }

}
