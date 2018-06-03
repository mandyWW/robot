package com.mandy.samples.commands;

import com.mandy.samples.Orientation;
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

    private final Location location;

    /**
     * Constructs a new PlaceCommand for the robot, specifying the x and y coordinates and the direction to face.
     *
     * @param robot the robot being placed
     * @param xCoord the x coordinate
     * @param yCoord the y coordinate
     * @param orientation the direction to face
     */
    PlaceCommand(Robot robot, int xCoord, int yCoord, Orientation orientation) {
        super(robot);
        location = new Location(xCoord, yCoord, orientation);
    }

    @Override
    public void execute() {
        logger.debug("executing a PLACE command");
        robot.place(location);
    }

}
