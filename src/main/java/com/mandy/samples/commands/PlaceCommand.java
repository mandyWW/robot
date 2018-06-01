package com.mandy.samples.commands;

import com.mandy.samples.CompassDirection;
import com.mandy.samples.Location;
import com.mandy.samples.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST.
 * The origin (0,0) is considered to be the SOUTH WEST most corner.
 *
 * @author Mandy Warren
 */
public class PlaceCommand extends Command {

    private static final Logger logger = LoggerFactory.getLogger(PlaceCommand.class.getName());

    private Location location;

    /**
     * Constructs a new PlaceCommand for the robot, using default x and y coordinates and direction
     *
     * @param robot the robot being placed
     */
    PlaceCommand(Robot robot) {
    }

    /**
     * Constructs a new PlaceCommand for the robot, specifying the x and y coordinates and the direction
     * @param robot the robot being places
     * @param xCoord the x coordinate
     * @param yCoord the y coordinate
     * @param compassDirection the direction
     */
    PlaceCommand(Robot robot, int xCoord, int yCoord, CompassDirection compassDirection) {
        super(robot);
        location = new Location(xCoord, yCoord, compassDirection);
    }

    @Override
    public void execute() {
        logger.debug("executing a PLACE command");
        robot.place(location);
    }

    // TODO - override hashcode?

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof PlaceCommand)) {
            return false;
        } else {
            // we only care that a previous PlaceCommand has been executed,
            // we don't care about the coordinates/direction
            return true;
        }
    }
}
