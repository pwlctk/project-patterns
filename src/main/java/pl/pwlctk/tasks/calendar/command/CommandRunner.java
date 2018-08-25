package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import pl.pwlctk.tasks.calendar.Member;
import pl.pwlctk.tasks.calendar.repository.EventRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandRunner {
    private final Map<String, Command> map = new HashMap<>();

    public CommandRunner(EventService service, LocalDateParser parser, Member member, EventRepository eventRepository) {
        addCommand(new Help(map));
        addCommand(new Exit());
        addCommand(new ShowAllEvents(service));
        addCommand(new NextEvent(service));
        addCommand(new AddEvent(service, parser, member));
        addCommand(new AddRandomEvent(service, parser, member));
        addCommand(new SearchByEmail(service, eventRepository));
        addCommand(new DeleteEvent(service, eventRepository));
        addCommand(new EditEvent(service, eventRepository, parser));
        addCommand(new EditMembers(service, eventRepository));
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
