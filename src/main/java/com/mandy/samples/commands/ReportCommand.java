package com.mandy.samples.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REPORT will output the X,Y and F of the robot.
 *
 * @author Mandy Warren
 */
public class ReportCommand implements Command {

    private static final Logger logger = LoggerFactory.getLogger(PlaceCommand.class.getName());

    //private Robot robot;

    @Override
    public void execute() {
        // TODO - robot.getPosition()
        logger.debug("executing a REPORT command");

//        if (commandChain.isValid(this)) {
//
//        }
    }
}
