package com.mandy.samples;

import com.mandy.samples.exceptions.InvalidStateException;
import com.mandy.samples.exceptions.OutOfBoundsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simulates a robot who receives commands to move across a board.
 *
 * @author Mandy Warren
 */
public class Robot {

    private static final Logger logger = LoggerFactory.getLogger(Robot.class.getName());

    private static final int MAX_ROWS = 5;
    private static final int MAX_COLUMNS = 5;

    private Location currentLocation;
    private boolean isPlaced = false;

    /**
     * Places/moved the robot in the specified location.
     *
     * @param newLocation the new location
     */
    public void place(Location newLocation) {
        currentLocation = newLocation;
        isPlaced = true;
    }

    /**
     * Moves the robot one unit forward in the direction it is currently facing.
     *
     * @throws InvalidStateException if the robot is not in the correct state
     * @throws OutOfBoundsException if the move will take the robot off the board
     */
    public void move() throws InvalidStateException, OutOfBoundsException {
        if (isPlaced) {
            CompassDirection compassDirection = currentLocation.getCompassDirection();
            int currentYCoord = currentLocation.getYCoord();
            int currentXCoord = currentLocation.getXCoord();

            switch (compassDirection) {
                case NORTH:
                    if (currentYCoord + 1 < MAX_ROWS) {
                        currentLocation = new Location(currentXCoord, currentYCoord + 1, currentLocation.getCompassDirection());
                    } else {
                        throw new OutOfBoundsException("robot cannot move any further NORTH");
                    }
                    break;
                case SOUTH:
                    if (currentYCoord - 1 >= 0) {
                        currentLocation = new Location(currentXCoord, currentYCoord - 1, currentLocation.getCompassDirection());
                    } else {
                        throw new OutOfBoundsException("robot cannot move any further SOUTH");
                    }
                    break;
                case EAST:
                    if (currentXCoord + 1 < MAX_COLUMNS) {
                        currentLocation = new Location(currentXCoord + 1, currentYCoord, currentLocation.getCompassDirection());
                    } else {
                        throw new OutOfBoundsException("robot cannot move any further EAST");

                    }
                    break;
                case WEST:
                    if (currentXCoord - 1 >= 0) {
                        currentLocation = new Location(currentXCoord - 1, currentYCoord, currentLocation.getCompassDirection());
                    } else {
                        throw new OutOfBoundsException("robot cannot move any further WEST");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("unexpected compass direction");
            }
        } else {
            throw new InvalidStateException("PLACE command must be issued before executing a MOVE command");
        }
    }

    public void rotate(Direction direction) throws InvalidStateException {
        if (isPlaced) {
            currentLocation = new Location(currentLocation.getXCoord(), currentLocation.getYCoord(), currentLocation.getCompassDirection().turn(direction));
        } else {
            throw new InvalidStateException("PLACE command must be issued before executing a LEFT/RIGHT command");
        }
    }

    public void report() throws InvalidStateException {
        if (isPlaced) {
            System.out.println("Output: " + currentLocation.toString());
        } else {
            throw new InvalidStateException("PLACE command must be issued before executing a REPORT command");
        }
    }


    public Location getCurrentLocation() {
        return currentLocation;
    }

    public boolean isPlaced() {
        return isPlaced;
    }
}
