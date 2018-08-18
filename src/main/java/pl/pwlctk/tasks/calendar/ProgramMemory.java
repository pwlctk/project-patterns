package pl.pwlctk.tasks.calendar;

import java.util.List;

public class ProgramMemory {
    private EventRepository eventRepository;
    private List<Event> eventList;

    public ProgramMemory(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
        eventList = eventRepository.getAllEvents();
    }
}
