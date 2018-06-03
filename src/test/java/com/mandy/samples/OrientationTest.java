package com.mandy.samples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrientationTest {

    @Test
    public void left() {
        // given/when/then
        assertEquals(Orientation.WEST, Orientation.NORTH.left());
        assertEquals(Orientation.EAST, Orientation.SOUTH.left());
        assertEquals(Orientation.NORTH, Orientation.EAST.left());
        assertEquals(Orientation.SOUTH, Orientation.WEST.left());
    }

    @Test
    public void right() {
        // given/when/then
        assertEquals(Orientation.EAST, Orientation.NORTH.right());
        assertEquals(Orientation.WEST, Orientation.SOUTH.right());
        assertEquals(Orientation.SOUTH, Orientation.EAST.right());
        assertEquals(Orientation.NORTH, Orientation.WEST.right());
    }
}
