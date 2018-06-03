package com.mandy.samples.commands;

import com.mandy.samples.Direction;
import com.mandy.samples.Robot;
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
    public void make_rotateRightCommand() throws UnsupportedCommandException {
        // given
        Robot robot = new Robot();

        // when
        Command command = CommandFactory.make("RIGHT", robot);

        // then
        assertEquals(RotateCommand.class, command.getClass());
        assertEquals(Direction.RIGHT, ((RotateCommand)command).getDirection());

    }

    @Test(expected = UnsupportedCommandException.class)
    public void make_unsupportedCommand() throws UnsupportedCommandException {
        // given
        Robot robot = new Robot();

        // when
        CommandFactory.make("rubbish", robot);
    }
}
