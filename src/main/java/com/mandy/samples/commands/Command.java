package com.mandy.samples.commands;


/**
 * Represents an action that the robot must perform.
 *
 * @author Mandy Warren
 * @see <a href="https://sourcemaking.com/design_patterns/command">Command Design Pattern</a>
 */
public interface Command {

    /**
     * Executes the command.
     */
    void execute();
}
