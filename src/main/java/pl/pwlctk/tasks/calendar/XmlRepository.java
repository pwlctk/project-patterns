package pl.pwlctk.tasks.calendar;

import javax.xml.bind.JAXB;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class XmlRepository implements EventRepository {

    private PropertiesLoader loader;
    private LocalDateParser dateParser;

    XmlRepository(PropertiesLoader loader, LocalDateParser dateParser) {
        this.loader = loader;
        this.dateParser = dateParser;
    }


    @Override
    public List<Event> getAllEvents() {
        File xmlFile = new File(loader.getPathEvent());
        Calendar unmarshal = JAXB.unmarshal(xmlFile, Calendar.class);
        return unmarshal.getEventList();
    }

    @Override
    public Optional<Event> getNextEvent() {
        List<Event> all = getAllEvents();
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

    }

    @Override
    public void saveAllEventsToDisk() {

    }
}
