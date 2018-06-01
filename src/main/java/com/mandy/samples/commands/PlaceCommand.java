package com.mandy.samples.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST.
 * The origin (0,0) is considered to be the SOUTH WEST most corner.
 *
 * @author Mandy Warren
 */
public class PlaceCommand implements Command {

    private static final Logger logger = LoggerFactory.getLogger(PlaceCommand.class.getName());

    private int xCoord;
    private int yCoord;
    private String direction;

    /**
     * Constructs a new PlaceCommand specifying the x and y coordinates and the direction
     * @param xCoord the x coordinate
     * @param yCoord the y coordinate
     * @param direction the direction
     */
    public PlaceCommand(int xCoord, int yCoord, String direction) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.direction = direction;
    }

    @Override
    public void execute() {
        // TODO - robot.move(X,Y,F)
        logger.debug("executing a PLACE command");
    }
}
