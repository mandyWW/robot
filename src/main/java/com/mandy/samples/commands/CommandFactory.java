package com.mandy.samples.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creates commands from input.
 *
 * @author Mandy Warren
 */
public class CommandFactory {

    private static final Logger logger = LoggerFactory.getLogger(CommandFactory.class.getName());

    // TODO - whitespace before?
    private static final Pattern VALID_INSTRUCTION = Pattern.compile("^(\\?|MOVE|LEFT|RIGHT|REPORT|PLACE ([0-4]),([0-4]),(NORTH|SOUTH|EAST|WEST))$");

    public static Command make(String input) {
        Matcher matcher = VALID_INSTRUCTION.matcher(input);
        // see if we have any matches..
        while (matcher.find()) {
            logger.debug("Start index: " + matcher.start());
            logger.debug(" End index: " + matcher.end() + " ");
            logger.debug(matcher.group());
        }

        return null; // TODO
    }
}
