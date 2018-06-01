package com.mandy.samples.commands;

import com.mandy.samples.CompassDirection;
import com.mandy.samples.Direction;
import com.mandy.samples.Robot;
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
    private static CommandHistory commandHistory = new CommandHistory();


    // TODO - whitespace before?
    // TODO - make 4 a const
    private static final Pattern VALID_INSTRUCTION = Pattern.compile("^(\\?|MOVE|LEFT|RIGHT|REPORT|PLACE ([0-4]),([0-4]),(NORTH|SOUTH|EAST|WEST))$");

    public static Command make(String input, Robot robot) throws UnsupportedOperationException {
        Command command = null;
        Matcher matcher = VALID_INSTRUCTION.matcher(input);

        // see if we have any matches..
        if (matcher.find()) {
            logger.debug("valid instruction received");

            String groupOne = matcher.group(0);
            if (groupOne.startsWith("PLACE")) {
                // parsing of String to int is safe due to the use of the regex..
                command = new PlaceCommand(robot, Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), CompassDirection.valueOf(matcher.group(4)));
            } else {
                switch (groupOne) {
                    case "REPORT":
                        // ensure a PLACE has been made previously..
                        if (commandHistory.exists(new PlaceCommand(robot))) {
                            command = new ReportCommand(robot);
                        } else {
                            throw new UnsupportedOperationException("Cannot REPORT until a PLACE command has been issued");
                        }
                        break;
                    case "LEFT":
                    case "RIGHT":
                        // ensure a PLACE has been made previously..
                        if (commandHistory.exists(new PlaceCommand(robot))) {
                            command = new RotateCommand(robot, Direction.valueOf(groupOne));
                        } else {
                            throw new UnsupportedOperationException("Cannot rotate LEFT/RIGHT until a PLACE command has been issued");
                        }
                        break;
                    case "MOVE":
                        // ensure a PLACE has been made previously..
                        if (commandHistory.exists(new PlaceCommand(robot))) {
                            command = new MoveCommand(robot);
                        } else {
                            throw new UnsupportedOperationException("Cannot MOVE until a PLACE command has been issued");
                        }
                        break;
                    case "?":
                        command = new HelpCommand();
                        break;
                    default:
                        // TODO
                        break;
                }
            }

            commandHistory.push(command);
        } else {
            // could have made my own exception hierarchy but this seemed to do the job nicely..
            throw new UnsupportedOperationException();
        }

        return command; // TODO - error handling
    }

    public CommandHistory getCommandHistory() {
        return commandHistory;
    }
}
