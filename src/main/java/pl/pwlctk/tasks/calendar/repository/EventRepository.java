package pl.pwlctk.tasks.calendar.repository;

import pl.pwlctk.tasks.calendar.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
    List<Event> getEventsFromDisk();

    List<Event> getEvents();

    Optional<Event> getNextEvent();

    void addEvent(Event event);

    void saveAll();

    void addMember(String name, String email, Event event);

    void deleteMember(int id, Event event);
}
