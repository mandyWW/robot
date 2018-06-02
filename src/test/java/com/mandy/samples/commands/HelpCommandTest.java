package com.mandy.samples.commands;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HelpCommandTest {

    private HelpCommand helpCommand = new HelpCommand();

    @Test
    public void execute() throws Exception {
        // given
        PrintStream out = mock(PrintStream.class);
        System.setOut(out); // TODO - impact on other tests!

        // when
        helpCommand.execute();

        // then
        verify(out).println(
                "\nValid commands:\n" +
                "PLACE X,Y,F\n" +
                "MOVE\n" +
                "LEFT\n" +
                "RIGHT\n" +
                "REPORT\n" +
                "<q> to exit");
    }

}
