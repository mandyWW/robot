package com.mandy.samples;

import com.mandy.samples.exceptions.InvalidStateException;
import com.mandy.samples.exceptions.OutOfBoundsException;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RobotTest {

    @Test
    public void place() {
        //given
        Robot robot = new Robot();
        Location location = new Location(3,4, CompassDirection.EAST);

        //when
        robot.place(location);

        // then
        assertEquals(location, robot.getCurrentLocation());
        assertTrue(robot.isPlaced());
    }

    @Test
    public void rotate_left() throws InvalidStateException {
        //given
        Robot robot = new Robot();
        Location location = new Location(3,4, CompassDirection.EAST);
        robot.place(location);

        //when
        robot.rotate(Direction.LEFT);

        // then
        assertEquals(new Location(3, 4, CompassDirection.NORTH), robot.getCurrentLocation());
    }

    @Test
    public void rotate_right() throws InvalidStateException {
        //given
        Robot robot = new Robot();
        Location location = new Location(3,4, CompassDirection.EAST);
        robot.place(location);

        //when
        robot.rotate(Direction.RIGHT);

        // then
        assertEquals(new Location(3, 4, CompassDirection.SOUTH), robot.getCurrentLocation());
    }

    @Test(expected = InvalidStateException.class)
    public void rotate_noPreviousPlace() throws InvalidStateException {
        //given
        Robot robot = new Robot();

        //when
        robot.rotate(Direction.RIGHT);
    }

    @Test
    public void report() throws InvalidStateException {
        //given
        PrintStream out = mock(PrintStream.class);
        System.setOut(out); // note this could impact other tests if run in parallel

        Robot robot = new Robot();
        Location location = new Location(1,2, CompassDirection.WEST);
        robot.place(location);

        //when
        robot.report();

        // then
        verify(out).println("Output: 1,2,WEST");
    }

    @Test(expected = InvalidStateException.class)
    public void report_noPreviousPlace() throws InvalidStateException {
        //given
        Robot robot = new Robot();

        //when
        robot.report();
    }

    @Test
    public void move_south() throws InvalidStateException, OutOfBoundsException {
        //given
        Robot robot = new Robot();
        Location location = new Location(2,2, CompassDirection.SOUTH);
        robot.place(location);

        //when
        robot.move();

        // then
        assertEquals(new Location(2, 1, CompassDirection.SOUTH), robot.getCurrentLocation());
    }

    @Test(expected = OutOfBoundsException.class)
    public void move_outOfYbounds() throws InvalidStateException, OutOfBoundsException {
        //given
        Robot robot = new Robot();
        Location location = new Location(0,0, CompassDirection.SOUTH);
        robot.place(location);

        //when
        robot.move();
    }

    @Test(expected = OutOfBoundsException.class)
    public void move_outOfXbounds() throws InvalidStateException, OutOfBoundsException {
        //given
        Robot robot = new Robot();
        Location location = new Location(0,3, CompassDirection.WEST);
        robot.place(location);

        //when
        robot.move();
    }

    @Test(expected = InvalidStateException.class)
    public void move_noPreviousPlace() throws InvalidStateException, OutOfBoundsException {
        //given
        Robot robot = new Robot();

        //when
        robot.move();
    }
}