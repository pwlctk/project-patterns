package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;

public class ShowAllEventsCommand implements Command {
    private EventService service;

    ShowAllEventsCommand(EventService service) {
        this.service = service;
    }

    @Override
    public void run() {
        System.out.println("Wszystkie wydarzenia:");
        service.showAllEvents();
    }

    @Override
    public String getHelpMessage() {
        return "Wyświetla wszystkie wydarzenia";
    }

    @Override
    public String getCommandName() {
        return "all";
    }
}
