package com.mandy.samples.commands;

/**
 * Lists the set of valid commands.
 *
 * @author Mandy Warren
 */
public class HelpCommand extends Command {

    @Override
    public void execute() {
        System.out.println("\nValid commands:\n" +
                "PLACE X,Y,F\n" +
                "MOVE\n" +
                "LEFT\n" +
                "RIGHT\n" +
                "REPORT\n" +
                "<q> to exit");
    }
}
