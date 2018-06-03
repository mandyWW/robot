package com.mandy.samples.commands;


import com.mandy.samples.Robot;
import com.mandy.samples.exceptions.CommandExecutionFailedException;

/**
 * Represents an action that the robot must perform.
 *
 * @author Mandy Warren
 */
public abstract class Command {

    final Robot robot;

    Command(Robot robot) {
        this.robot = robot;
    }

    /**
     * Executes the command.
     *
     * @throws CommandExecutionFailedException if command execution fails
     */
    public abstract void execute() throws CommandExecutionFailedException;
}
