package pl.pwlctk.tasks.calendar;

import java.time.format.DateTimeFormatter;

class EventService {
    private EventRepository repository;

    EventService(EventRepository repository) {
        this.repository = repository;
    }

    private void displayEvent(Event event) {
        String outputFormat = repository.getLoader().getDateTimeOutputFormatter();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(outputFormat);

        System.out.println(event.getName() + ": " + event.getDateTime().format(formatter));
    }

    void showAllEvents() {
        repository.getAllEvents().forEach(this::displayEvent);
    }


}
