package com.mandy.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Starting point for the Robot application.
 *
 * @author Mandy Warren
 * @see <a href="https://github.com/mandyWW/robot">Robot application documentation</a>
 */
public class RobotMain {

    private static final Logger logger = LoggerFactory.getLogger(RobotMain.class.getName());

    public static void main(String[] args) {
        logger.info("\n" +
                        "  _______            _____       _           _      _____ _                 _       _             \n" +
                        " |__   __|          |  __ \\     | |         | |    / ____(_)               | |     | |            \n" +
                        "    | | ___  _   _  | |__) |___ | |__   ___ | |_  | (___  _ _ __ ___  _   _| | __ _| |_ ___  _ __ \n" +
                        "    | |/ _ \\| | | | |  _  // _ \\| '_ \\ / _ \\| __|  \\___ \\| | '_ ` _ \\| | | | |/ _` | __/ _ \\| '__|\n" +
                        "    | | (_) | |_| | | | \\ \\ (_) | |_) | (_) | |_   ____) | | | | | | | |_| | | (_| | || (_) | |   \n" +
                        "    |_|\\___/ \\__, | |_|  \\_\\___/|_.__/ \\___/ \\__| |_____/|_|_| |_| |_|\\__,_|_|\\__,_|\\__\\___/|_|   \n" +
                        "              __/ |                                                                               \n" +
                        "             |___/   ");
        logger.info("Welcome to the Toy Robot Simulator!");

        CommandReader.read();

    }
}
