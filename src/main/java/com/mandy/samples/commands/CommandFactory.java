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
    // TODO - make 4 a const
    private static final Pattern VALID_INSTRUCTION = Pattern.compile("^(\\?|MOVE|LEFT|RIGHT|REPORT|PLACE ([0-4]),([0-4]),(NORTH|SOUTH|EAST|WEST))$");

    public static Command make(String input) {
        Command command = null;
        Matcher matcher = VALID_INSTRUCTION.matcher(input);

        // see if we have any matches..
        if (matcher.find()) {
            logger.debug("Valid instruction received");

            String groupOne = matcher.group(0);
            if (groupOne.startsWith("PLACE")) {
                // parsing of String to int is safe due to the use of the regex..
                command = new PlaceCommand(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)),matcher.group(4));
            } else {
                switch (groupOne) {
                    case "REPORT":
                        command = new ReportCommand();
                        break;
                    default:
                        // TODO
                        break;
                }
            }

        }

        return command; // TODO - error handling
    }
}
