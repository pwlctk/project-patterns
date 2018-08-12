package pl.pwlctk.tasks.calendar;

import java.util.List;

public interface EventRepository {
    List<Event> getAllEvents();
    Event getNextEvent();
    void addEvent(Event event);
    void save();
    void load();
    PropertiesLoader getLoader();
}
