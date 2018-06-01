package com.mandy.samples.commands;

import com.mandy.samples.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MOVE will move the toy robot one unit forward in the direction it is currently facing.
 *
 * @author Mandy Warren
 */
public class MoveCommand extends Command {

    private static final Logger logger = LoggerFactory.getLogger(MoveCommand.class.getName());

    /**
     * Constructs a new MoveCommand for the robot.
     *
     * @param robot the robot being moved
     */
    MoveCommand(Robot robot) {
        super(robot);
    }

    @Override
    public void execute() {
        logger.debug("executing a MOVE command");
            robot.move();
    }

}
