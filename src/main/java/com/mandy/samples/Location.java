package com.mandy.samples;

import java.util.Objects;

/**
 * Represents a position on a square tabletop.
 *
 * @author Mandy Warren
 */
public class Location {

    private final int xCoord;
    private final int yCoord;
    private final Orientation orientation;

    /**
     * Constructs a new Location with the specified detail.
     *
     * @param xCoord the x coordinate
     * @param yCoord the y coordinate
     * @param orientation the compass direction
     */
    public Location(int xCoord, int yCoord, Orientation orientation) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.orientation = orientation;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Location)) {
            return false;
        }
        Location location = (Location) o;
        return xCoord == location.xCoord && yCoord == location.yCoord &&
                Objects.equals(orientation, location.orientation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoord, yCoord, orientation);
    }

    @Override
    public String toString() {
        return(xCoord +","+ yCoord + "," + orientation);
    }


}
