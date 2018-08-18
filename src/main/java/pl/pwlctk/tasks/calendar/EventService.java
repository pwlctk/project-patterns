package pl.pwlctk.tasks.calendar;

import java.util.Optional;

class EventService {
    private EventRepository repository;
    private LocalDateParser dateParser;

    EventService(EventRepository repository, LocalDateParser dateParser) {
        this.repository = repository;
        this.dateParser = dateParser;
    }

    private String getDisplayEvent(Event event) {

        return event.getName() + ": " + dateParser.toDisplayString(event.getDate());
    }

    void showAllEvents() {
        repository.getAllEvents().stream().map(this::getDisplayEvent).forEach(System.out::println);
    }

    void showNextEvent() {
        Optional<Event> event = repository.getNextEvent();
        String display = event.map(this::getDisplayEvent).orElse("Nie ma najbliższego wydarzenia");
        System.out.println(display);

    }

    void addEvent() {
        String newEventDate = "12122012 12:12";
        String newEventName = "Nowe wydarzenie";
        repository.save(new Event(newEventName, newEventDate));
    }


}
