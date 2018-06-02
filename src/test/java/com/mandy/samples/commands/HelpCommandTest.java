package com.mandy.samples.commands;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({LoggerFactory.class})
public class HelpCommandTest {

    @Test
    public void execute() throws Exception {
        // given
        Logger mockLogger = mock(Logger.class);
        PowerMockito.mockStatic(LoggerFactory.class);
        when(LoggerFactory.getLogger(HelpCommand.class.getName())).
                thenReturn(mockLogger);
        HelpCommand helpCommand = new HelpCommand();

        // when
        helpCommand.execute();

        // then
        verify(mockLogger).info(
                "\nValid commands:\n" +
                        "PLACE X,Y,F\n" +
                        "MOVE\n" +
                        "LEFT\n" +
                        "RIGHT\n" +
                        "REPORT\n" +
                        "<q> to exit");
    }

}
