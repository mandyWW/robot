package com.mandy.samples.commands;

import java.util.Stack;

/**
 * Holds the history of commands that have been executed.
 *
 * @author Mandy Warren
 */
public class CommandHistory {
    private Stack history = new Stack();

    public void push(Command c) {
        history.push(c);
    }

    public Command pop() {
        return (Command) history.pop();
    }

    public boolean exists(Command command) {
        return (history.contains(command));
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
