package com.mandy.samples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LocationTest {

    @Test
    public void equals() {
        // given/when
        Location location = new Location(1,1,Orientation.EAST);

        // then
        assertEquals(location, location);
    }

    @Test
    public void equals_differentTypes() {
        // given/when
        Location location = new Location(1,1,Orientation.EAST);

        // then
        assertNotEquals(location, 1);
    }

    @Test
    public void equals_differentCoords() {
        // given/when
        Location location1 = new Location(1,1,Orientation.EAST);
        Location location2 = new Location(2,1,Orientation.EAST);
        Location location3 = new Location(1,2,Orientation.EAST);
        Location location4 = new Location(1,1,Orientation.NORTH);

        // then
        assertNotEquals(location1, location2);
        assertNotEquals(location1, location3);
        assertNotEquals(location1, location4);
    }

    @Test
    public void hash() {
        // given/when
        Location location1 = new Location(1,1,Orientation.EAST);
        Location location2 = new Location(1,1,Orientation.EAST);

        // then
        assertEquals(location1.hashCode(), location2.hashCode());
    }

    @Test
    public void string() {
        // given/when
        Location location = new Location(1,1,Orientation.EAST);

        // then
        assertEquals("1,1,EAST", location.toString());
    }
}
