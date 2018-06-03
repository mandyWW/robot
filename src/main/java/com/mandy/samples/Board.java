package com.mandy.samples;

import org.apache.commons.lang3.Range;

/**
 * Represents a square board on which the robot moves.
 *
 * @author Mandy Warren
 */
final class Board {

    private static final Range<Integer> XCOORD_RANGE = Range.between(0, 4);
    private static final Range<Integer> YCOORD_RANGE = Range.between(0, 4);

    /**
     * Returns true if the xCoord and yCoord are in the valid range.
     *
     * @param xCoord the xCoord
     * @param yCoord the yCoord
     * @return true if the xCoord and yCoord are in the valid range
     */
    static boolean isValid(int xCoord, int yCoord) {
        return XCOORD_RANGE.contains(xCoord) && YCOORD_RANGE.contains(yCoord);
    }

}
