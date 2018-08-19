package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.LocalDateParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandRunner {
    private final Map<String, Command> map = new HashMap<>();

    public CommandRunner(EventService service, LocalDateParser parser) {
        addCommand(new HelpCommand(map));
        addCommand(new ExitCommand());
        addCommand(new ShowAllEventsCommand(service));
        addCommand(new NextEventCommand(service));
        addCommand(new AddEventCommand(service, parser));
        addCommand(new AddRandomEventCommand(service, parser));
        addCommand(new searchByEmailCommand(service));
    }

    private void addCommand(Command command) {
        String key = command.getCommandName().trim().toUpperCase();
        map.put(key, command);
    }

    public void removeCommand(Command command) {
        map.remove(command.getCommandName().trim().toUpperCase());
    }

    private Optional<Command> getCommand(String actionName) {
        return Optional.ofNullable(map.get(actionName.trim().toUpperCase()));
    }

    public void runCommand(String actionName) {
        Optional<Command> command = getCommand(actionName);
        if (command.isPresent()) {
            command.get().run();
        } else {
            System.out.println("Niepoprawna komenda! Wpisz help aby wyświetlić listę komend");
        }
    }
}
