package com.mandy.samples.commands;

import com.mandy.samples.Robot;
import com.mandy.samples.exceptions.CommandExecutionFailedException;
import com.mandy.samples.exceptions.InvalidStateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Rotate the toy robot 90 degrees right.
 *
 * @author Mandy Warren
 */
public class RightCommand extends Command {

    private static final Logger logger = LoggerFactory.getLogger(RightCommand.class.getName());

    /**
     * Constructs a new RightCommand for the robot.
     *
     * @param robot the robot being placed.
     */
    RightCommand(Robot robot) {
        super(robot);
    }

    @Override
    public void execute() throws CommandExecutionFailedException {
        logger.debug("executing a RIGHT command");
        try {
            robot.right();
        } catch (InvalidStateException e) {
            throw new CommandExecutionFailedException("RIGHT command failed  - "+e.getMessage(), e);
        }
    }

}
