package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;

public class NextEvent implements Command {
    private EventService service;

    NextEvent(EventService service) {
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
