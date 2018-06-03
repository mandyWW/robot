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
        Location location = new Location(3,4, Orientation.EAST);

        //when
        robot.place(location);

        // then
        assertEquals(location, robot.getCurrentLocation());
        assertTrue(robot.isPlaced());
    }

    @Test
    public void left() throws InvalidStateException {
        //given
        Robot robot = new Robot();
        Location location = new Location(3,4, Orientation.EAST);
        robot.place(location);

        //when
        robot.left();

        // then
        assertEquals(new Location(3, 4, Orientation.NORTH), robot.getCurrentLocation());
    }

    @Test
    public void right() throws InvalidStateException {
        //given
        Robot robot = new Robot();
        Location location = new Location(3,4, Orientation.EAST);
        robot.place(location);

        //when
        robot.right();

        // then
        assertEquals(new Location(3, 4, Orientation.SOUTH), robot.getCurrentLocation());
    }

    @Test(expected = InvalidStateException.class)
    public void left_noPreviousPlace() throws InvalidStateException {
        //given
        Robot robot = new Robot();

        //when
        robot.left();
    }

    @Test(expected = InvalidStateException.class)
    public void right_noPreviousPlace() throws InvalidStateException {
        //given
        Robot robot = new Robot();

        //when
        robot.right();
    }

    @Test
    public void report() throws InvalidStateException {
        //given
        PrintStream out = mock(PrintStream.class);
        System.setOut(out); // note this could impact other tests if run in parallel

        Robot robot = new Robot();
        Location location = new Location(1,2, Orientation.WEST);
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
        Location location = new Location(2,2, Orientation.SOUTH);
        robot.place(location);

        //when
        robot.move();

        // then
        assertEquals(new Location(2, 1, Orientation.SOUTH), robot.getCurrentLocation());
    }

    @Test(expected = OutOfBoundsException.class)
    public void move_southOutOfRange() throws InvalidStateException, OutOfBoundsException {
        //given
        Robot robot = new Robot();
        Location location = new Location(1,0, Orientation.SOUTH);
        robot.place(location);

        //when
        robot.move();
    }

    @Test
    public void move_north() throws InvalidStateException, OutOfBoundsException {
        //given
        Robot robot = new Robot();
        Location location = new Location(2,2, Orientation.NORTH);
        robot.place(location);

        //when
        robot.move();

        // then
        assertEquals(new Location(2, 3, Orientation.NORTH), robot.getCurrentLocation());
    }

    @Test(expected = OutOfBoundsException.class)
    public void move_northOutOfRange() throws InvalidStateException, OutOfBoundsException {
        //given
        Robot robot = new Robot();
        Location location = new Location(2,4, Orientation.NORTH);
        robot.place(location);

        //when
        robot.move();
    }

    @Test
    public void move_east() throws InvalidStateException, OutOfBoundsException {
        //given
        Robot robot = new Robot();
        Location location = new Location(2,2, Orientation.EAST);
        robot.place(location);

        //when
        robot.move();

        // then
        assertEquals(new Location(3, 2, Orientation.EAST), robot.getCurrentLocation());
    }

    @Test(expected = OutOfBoundsException.class)
    public void move_eastOutOfRange() throws InvalidStateException, OutOfBoundsException {
        //given
        Robot robot = new Robot();
        Location location = new Location(4,4, Orientation.EAST);
        robot.place(location);

        //when
        robot.move();
    }

    @Test
    public void move_west() throws InvalidStateException, OutOfBoundsException {
        //given
        Robot robot = new Robot();
        Location location = new Location(2,2, Orientation.WEST);
        robot.place(location);

        //when
        robot.move();

        // then
        assertEquals(new Location(1, 2, Orientation.WEST), robot.getCurrentLocation());
    }

    @Test(expected = OutOfBoundsException.class)
    public void move_westOutOfRange() throws InvalidStateException, OutOfBoundsException {
        //given
        Robot robot = new Robot();
        Location location = new Location(0,4, Orientation.WEST);
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

    @Test(expected = OutOfBoundsException.class)
    public void move_alreadyOutOfRange() throws InvalidStateException, OutOfBoundsException {
        //given
        Robot robot = new Robot();
        Location location = new Location(5,5, Orientation.WEST);
        robot.place(location);

        //when
        robot.move();
    }
}