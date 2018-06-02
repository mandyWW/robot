package com.mandy.samples.commands;

import com.mandy.samples.CompassDirection;
import com.mandy.samples.Location;
import com.mandy.samples.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST.
 * The origin (0,0) is considered to be the SOUTH WEST most corner.
 *
 * @author Mandy Warren
 */
public class PlaceCommand extends Command {

    private static final Logger logger = LoggerFactory.getLogger(PlaceCommand.class.getName());

    private Location location = new Location(0,0,CompassDirection.NORTH);

    /**
     * Constructs a new PlaceCommand for the robot using the default location.
     *
     * @param robot the robot being placed
     */
    PlaceCommand(Robot robot) {
        super(robot);
    }

    /**
     * Constructs a new PlaceCommand for the robot, specifying the x and y coordinates and the direction to face.
     *
     * @param robot the robot being placed
     * @param xCoord the x coordinate
     * @param yCoord the y coordinate
     * @param compassDirection the direction to face
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof PlaceCommand)) {
            return false;
        } else {
            // a slight cheat here - we override the equals() method to
            // allow us to check the CommandHistory to see whether ANY previous
            // PlaceCommand has been executed, we don't care about the coordinates/direction
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
