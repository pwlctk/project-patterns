package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import pl.pwlctk.tasks.calendar.repository.EventRepository;

import java.util.Scanner;

public class EditEvent implements Command {
    private EventService eventService;
    private EventRepository eventRepository;
    private LocalDateParser localDateParser;

    EditEvent(EventService eventService, EventRepository eventRepository, LocalDateParser localDateParser) {
        this.eventService = eventService;
        this.eventRepository = eventRepository;
        this.localDateParser = localDateParser;
    }

    @Override
    public void run() {
        eventService.showAllEvents();
        System.out.println("Podaj numer wydarzenia do edycji: ");
        Scanner in = new Scanner(System.in);
        int eventId = in.nextInt();
        Event event = eventRepository.getEvents().get(--eventId);

        in.nextLine();
        System.out.println("Podaj nazwę: ");
        String name = in.nextLine();
        String date = localDateParser.getProperDate();
        event.setDate(date);
        event.setName(name);

        eventService.save();
        System.out.println("Zmieniono!");
    }

    @Override
    public String getHelpMessage() {
        return "Edycja wydarzenia";
    }

    @Override
    public String getCommandName() {
        return "edit";
    }
}
