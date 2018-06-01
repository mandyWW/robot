package com.mandy.samples.commands;

import com.mandy.samples.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REPORT will output the X,Y and F of the robot.
 *
 * @author Mandy Warren
 */
public class ReportCommand extends Command {

    private static final Logger logger = LoggerFactory.getLogger(PlaceCommand.class.getName());

    /**
     * Constructs a new ReportCommand for the robot.
     *
     * @param robot the robot being reported on
     */
    public ReportCommand(Robot robot) {
        super(robot);
    }

    @Override
    public void execute() {
        logger.debug("executing a REPORT command");
        logger.info("Output: " + robot.getLocation().toString());

//        if (commandChain.isValid(this)) {
//
//        }
    }
}
