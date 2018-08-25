package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.tools.Input;

import java.util.List;

public class SearchByEmail implements Command {
    private EventService service;

    SearchByEmail(EventService service) {
        this.service = service;
    }

    @Override
    public void run() {
        System.out.println("Podaj email:");
        String email = Input.in.nextLine();
        List<Event> foundEvents = service.findEventsWithGuestByEmail(email);
        if (foundEvents.isEmpty()) {
            System.out.println("Nie znaleziono wydarzeń!");
        } else {
            for (Event event : foundEvents) {
                System.out.println(service.getDisplayEvent(event));
            }
        }
    }

    @Override
    public String getHelpMessage() {
        return "Wyszukuje wydarzenia po emailu";
    }

    @Override
    public String getCommandName() {
        return "search";
    }
}

