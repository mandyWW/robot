package com.mandy.samples.commands;


import com.mandy.samples.Robot;

/**
 * Represents an action that the robot must perform.
 *
 * @author Mandy Warren
 */
public abstract class Command {

    Robot robot;

    Command(Robot robot) {
        this.robot = robot;
    }

    /**
     * Executes the command.
     */
    public abstract void execute();
}
