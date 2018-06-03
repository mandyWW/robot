package com.mandy.samples.commands;

import com.mandy.samples.Location;
import com.mandy.samples.Orientation;
import com.mandy.samples.Robot;
import com.mandy.samples.exceptions.CommandExecutionFailedException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeftCommandTest {

    @Test
    public void execute_rotateLeftPlacePreviouslyIssued() throws CommandExecutionFailedException {
        // given
        Robot robot = new Robot();

        PlaceCommand placeCommand = new PlaceCommand(robot, 3,4, Orientation.SOUTH);
        placeCommand.execute();

        // when
        LeftCommand leftCommand = new LeftCommand(robot);
        leftCommand.execute();

        // then
        assertEquals(new Location(3, 4, Orientation.EAST), robot.getCurrentLocation());
    }

    @Test(expected = CommandExecutionFailedException.class)
    public void execute_placeNotPreviouslyIssued() throws CommandExecutionFailedException {
        // given
        Robot robot = new Robot();

        // when
        LeftCommand leftCommand = new LeftCommand(robot);
        leftCommand.execute();
    }

}
