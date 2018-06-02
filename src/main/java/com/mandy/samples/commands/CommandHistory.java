package com.mandy.samples.commands;


import java.util.ArrayList;

/**
 * Holds the history of commands that have been executed.
 *
 * @author Mandy Warren
 */
class CommandHistory {
    private ArrayList<Command> history = new ArrayList<>(1);

    void push(Command c) {
        history.add(c);
    }

    boolean exists(Command command) {
        return (history.contains(command));
    }

}
