package com.mandy.samples.exceptions;

/**
 * Indicates a command failed to execute.
 *
 * @author Mandy Warren
 */
public class CommandExecutionFailedException extends Exception {

    public CommandExecutionFailedException(String message) {
        super(message);
    }

    public CommandExecutionFailedException(String message, Exception e) {
        super(message, e);
    }
}
