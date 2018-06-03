package com.mandy.samples.commands;

import com.mandy.samples.Orientation;
import com.mandy.samples.Direction;
import com.mandy.samples.Location;
import com.mandy.samples.Robot;
import com.mandy.samples.exceptions.CommandExecutionFailedException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotateCommandTest {

    @Test
    public void execute_rotateLeftPlacePreviouslyIssued() throws CommandExecutionFailedException {
        // given
        Robot robot = new Robot();

        PlaceCommand placeCommand = new PlaceCommand(robot, 3,4, Orientation.SOUTH);
        placeCommand.execute();

        // when
        RotateCommand rotateCommand = new RotateCommand(robot, Direction.LEFT);
        rotateCommand.execute();

        // then
        assertEquals(new Location(3, 4, Orientation.EAST), robot.getCurrentLocation());
    }

    @Test
    public void execute_rotateRightPlacePreviouslyIssued() throws CommandExecutionFailedException {
        // given
        Robot robot = new Robot();

        PlaceCommand placeCommand = new PlaceCommand(robot, 0,3, Orientation.EAST);
        placeCommand.execute();

        // when
        RotateCommand rotateCommand = new RotateCommand(robot, Direction.RIGHT);
        rotateCommand.execute();

        // then
        assertEquals(new Location(0, 3, Orientation.SOUTH), robot.getCurrentLocation());
    }

    @Test(expected = CommandExecutionFailedException.class)
    public void execute_placeNotPreviouslyIssued() throws CommandExecutionFailedException {
        // given
        Robot robot = new Robot();

        // when
        RotateCommand rotateCommand = new RotateCommand(robot, Direction.LEFT);
        rotateCommand.execute();
    }

}
