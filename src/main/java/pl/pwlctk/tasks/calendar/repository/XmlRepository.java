package pl.pwlctk.tasks.calendar.repository;

import pl.pwlctk.tasks.calendar.*;

import javax.xml.bind.JAXB;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

class XmlRepository implements EventRepository {
    private PropertiesLoader loader;
    private LocalDateParser dateParser;
    private List<Event> events;

    XmlRepository(PropertiesLoader loader, LocalDateParser dateParser) {
        this.loader = loader;
        this.dateParser = dateParser;
        this.events = getEventsFromDisk();
    }


    @Override
    public List<Event> getEventsFromDisk() {
        File xmlFile = new File(loader.getPathEvent());
        Calendar unmarshal = JAXB.unmarshal(xmlFile, Calendar.class);
        return unmarshal.getEventList();
    }

    @Override
    public List<Event> getEvents() {
        return events;
    }

    @Override
    public Optional<Event> getNextEvent() {
        List<Event> all = getEventsFromDisk();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime closedTimeFromNow = LocalDateTime.MAX;
        Event closest = null;
        for (Event event : all) {
            String date = event.getDate();
            LocalDateTime localDateTime = dateParser.toLocalDateTime(date);

            if (localDateTime.isAfter(now) && localDateTime.isBefore(closedTimeFromNow)) {
                closedTimeFromNow = localDateTime;
                closest = event;
            }
        }
        return Optional.ofNullable(closest);
    }


    @Override
    public void addEvent(Event event) {
        events.add(event);

    }

    @Override
    public void saveAll() {
        String path = loader.getPathEvent();
        File xmlFile = new File(path);

        Calendar calendar = new Calendar();
        calendar.setEventList(getEvents());
        JAXB.marshal(calendar, xmlFile);
    }

    @Override
    public void addMember(String name, String email, Event event) {
        event.getMemberList().add(new Member(name, email));

    }

    @Override
    public void deleteMember(int id, Event event) {
        event.getMemberList().remove(id);
    }
}
