package com.mandy.samples;

/**
 * Represents a point on a compass
 *
 * @author Mandy Warren
 */
public enum CompassDirection {

    NORTH, EAST, SOUTH, WEST;

    public CompassDirection turn(Direction direction) {

        CompassDirection newCompassDirection = null;

        switch (direction) {
            case LEFT:
                if (CompassDirection.NORTH.equals(this)) {
                    newCompassDirection = CompassDirection.WEST;
                }
                if (CompassDirection.EAST.equals(this)) {
                    newCompassDirection = CompassDirection.NORTH;
                }
                if (CompassDirection.SOUTH.equals(this)) {
                    newCompassDirection = CompassDirection.EAST;
                }
                if (CompassDirection.WEST.equals(this)) {
                    newCompassDirection = CompassDirection.SOUTH;
                }
                break;
            case RIGHT:
                if (CompassDirection.NORTH.equals(this)) {
                    newCompassDirection = CompassDirection.EAST;
                }
                if (CompassDirection.EAST.equals(this)) {
                    newCompassDirection = CompassDirection.SOUTH;
                }
                if (CompassDirection.SOUTH.equals(this)) {
                    newCompassDirection = CompassDirection.WEST;
                }
                if (CompassDirection.WEST.equals(this)) {
                    newCompassDirection = CompassDirection.NORTH;
                }
                break;
            default:
                throw new IllegalArgumentException("Unexpected direction");
        }

        return newCompassDirection;
    }

    @Override
    public String toString() {
        return(this.name());
    }
}
