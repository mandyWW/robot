package com.mandy.samples;

import com.mandy.samples.commands.Command;
import com.mandy.samples.commands.CommandFactory;
import com.mandy.samples.exceptions.CommandExecutionFailedException;
import com.mandy.samples.exceptions.UnsupportedCommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Receives input from an input stream and turns it into commands.
 *
 * @author Mandy Warren
 */
final class InputReader {
    private static final Logger logger = LoggerFactory.getLogger(InputReader.class.getName());

    private InputReader() {
    }

    static void read(InputStream inputStream) {
        Robot robot = new Robot();

        try (Scanner scanner = new Scanner(inputStream)){
            while (true) {
                System.out.println("Enter a valid command or <?> for help: ");
                String input = scanner.nextLine();

                if ("q".equals(input)) {
                    logger.info("Exiting Toy Robot Simulator");
                    break;
                }

                try {
                    Command command = CommandFactory.make(input, robot);
                    command.execute();
                } catch (UnsupportedCommandException|CommandExecutionFailedException e) {
                    // we'll log this but let things carry on..
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
