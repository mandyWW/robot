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

    private Location currentLocation;

    /**
     * Places/moved the robot in the specified location.
     *
     * @param newLocation the new location
     */
    public void place(Location newLocation) {
        currentLocation = newLocation;
    }

    public void rotate(Direction direction) {
        currentLocation = new Location(currentLocation.getXCoord(), currentLocation.getYCoord(), currentLocation.getCompassDirection().turn(direction));
    }


    public void report() {
        System.out.println("Output: " + currentLocation.toString());
    }


    public Location getCurrentLocation() {
        return currentLocation;
    }


}
