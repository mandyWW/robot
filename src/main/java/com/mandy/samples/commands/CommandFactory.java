package com.mandy.samples.commands;

import com.mandy.samples.CompassDirection;
import com.mandy.samples.Direction;
import com.mandy.samples.Robot;
import com.mandy.samples.exceptions.InvalidStateException;
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

    private static CommandHistory commandHistory = new CommandHistory();

    /**
     * Constructs a command from user input.
     *
     * @param input user input
     * @param robot the robot to which the command will be issued
     * @return the command
     * @throws InvalidStateException if the preconditions for running the command have not been met
     * @throws UnsupportedCommandException if an unrecognised input is received
     */
    public static Command make(String input, Robot robot) throws InvalidStateException, UnsupportedCommandException {
        Command command;
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
                            throw new InvalidStateException("cannot REPORT until a PLACE command has been issued");
                        }
                        break;
                    case "LEFT":
                    case "RIGHT":
                        // ensure a PLACE has been made previously..
                        if (commandHistory.exists(new PlaceCommand(robot))) {
                            command = new RotateCommand(robot, Direction.valueOf(groupOne));
                        } else {
                            throw new InvalidStateException("cannot rotate LEFT/RIGHT until a PLACE command has been issued");
                        }
                        break;
                    case "MOVE":
                        // ensure a PLACE has been made previously..
                        if (commandHistory.exists(new PlaceCommand(robot))) {
                            command = new MoveCommand(robot);
                        } else {
                            throw new InvalidStateException("cannot MOVE until a PLACE command has been issued");
                        }
                        break;
                    case "?":
                        command = new HelpCommand();
                        break;
                    default:
                        throw new UnsupportedCommandException("unrecognised command");
                }
            }

            commandHistory.push(command);
        } else {
            // could have made my own exception hierarchy but this seemed to do the job nicely..
            throw new UnsupportedCommandException("invalid instruction received");
        }

        return command;
    }

}
