package com.mandy.samples.commands;

import com.mandy.samples.CompassDirection;
import com.mandy.samples.Location;
import com.mandy.samples.Robot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaceCommandTest {

    private Robot robot = new Robot();

    @Test
    public void execute() {
        // given
        PlaceCommand placeCommand = new PlaceCommand(robot, 1,0, CompassDirection.WEST);

        // when
        placeCommand.execute();

        // then
        assertEquals(new Location(1, 0, CompassDirection.WEST), robot.getCurrentLocation());
    }

}
