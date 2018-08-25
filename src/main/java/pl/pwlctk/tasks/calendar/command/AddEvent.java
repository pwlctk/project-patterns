package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import pl.pwlctk.tasks.calendar.Member;
import pl.pwlctk.tasks.calendar.UserRegistrationService;
import pl.pwlctk.tasks.calendar.tools.Input;


public class AddEvent implements Command {
    private EventService service;
    private LocalDateParser parser;
    private UserRegistrationService registrationService;

    AddEvent(EventService service, LocalDateParser parser, UserRegistrationService registrationService) {
        this.service = service;
        this.parser = parser;
        this.registrationService = registrationService;
    }

    @Override
    public void run() {
        String date = parser.getProperDate();
        System.out.println("Podaj nazwę wydarzenia:");
        String name = Input.in.nextLine();

        Member currentUser = registrationService.getLogInUser();
        service.addEvent(name, date, currentUser);

        System.out.println("Wydarzenie dodano pomyślnie!");
    }


    @Override
    public String getHelpMessage() {
        return "Dodanie wydarzenia";
    }

    @Override
    public String getCommandName() {
        return "add";
    }
}
