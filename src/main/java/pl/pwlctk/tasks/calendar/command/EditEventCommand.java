package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import pl.pwlctk.tasks.calendar.repository.EventRepository;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EditEventCommand implements Command {
    private EventService eventService;
    private EventRepository eventRepository;
    private LocalDateParser localDateParser;

    EditEventCommand(EventService eventService, EventRepository eventRepository, LocalDateParser localDateParser) {
        this.eventService = eventService;
        this.eventRepository = eventRepository;
        this.localDateParser = localDateParser;
    }

    @Override
    public void run() {
        eventService.showAllEvents();
        System.out.print("Podaj numer wydarzenia do edycji: ");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        String date = localDateParser.getProperDate();
        Event event = eventRepository.getEvents().get(--id);

        in.nextLine();
        System.out.println("Podaj nazwę: ");
        String name = in.nextLine();
        event.setDate(date);
        event.setName(name);

        eventRepository.saveAllEventsToDisk();
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
