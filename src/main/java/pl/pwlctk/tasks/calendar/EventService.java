package pl.pwlctk.tasks.calendar;

import java.util.Optional;

class EventService {
    private EventRepository repository;
    private LocalDateParser dateParser;

    EventService(EventRepository repository, LocalDateParser dateParser) {
        this.repository = repository;
        this.dateParser = dateParser;
    }

    void showAllEvents() {
        repository.getAllEvents().stream().map(this::getDisplayEvent).forEach(System.out::println);
    }

    void showNextEvent() {
        Optional<Event> event = repository.getNextEvent();
        String display = event.map(this::getDisplayEvent).orElse("Nie ma najbliższego wydarzenia");
        System.out.println(display);
    }

    void addEvent(String date, String name) {
        repository.save(new Event(name, date));
    }

    private String getDisplayEvent(Event event) {
        return event.getName() + ": " + dateParser.toDisplayString(event.getDate());
    }
}
