package pl.pwlctk.tasks.calendar.command;

import java.util.Map;

public class HelpCommand implements Command {
    private Map<String, Command> commands;


    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void run() {
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            String commandName = commands.get(entry.getKey()).getCommandName();
            String helpMessage = commands.get(entry.getKey()).getHelpMessage();

            System.out.println(commandName + " - " + helpMessage);
        }
    }

    @Override
    public String getHelpMessage() {
        return "Wyświetla listę dostępnych komend";
    }

    @Override
    public String getCommandName() {
        return "help";
    }
}
