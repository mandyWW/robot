package com.mandy.samples;

/**
 * Represents a position on a square tabletop.
 */
public class Location {

    private int xCoord;
    private int yCoord;
    private CompassDirection compassDirection;

    public Location(int xCoord, int yCoord, CompassDirection compassDirection) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.compassDirection = compassDirection;
    }

    int getXCoord() {
        return xCoord;
    }

    int getYCoord() {
        return yCoord;
    }

    CompassDirection getCompassDirection() {
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
