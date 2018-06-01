package com.mandy.samples.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lists the set of valid commands
 *
 * @author Mandy Warren
 */
public class HelpCommand extends Command {

    private static final Logger logger = LoggerFactory.getLogger(CommandFactory.class.getName());

    @Override
    public void execute() {
        logger.info("\nValid commands:\n" +
                "PLACE X,Y,F\n" +
                "MOVE\n" +
                "LEFT\n" +
                "RIGHT\n" +
                "REPORT\n" +
                "<q> to exit");
    }
}
