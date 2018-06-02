package com.mandy.samples;

import com.mandy.samples.commands.Command;
import com.mandy.samples.commands.CommandFactory;
import com.mandy.samples.exceptions.InvalidStateException;
import com.mandy.samples.exceptions.UnsupportedCommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Receives commands from standard input
 *
 * @author Mandy Warren
 */
final class CommandReader {
    private static final Logger logger = LoggerFactory.getLogger(CommandReader.class.getName());

    private CommandReader() {

    }

    static void read() {
        Robot robot = new Robot();

        try (Scanner scanner = new Scanner(System.in)){
            while (true) {
                System.out.println("Enter a valid command or <?> for help: ");
                String input = scanner.nextLine();

                if ("q".equals(input)) {
                    System.out.println("Exiting Toy Robot Simulator");
                    break;
                }

                try {
                    Command command = CommandFactory.make(input, robot);
                    command.execute();
                } catch (UnsupportedCommandException|InvalidStateException e) {
                    // we'll log this but let things carry on..
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
