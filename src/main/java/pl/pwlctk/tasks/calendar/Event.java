package pl.pwlctk.tasks.calendar;

import java.time.LocalDateTime;

class Event {
    private String name;
    private LocalDateTime dateTime;

    Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
