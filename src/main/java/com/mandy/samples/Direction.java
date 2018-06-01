package com.mandy.samples;

/**
 * Represents a point on a compass
 *
 * @author Mandy Warren
 */
public enum Direction {

    NORTH, EAST, SOUTH, WEST;

    @Override
    public String toString() {
        return(this.name());
    }
}
