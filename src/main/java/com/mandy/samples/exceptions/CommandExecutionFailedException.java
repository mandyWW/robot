package com.mandy.samples.exceptions;

/**
 * Indicates a command failed to execute.
 *
 * @author Mandy Warren
 */
public class CommandExecutionFailedException extends Exception {

    /**
     * Constructs a new instance with the specified detail.
     *
     * @param message the message
     * @param e the exception
     */
    public CommandExecutionFailedException(String message, Exception e) {
        super(message, e);
    }
}
