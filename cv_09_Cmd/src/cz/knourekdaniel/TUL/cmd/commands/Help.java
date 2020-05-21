package cz.knourekdaniel.TUL.cmd.commands;

import cz.knourekdaniel.TUL.cmd.Parser;

import java.io.File;

/**
 *
 * @author janvit
 */
public class Help extends Command {

    @Override
    public String execute(File actualDir) {
        if(params.length == 1){
            return listCommands();
        }
        return Parser.parse(params[1]).getHelp();
    }

    @Override
    public String getHelp() {
        String help = "HELP\n"
                + String.format("%-7s %s\n", "help", "<command> show help for that command");
        return help;
    }

    private String listCommands() {
        String listCommands = "HELP\n"
                + String.format("%-7s %s\n", "help", "Display help")
                + String.format("%-7s %s\n", "dir", "Display list of files and folders");
        return listCommands;
    }

}
