package com.mandy.samples.commands;

import com.mandy.samples.Direction;
import com.mandy.samples.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LEFT or RIGHT will rotate the toy robot 90 degrees in the specified direction.
 *
 * @author Mandy Warren
 */
public class RotateCommand extends Command {

    private static final Logger logger = LoggerFactory.getLogger(RotateCommand.class.getName());

    private Direction direction;

    /**
     * Constructs a new RotateCommand for the robot, specifying the direction to rotate
     *
     * @param robot the robot being places
     */
    RotateCommand(Robot robot, Direction direction) {
        super(robot);
        this.direction = direction;
    }

    @Override
    public void execute() {
        logger.debug("executing a ROTATE command");
        robot.rotate(direction);
    }

}
