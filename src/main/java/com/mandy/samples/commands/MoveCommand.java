package com.mandy.samples.commands;

import com.mandy.samples.CompassDirection;
import com.mandy.samples.Location;
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

    private static final int MAX_ROWS = 5;
    private static final int MAX_COLUMNS = 5;

    /**
     * Constructs a new MoveCommand.
     *
     * @param robot the robot being moved
     */
    MoveCommand(Robot robot) {
        super(robot);
    }

    @Override
    public void execute() {
        logger.debug("executing a MOVE command");

        Location currentLocation = robot.getCurrentLocation();

        CompassDirection compassDirection = currentLocation.getCompassDirection();

        int currentYCoord = currentLocation.getYCoord();
        int currentXCoord = currentLocation.getXCoord();

        switch (compassDirection) {
            case NORTH:
                if (currentYCoord + 1 < MAX_ROWS) {
                    robot.place(new Location(currentXCoord, currentYCoord + 1, currentLocation.getCompassDirection()));
                } else {
                    logger.error("robot cannot move any further NORTH");
                }
                break;
            case SOUTH:
                if (currentYCoord - 1 >= 0) {
                    robot.place(new Location(currentXCoord, currentYCoord - 1, currentLocation.getCompassDirection()));
                } else {
                    logger.error("robot cannot move any further SOUTH");
                }
                break;
            case EAST:
                if (currentXCoord + 1 < MAX_COLUMNS) {
                    robot.place(new Location(currentXCoord + 1, currentYCoord, currentLocation.getCompassDirection()));
                } else {
                    logger.error("robot cannot move any further EAST");

                }
                break;
            case WEST:
                if (currentXCoord - 1 >= 0) {
                    robot.place(new Location(currentXCoord - 1, currentYCoord, currentLocation.getCompassDirection()));
                } else {
                    logger.error("robot cannot move any further WEST");
                }
                break;
            default:
                logger.error("unexpected compass direction");
                break;
        }
    }

}
