package com.mandy.samples.commands;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HelpCommandTest {

    @Test
    public void execute() {
        // given
        PrintStream out = mock(PrintStream.class);
        System.setOut(out); // note this could impact other tests if run in parallel

        HelpCommand helpCommand = new HelpCommand();

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
