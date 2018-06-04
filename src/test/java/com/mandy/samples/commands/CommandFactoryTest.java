package com.mandy.samples.commands;

import com.mandy.samples.Location;
import com.mandy.samples.Orientation;
import com.mandy.samples.Robot;
import com.mandy.samples.exceptions.CommandExecutionFailedException;
import com.mandy.samples.exceptions.UnsupportedCommandException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {

    @Test
    public void make_helpCommand() throws UnsupportedCommandException {
        // given
        Robot robot = new Robot();

        // when
        Command command = CommandFactory.make("?", robot);

        // then
        assertEquals(HelpCommand.class, command.getClass());
    }

    @Test
    public void make_moveCommand() throws UnsupportedCommandException {
        // given
        Robot robot = new Robot();

        // when
        Command command = CommandFactory.make("MOVE", robot);

        // then
        assertEquals(MoveCommand.class, command.getClass());
    }

    @Test
    public void make_placeCommand() throws UnsupportedCommandException {
        // given
        Robot robot = new Robot();

        // when
        Command command = CommandFactory.make("PLACE 1,1,EAST", robot);

        // then
        assertEquals(PlaceCommand.class, command.getClass());
    }

    @Test
    public void make_reportCommand() throws UnsupportedCommandException {
        // given
        Robot robot = new Robot();

        // when
        Command command = CommandFactory.make("REPORT", robot);

        // then
        assertEquals(ReportCommand.class, command.getClass());
    }

    @Test
    public void make_rightCommand() throws UnsupportedCommandException {
        // given
        Robot robot = new Robot();

        // when
        Command command = CommandFactory.make("RIGHT", robot);

        // then
        assertEquals(RightCommand.class, command.getClass());
    }

    @Test
    public void make_leftCommand() throws UnsupportedCommandException {
        // given
        Robot robot = new Robot();

        // when
        Command command = CommandFactory.make("LEFT", robot);

        // then
        assertEquals(LeftCommand.class, command.getClass());
    }

    @Test
    /**
     * Uses test data and expected results given in task overview
     */
    public void make_multiCommands1() throws UnsupportedCommandException, CommandExecutionFailedException {
        // given
        Robot robot = new Robot();

        // when
        Command command = CommandFactory.make("PLACE 0,0,NORTH", robot);
        command.execute();
        command = CommandFactory.make("MOVE", robot);
        command.execute();
        command = CommandFactory.make("REPORT", robot);
        command.execute();


        // then
        assertEquals(new Location(0,1, Orientation.NORTH), robot.getCurrentLocation());
    }

    @Test
    /**
     * Uses test data and expected results given in task overview
     */
    public void make_multiCommands2() throws UnsupportedCommandException, CommandExecutionFailedException {
        // given
        Robot robot = new Robot();

        // when
        Command command = CommandFactory.make("PLACE 0,0,NORTH", robot);
        command.execute();
        command = CommandFactory.make("LEFT", robot);
        command.execute();
        command = CommandFactory.make("REPORT", robot);
        command.execute();

        // then
        assertEquals(new Location(0,0, Orientation.WEST), robot.getCurrentLocation());
    }

    @Test
    /**
     * Uses test data and expected results given in task overview
     */
    public void make_multiCommands3() throws UnsupportedCommandException, CommandExecutionFailedException {
        // given
        Robot robot = new Robot();

        // when
        Command command = CommandFactory.make("PLACE 1,2,EAST", robot);
        command.execute();
        command = CommandFactory.make("MOVE", robot);
        command.execute();
        command = CommandFactory.make("MOVE", robot);
        command.execute();
        command = CommandFactory.make("LEFT", robot);
        command.execute();
        command = CommandFactory.make("MOVE", robot);
        command.execute();
        command = CommandFactory.make("REPORT", robot);
        command.execute();

        // then
        assertEquals(new Location(3,3, Orientation.NORTH), robot.getCurrentLocation());
    }

    @Test(expected = UnsupportedCommandException.class)
    public void make_unsupportedCommand() throws UnsupportedCommandException {
        // given
        Robot robot = new Robot();

        // when
        CommandFactory.make("rubbish", robot);
    }
}
