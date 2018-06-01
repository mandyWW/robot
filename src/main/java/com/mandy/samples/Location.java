package com.mandy.samples;

/**
 * Represents a position on a square tabletop.
 */
public class Location {

    private static final int rows = 5;
    private static final int columns = 5;

    private int xCoord, yCoord;
    private CompassDirection compassDirection;

    public Location(int xCoord, int yCoord, CompassDirection compassDirection) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.compassDirection = compassDirection;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public CompassDirection getCompassDirection() {
        return compassDirection;
    }

    @Override
    public String toString() {
        return(xCoord +","+ yCoord + "," + compassDirection);
    }


    /**
     * Outputs an ascii representation of the location on the tabletop
     */
//    public String toAscii() {
//
//    }

}
