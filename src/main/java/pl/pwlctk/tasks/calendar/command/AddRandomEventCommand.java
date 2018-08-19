package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import pl.pwlctk.tasks.calendar.RandomDateTime;

import java.time.LocalDateTime;

public class AddRandomEventCommand implements Command {
    private EventService service;
    private LocalDateParser parser;

    AddRandomEventCommand(EventService eventService, LocalDateParser parser) {
        this.service = eventService;
        this.parser = parser;
    }

    @Override
    public void run() {
        String name = "Losowe wydarzenie";
        LocalDateTime localDateTime = RandomDateTime.createRandomDate(2015, 2020);
        String date = parser.toInputString(localDateTime);
        service.addEvent(date, name);
        System.out.println("Dodano losowe wydarzenie!");
    }

    @Override
    public String getHelpMessage() {
        return "Dodaje losowe wydarzenie";
    }

    @Override
    public String getCommandName() {
        return "add random";
    }
}
