package com.mandy.samples;

/**
 * Represents a point on a compass
 *
 * @author Mandy Warren
 */
public enum Orientation {

    NORTH {
        public Orientation left() {
            return WEST;
        }

        public Orientation right() {
            return EAST;
        }
    },

    EAST {
        public Orientation left() {
            return NORTH;
        }

        public Orientation right() {
            return SOUTH;
        }
    },

    SOUTH {
        public Orientation left() {
            return EAST;
        }

        public Orientation right() {
            return WEST;
        }
    },

    WEST {
        public Orientation left() {
            return SOUTH;
        }

        public Orientation right() {
            return NORTH;
        }
    };

    abstract Orientation left();

    abstract Orientation right();

    /**
     * Determines the Orientation pointed to after a right or left turn.
     *
     * @param direction whether this is a right or left turn
     * @return the Orientation pointed to after a right or left turn.
     */
    public Orientation turn(Direction direction) {

        switch (direction) {
            case LEFT:
                return this.left();
            case RIGHT:
                return this.right();
            default:
                throw new IllegalArgumentException("Unexpected direction");
        }

    }

    @Override
    public String toString() {
        return (this.name());
    }
}
