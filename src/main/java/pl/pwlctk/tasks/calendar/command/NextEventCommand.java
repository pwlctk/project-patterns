package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;

public class NextEventCommand implements Command {
    private EventService service;

    NextEventCommand(EventService service) {
        this.service = service;
    }

    @Override
    public void run() {
        System.out.println("Najbliższe wydarzenie:");
        service.showNextEvent();
    }

    @Override
    public String getHelpMessage() {
        return "Wyświetla najbliższe wydarzenie";
    }

    @Override
    public String getCommandName() {
        return "next";
    }
}
