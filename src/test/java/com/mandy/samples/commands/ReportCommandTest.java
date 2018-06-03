package com.mandy.samples.commands;

import com.mandy.samples.CompassDirection;
import com.mandy.samples.Robot;
import com.mandy.samples.exceptions.CommandExecutionFailedException;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReportCommandTest {


    @Test
    public void execute_placePreviouslyIssued() throws CommandExecutionFailedException {
        // given
        PrintStream out = mock(PrintStream.class);
        System.setOut(out); // note this could impact other tests if run in parallel

        Robot robot = new Robot();

        PlaceCommand placeCommand = new PlaceCommand(robot, 1,0, CompassDirection.WEST);
        placeCommand.execute();

        // when
        ReportCommand reportCommand = new ReportCommand(robot);
        reportCommand.execute();

        // then
        verify(out).println("Output: 1,0,WEST");
    }

    @Test(expected = CommandExecutionFailedException.class)
    public void execute_placeNotPreviouslyIssued() throws CommandExecutionFailedException {
        // given
        Robot robot = new Robot();

        // when
        ReportCommand reportCommand = new ReportCommand(robot);
        reportCommand.execute();
    }

}
