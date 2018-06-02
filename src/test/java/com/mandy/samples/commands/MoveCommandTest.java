package com.mandy.samples.commands;

import com.mandy.samples.Robot;
import org.junit.Test;

public class MoveCommandTest {

    private Robot robot = new Robot();

    private MoveCommand moveCommand = new MoveCommand(robot);

    @Test
    public void execute() throws Exception {
        // given

        // when
        moveCommand.execute();

        // then

    }

}
