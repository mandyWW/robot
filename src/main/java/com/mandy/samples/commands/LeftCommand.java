package com.mandy.samples.commands;

import com.mandy.samples.Robot;
import com.mandy.samples.exceptions.CommandExecutionFailedException;
import com.mandy.samples.exceptions.InvalidStateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Rotate the toy robot 90 degrees left.
 *
 * @author Mandy Warren
 */
public class LeftCommand extends Command {

    private static final Logger logger = LoggerFactory.getLogger(LeftCommand.class.getName());

    /**
     * Constructs a new LeftCommand for the robot.
     *
     * @param robot the robot being placed
     */
    LeftCommand(Robot robot) {
        super(robot);
    }

    @Override
    public void execute() throws CommandExecutionFailedException {
        logger.debug("executing a LEFT command");
        try {
            robot.left();
        } catch (InvalidStateException e) {
            throw new CommandExecutionFailedException("LEFT command failed  - "+e.getMessage(), e);
        }
    }

}
