package com.mandy.samples.commands;


import java.util.ArrayList;

/**
 * Holds the history of commands that have been executed.
 *
 * @author Mandy Warren
 */
class CommandHistory {
    private ArrayList<Command> history = new ArrayList<>(1);

    /**
     * Add a command to the history
     * @param command the command
     */
    void push(Command command) {
        history.add(command);
    }

    /**
     * Check whether a specific command type has been executed i.e. exists in the command history
     * @param command the command
     * @return true if the specific command type has been executed, false otherwise
     */
    boolean exists(Command command) {
        return (history.contains(command));
    }

}
