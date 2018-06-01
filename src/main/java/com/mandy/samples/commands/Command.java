package com.mandy.samples.commands;


import com.mandy.samples.Robot;

/**
 * Represents an action that the robot must perform.
 *
 * @author Mandy Warren
 * @see <a href="https://sourcemaking.com/design_patterns/command">Command Design Pattern</a>
 */
public abstract class Command {

    Robot robot;

    Command() {
    }

    public Command(Robot robot) {
        this.robot = robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    /**
     * Executes the command.
     */
    public abstract void execute();
}
