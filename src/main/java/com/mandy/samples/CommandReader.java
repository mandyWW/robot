package com.mandy.samples;

import com.mandy.samples.commands.CommandFactory;
import com.mandy.samples.commands.Command;

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
    private Robot robot = new Robot();


    static void read() {

        try (Scanner scanner = new Scanner(System.in)){
            while (true) {
                logger.info("Enter a valid command or <?> for help: ");
                String input = scanner.nextLine();

                if ("q".equals(input)) {
                    logger.info("Exiting Toy Robot Simulator");
                    break;
                }

                try {
                    Command command = CommandFactory.make(input);
                    command.execute();
                } catch (UnsupportedOperationException e) {
                    // we'll log this but let things carry on..
                    logger.error("Unsupported command encountered");
                }
            }
        }
    }
}
