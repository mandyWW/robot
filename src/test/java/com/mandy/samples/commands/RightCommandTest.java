package com.mandy.samples.commands;

import com.mandy.samples.Location;
import com.mandy.samples.Orientation;
import com.mandy.samples.Robot;
import com.mandy.samples.exceptions.CommandExecutionFailedException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RightCommandTest {

    @Test
    public void execute_rotateRightPlacePreviouslyIssued() throws CommandExecutionFailedException {
        // given
        Robot robot = new Robot();

        PlaceCommand placeCommand = new PlaceCommand(robot, 0,3, Orientation.EAST);
        placeCommand.execute();

        // when
        RightCommand rightCommand = new RightCommand(robot);
        rightCommand.execute();

        // then
        assertEquals(new Location(0, 3, Orientation.SOUTH), robot.getCurrentLocation());
    }

    @Test(expected = CommandExecutionFailedException.class)
    public void execute_placeNotPreviouslyIssued() throws CommandExecutionFailedException {
        // given
        Robot robot = new Robot();

        // when
        RightCommand rightCommand = new RightCommand(robot);
        rightCommand.execute();
    }

}
