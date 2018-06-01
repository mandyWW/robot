package com.mandy.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Receives commands from standard input
 *
 * @author Mandy Warren
 */
public final class CommandReader {
    private static final Logger logger = LoggerFactory.getLogger(CommandReader.class.getName());

    public static void read() {

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                logger.info("Enter a command or <h> for help: ");
                String input = scanner.nextLine();

                if ("q".equals(input)) {
                    logger.info("Exiting Toy Robot Simulator");
                    break;
                }
            }
        } finally {
            scanner.close();
        }
    }
}
