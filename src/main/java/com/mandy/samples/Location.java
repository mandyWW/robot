package com.mandy.samples;

/**
 * Represents a position on a square tabletop.
 */
public class Location {

    private static final int rows = 5;
    private static final int columns = 5;

    private int xCoord, yCoord;
    private Direction direction;

    public Location(int xCoord, int yCoord, Direction direction) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return(xCoord +","+ yCoord + "," + direction);
    }

    /**
     * Outputs an ascii representation of the location on the tabletop
     */
//    public String toAscii() {
//
//    }

}
