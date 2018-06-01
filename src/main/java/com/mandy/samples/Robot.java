package com.mandy.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simulates a robot who receives commands to move across a board.
 *
 * @author Mandy Warren
 */
public class Robot {

    private static final Logger logger = LoggerFactory.getLogger(Robot.class.getName());

    Location currentLocation;

    public void place(Location newLocation) {
        currentLocation = newLocation;
    }

    public void move() {
        // TODO - move rules elsewhere into command?
        CompassDirection compassDirection = currentLocation.getCompassDirection();

        int currentYCoord = currentLocation.getYCoord();
        int currentXCoord = currentLocation.getXCoord();

        switch (compassDirection) {
            case NORTH:
                // TODO
                if (currentYCoord + 1 < 5) {
                    currentLocation = new Location(currentXCoord, currentYCoord + 1, currentLocation.getCompassDirection());
                } else {
                    // TODO
                    throw new IllegalArgumentException("Robot cannot move out of range");
                }
                break;
            case SOUTH:
                // TODO
                if (currentYCoord - 1 < 0) {
                    currentLocation = new Location(currentXCoord, currentYCoord - 1, currentLocation.getCompassDirection());
                } else {
                    // TODO
                    throw new IllegalArgumentException("Robot cannot move out of range");
                }
                break;
            case EAST:
                // TODO
                if (currentXCoord + 1 < 5) {
                    currentLocation = new Location(currentXCoord + 1, currentYCoord, currentLocation.getCompassDirection());
                } else {
                    // TODO
                    throw new IllegalArgumentException("Robot cannot move out of range");
                }
                break;
            case WEST:
                // TODO
                if (currentXCoord - 1 < 0) {
                    currentLocation = new Location(currentXCoord - 1, currentYCoord, currentLocation.getCompassDirection());
                } else {
                    // TODO
                    throw new IllegalArgumentException("Robot cannot move out of range");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid compass direction");
        }
    }

    public void rotate(Direction direction) {
        currentLocation = new Location(currentLocation.getXCoord(), currentLocation.getYCoord(), currentLocation.getCompassDirection().turn(direction));
    }

    public void setLocation() {
        // TODO
    }

    public Location getLocation() {
        return currentLocation;
    }


}
