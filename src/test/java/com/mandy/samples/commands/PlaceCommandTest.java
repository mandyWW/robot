package com.mandy.samples.commands;

import com.mandy.samples.Orientation;
import com.mandy.samples.Location;
import com.mandy.samples.Robot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaceCommandTest {

    @Test
    public void execute() {
        // given
        Robot robot = new Robot();
        PlaceCommand placeCommand = new PlaceCommand(robot, 1,0, Orientation.WEST);

        // when
        placeCommand.execute();

        // then
        assertEquals(new Location(1, 0, Orientation.WEST), robot.getCurrentLocation());
    }

}
