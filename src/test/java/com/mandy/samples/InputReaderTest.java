package com.mandy.samples;

import com.mandy.samples.commands.CommandFactory;
import com.mandy.samples.commands.PlaceCommand;
import com.mandy.samples.exceptions.UnsupportedCommandException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Scanner;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({InputReader.class, Scanner.class, CommandFactory.class, PlaceCommand.class, UnsupportedCommandException.class})
public class InputReaderTest {

    @Test
    public void read_validInput() throws Exception {
        // given
        Robot mockedRobot = mock(Robot.class);
        Scanner mockedScanner = PowerMockito.mock(Scanner.class);
        PlaceCommand mockedPlaceCommand = mock(PlaceCommand.class);

        PowerMockito.spy(PlaceCommand.class);

        PowerMockito.whenNew(Robot.class).withNoArguments().thenReturn(mockedRobot);
        PowerMockito.whenNew(PlaceCommand.class).withArguments(mockedRobot, 1, 1, Orientation.NORTH).thenReturn(mockedPlaceCommand);
        PowerMockito.whenNew(Scanner.class).withArguments(System.in).thenReturn(mockedScanner);
        when(mockedScanner.nextLine()).thenReturn("PLACE 1,1,NORTH").thenReturn("q");

        // when
        InputReader.read(System.in);

        // then
        PowerMockito.verifyNew(PlaceCommand.class).withArguments(mockedRobot, 1, 1, Orientation.NORTH);
        verify(mockedPlaceCommand).execute();
    }

    @Test
    public void read_invalidInput() throws Exception {
        // given
        Robot mockedRobot = mock(Robot.class);
        Scanner mockedScanner = PowerMockito.mock(Scanner.class);
        UnsupportedCommandException mockedException = mock(UnsupportedCommandException.class);

        PowerMockito.spy(UnsupportedCommandException.class);

        PowerMockito.whenNew(Robot.class).withNoArguments().thenReturn(mockedRobot);
        PowerMockito.whenNew(UnsupportedCommandException.class).withArguments(anyString()).thenReturn(mockedException);
        PowerMockito.whenNew(Scanner.class).withArguments(System.in).thenReturn(mockedScanner);
        when(mockedScanner.nextLine()).thenReturn("rubbish").thenReturn("q");

        // when
        InputReader.read(System.in);

        // then
        PowerMockito.verifyNew(UnsupportedCommandException.class).withArguments("invalid instruction received");

    }
}
