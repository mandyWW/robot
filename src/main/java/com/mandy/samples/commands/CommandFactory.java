package com.mandy.samples.commands;

import com.mandy.samples.Orientation;
import com.mandy.samples.Robot;
import com.mandy.samples.exceptions.UnsupportedCommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creates commands from input.
 *
 * @author Mandy Warren
 */
public final class CommandFactory {

    private static final Logger logger = LoggerFactory.getLogger(CommandFactory.class.getName());

    private static final Pattern VALID_INSTRUCTION = Pattern.compile("^(\\?|MOVE|LEFT|RIGHT|REPORT|PLACE ([0-4]),([0-4]),(NORTH|SOUTH|EAST|WEST))$");

    private CommandFactory() {
    }

    /**
     * Constructs a command from user input.
     *
     * @param input user input
     * @param robot the robot to which the command will be issued
     * @return the command
     * @throws UnsupportedCommandException if an unrecognised input is received
     */
    public static Command make(String input, Robot robot) throws UnsupportedCommandException {
        Command command;
        Matcher matcher = VALID_INSTRUCTION.matcher(input);

        // see if we have any matches..
        if (matcher.find()) {
            logger.debug("valid instruction received");

            String groupOne = matcher.group(0);
            if (groupOne.startsWith("PLACE")) {
                // parsing of String to int is safe due to the use of the regex..
                command = new PlaceCommand(robot, Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Orientation.valueOf(matcher.group(4)));
            } else {
                switch (groupOne) {
                    case "REPORT":
                        command = new ReportCommand(robot);
                        break;
                    case "LEFT":
                        command = new LeftCommand(robot);
                        break;
                    case "RIGHT":
                        command = new RightCommand(robot);
                        break;
                    case "MOVE":
                        command = new MoveCommand(robot);
                        break;
                    case "?":
                        command = new HelpCommand();
                        break;
                    default:
                        throw new UnsupportedCommandException("unrecognised command");
                }
            }

        } else {
            throw new UnsupportedCommandException("invalid instruction received");
        }

        return command;
    }

}
