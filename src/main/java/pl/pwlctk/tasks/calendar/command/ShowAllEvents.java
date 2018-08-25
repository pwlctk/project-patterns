package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;

public class ShowAllEvents implements Command {
    private EventService service;

    ShowAllEvents(EventService service) {
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
