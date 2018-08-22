package pl.pwlctk.tasks.calendar.repository;

import pl.pwlctk.tasks.calendar.Calendar;
import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import pl.pwlctk.tasks.calendar.PropertiesLoader;

import javax.xml.bind.JAXB;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
    public void save(Event event) {
        File xmlFile = new File(loader.getPathEvent());
        Calendar calendar = JAXB.unmarshal(xmlFile, Calendar.class);

        List<Event> allEvents = getEvents();
        allEvents.add(event);

        JAXB.marshal(calendar, xmlFile);
    }

    @Override
    public void saveAllEventsToDisk() {
        String path = loader.getPathEvent();
        File xmlFile = new File(path);
        try {
            Files.write(Paths.get(path),"".getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Calendar calendar = JAXB.unmarshal(xmlFile, Calendar.class);
        calendar.setEventList(getEvents());
        JAXB.marshal(calendar, xmlFile);
    }
}
