package com.mandy.samples;

import com.mandy.samples.exceptions.InvalidStateException;
import com.mandy.samples.exceptions.OutOfBoundsException;

/**
 * Simulates a robot who receives commands to move across a board.
 *
 * @author Mandy Warren
 */
public class Robot {

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
            Orientation orientation = currentLocation.getOrientation();
            int currentYCoord = currentLocation.getYCoord();
            int currentXCoord = currentLocation.getXCoord();

            switch (orientation) {
                case NORTH:
                    if (Board.isValid(currentXCoord, currentYCoord + 1)) {
                        currentLocation = new Location(currentXCoord, currentYCoord + 1, currentLocation.getOrientation());
                    } else {
                        throw new OutOfBoundsException("robot cannot move any further NORTH");
                    }
                    break;
                case SOUTH:
                    if (Board.isValid(currentXCoord, currentYCoord - 1)) {
                        currentLocation = new Location(currentXCoord, currentYCoord - 1, currentLocation.getOrientation());
                    } else {
                        throw new OutOfBoundsException("robot cannot move any further SOUTH");
                    }
                    break;
                case EAST:
                    if (Board.isValid(currentXCoord + 1 , currentYCoord)) {
                        currentLocation = new Location(currentXCoord + 1, currentYCoord, currentLocation.getOrientation());
                    } else {
                        throw new OutOfBoundsException("robot cannot move any further EAST");

                    }
                    break;
                case WEST:
                    if (Board.isValid(currentXCoord - 1 , currentYCoord)) {
                        currentLocation = new Location(currentXCoord - 1, currentYCoord, currentLocation.getOrientation());
                    } else {
                        throw new OutOfBoundsException("robot cannot move any further WEST");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("unexpected orientation");
            }
        } else {
            throw new InvalidStateException("PLACE command must be issued before executing a MOVE command");
        }
    }

    /**
     * Turns the robot in the specified direction.
     *
     * @param direction the direction to turn
     * @throws InvalidStateException if the robot is not in the correct state
     */
    public void rotate(Direction direction) throws InvalidStateException {
        if (isPlaced) {
            currentLocation = new Location(currentLocation.getXCoord(), currentLocation.getYCoord(), currentLocation.getOrientation().turn(direction));
        } else {
            throw new InvalidStateException("PLACE command must be issued before executing a LEFT/RIGHT command");
        }
    }

    /**
     * Outputs the position of the robot
     *
     * @throws InvalidStateException if the robot is not in the correct state
     */
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
