package com.mandy.samples.commands;

import com.mandy.samples.CompassDirection;
import com.mandy.samples.Location;
import com.mandy.samples.Robot;
import com.mandy.samples.exceptions.CommandExecutionFailedException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveCommandTest {

    @Test
    public void execute_placePreviouslyIssuedBoundaryNotReached() throws CommandExecutionFailedException {
        // given
        Robot robot = new Robot();
        MoveCommand moveCommand = new MoveCommand(robot);
        robot.place(new Location(0, 0, CompassDirection.NORTH));

        // when
        moveCommand.execute();

        // then
        assertEquals(new Location(0,1, CompassDirection.NORTH), robot.getCurrentLocation());
    }

    @Test (expected = CommandExecutionFailedException.class)
    public void execute_placeNotPreviouslyIssued() throws CommandExecutionFailedException {
        // given
        Robot robot = new Robot();
        MoveCommand moveCommand = new MoveCommand(robot);

        // when
        moveCommand.execute();
    }

    @Test (expected = CommandExecutionFailedException.class)
    public void execute_placePreviouslyIssuedXBoundaryReached() throws CommandExecutionFailedException {
        // given
        Robot robot = new Robot();
        MoveCommand moveCommand = new MoveCommand(robot);
        robot.place(new Location(4, 0, CompassDirection.EAST));

        // when
        moveCommand.execute();
    }

    @Test (expected = CommandExecutionFailedException.class)
    public void execute_placePreviouslyIssuedYBoundaryReached() throws CommandExecutionFailedException {
        // given
        Robot robot = new Robot();
        MoveCommand moveCommand = new MoveCommand(robot);
        robot.place(new Location(0, 4, CompassDirection.NORTH));

        // when
        moveCommand.execute();
    }
}
