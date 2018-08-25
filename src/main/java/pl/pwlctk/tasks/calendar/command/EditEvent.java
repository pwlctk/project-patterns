package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import pl.pwlctk.tasks.calendar.repository.EventRepository;
import pl.pwlctk.tasks.calendar.tools.Input;


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
        int eventId = Input.in.nextInt();
        Event eventToEdit = eventRepository.getEvents().get(--eventId);

        Input.in.nextLine();
        System.out.println("Podaj nazwę: ");
        String name = Input.in.nextLine();
        String date = localDateParser.getProperDate();
        eventToEdit.setDate(date);
        eventToEdit.setName(name);

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
