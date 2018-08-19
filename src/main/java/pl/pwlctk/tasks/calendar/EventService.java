package pl.pwlctk.tasks.calendar;

import pl.pwlctk.tasks.calendar.repository.EventRepository;

import java.util.Optional;

public class EventService {
    private EventRepository repository;
    private LocalDateParser dateParser;

    EventService(EventRepository repository, LocalDateParser dateParser) {
        this.repository = repository;
        this.dateParser = dateParser;
    }

    public void showAllEvents() {
        repository.getAllEvents().stream().map(this::getDisplayEvent).forEach(System.out::println);
    }

    public void showNextEvent() {
        Optional<Event> event = repository.getNextEvent();
        String display = event.map(this::getDisplayEvent).orElse("Nie ma najbliższego wydarzenia");
        System.out.println(display);
    }

    public void addEvent(String date, String name) {
        repository.save(new Event(name, date));
    }

    private String getMembersList(Event event) {
        if (event.getMemberList().isEmpty()) {
            return "";
        } else {
            StringBuilder members = new StringBuilder();
            members.append("\nGoście: ");
            event.getMemberList().forEach(m ->members.append(m.getName()).append(": ").append(m.getEmail()).append(", "));

            members.deleteCharAt(members.length()-1);
            members.deleteCharAt(members.length()-1);

            return members.toString();
        }
    }

    private String getDisplayEvent(Event event) {
        return event.getName() + ": " + dateParser.toDisplayString(event.getDate()) + getMembersList(event);
    }

    public EventRepository getRepository() {
        return repository;
    }

    public void showEvent(Event event) {
        System.out.println(getDisplayEvent(event));
    }
}
