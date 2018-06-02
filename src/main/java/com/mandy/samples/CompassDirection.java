package com.mandy.samples;

/**
 * Represents a point on a compass
 *
 * @author Mandy Warren
 */
public enum CompassDirection {

    NORTH {
        public CompassDirection anticlockwise() {
            return WEST;
        }

        public CompassDirection clockwise() {
            return EAST;
        }
    },

    EAST {
        public CompassDirection anticlockwise() {
            return NORTH;
        }

        public CompassDirection clockwise() {
            return SOUTH;
        }
    },

    SOUTH {
        public CompassDirection anticlockwise() {
            return EAST;
        }

        public CompassDirection clockwise() {
            return WEST;
        }
    },

    WEST {
        public CompassDirection anticlockwise() {
            return SOUTH;
        }

        public CompassDirection clockwise() {
            return NORTH;
        }
    };

    public abstract CompassDirection anticlockwise();

    public abstract CompassDirection clockwise();

    /**
     * Determins the CompassDirection pointed to after a clockwise or anticlockwise turn.
     *
     * @param direction whether this is a clockwise or anticlockwise turn
     * @return the CompassDirection pointed to after a clockwise or anticlockwise turn.
     */
    public CompassDirection turn(Direction direction) {

        switch (direction) {
            case LEFT:
                return this.anticlockwise();
            case RIGHT:
                return this.clockwise();
            default:
                throw new IllegalArgumentException("Unexpected direction");
        }

    }

    @Override
    public String toString() {
        return (this.name());
    }
}
