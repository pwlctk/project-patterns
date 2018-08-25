package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.Member;
import pl.pwlctk.tasks.calendar.repository.EventRepository;
import pl.pwlctk.tasks.calendar.tools.Input;

public class DeleteEvent implements Command {
    private EventService eventService;
    private EventRepository eventRepository;

    DeleteEvent(EventService eventService, EventRepository eventRepository) {
        this.eventService = eventService;
        this.eventRepository = eventRepository;
    }

    @Override
    public void run() {
        eventService.showAllEvents();
        System.out.print("Podaj numer wydarzenia do usunięcia: ");
        int id = Input.in.nextInt();

        Event eventToRemove = eventRepository.getEvents().get(--id);
        eventService.removeEvent(eventToRemove);
        Input.in.nextLine();
        System.out.println("Usunięto!");
    }

    @Override
    public String getHelpMessage() {
        return "Edycja wydarzeń";
    }

    @Override
    public String getCommandName() {
        return "delete";
    }
}
