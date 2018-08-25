package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import pl.pwlctk.tasks.calendar.UserRegistrationService;
import pl.pwlctk.tasks.calendar.tools.RandomDateTime;

import java.time.LocalDateTime;

public class AddRandomEvent implements Command {
    private EventService service;
    private LocalDateParser parser;
    private UserRegistrationService registrationService;

    AddRandomEvent(EventService eventService, LocalDateParser parser, UserRegistrationService registrationService) {
        this.service = eventService;
        this.parser = parser;
        this.registrationService = registrationService;
    }

    @Override
    public void run() {
        String name = "Losowe wydarzenie";
        LocalDateTime localDateTime = RandomDateTime.createRandomDate(2015, 2020);
        String date = parser.toInputString(localDateTime);
        service.addEvent(date, name, registrationService.getLogInUser());
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
