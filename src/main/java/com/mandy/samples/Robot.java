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

    public void move(Location newLocation) {
        currentLocation = newLocation;
    }

    public void rotate() {
        // TODO
    }

    public void setLocation() {
        // TODO
    }

    public Location getLocation() {
        return currentLocation;
    }


}
