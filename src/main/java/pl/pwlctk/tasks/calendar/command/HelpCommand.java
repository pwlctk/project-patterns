package pl.pwlctk.tasks.calendar.command;

import java.util.Map;

public class HelpCommand implements Command {
    private Map<String, Command> commands;

    HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void run() {
        //Zerowy sposób
        for (Command value : commands.values()) {
            System.out.println(value.getHelpLine());
        }

        //Pierwszy sposób
//        for (Map.Entry<String, Command> entry : commands.entrySet()) {
//            Command command = entry.getValue();
//            System.out.println(command.getCommandName() + " - " + command.getHelpMessage());
//        }
        //Drugi sposób
//        commands.values().forEach(value -> System.out.println(value.getHelpLine()));
        //Trzeci sposób
       // commands.values().stream().map(Command::getHelpLine).forEach(System.out::println);
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
