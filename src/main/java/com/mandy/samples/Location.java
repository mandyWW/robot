package com.mandy.samples;

/**
 * Represents a position on a square tabletop.
 *
 * @author Mandy Warren
 */
public class Location {

    private int xCoord;
    private int yCoord;
    private CompassDirection compassDirection;

    /**
     * Constructs a new Location with the specified detail.
     *
     * @param xCoord the x coordinate
     * @param yCoord the y coordinate
     * @param compassDirection the compass direction
     */
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


}
