package pl.pwlctk.tasks.calendar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TextRepository implements EventRepository {
    private List<Event> allEvents;
    private PropertiesLoader loader;
    private EventParser parser;

    TextRepository(PropertiesLoader loader) {
        this.allEvents = new ArrayList<>();
        this.loader = loader;
        this.parser = new EventParser(loader);
    }
    @Override
    public PropertiesLoader getLoader() {
        return loader;
    }

    @Override
    public void load() {
        try {
            Files.lines(Paths.get(loader.getPathEvent()))
                    .forEach(this::loadLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadLine(String line) {
        Optional<Event> event = parser.parseToEvent(line);
        event.ifPresent(this::addEvent);
    }

    @Override
    public List<Event> getAllEvents() {
        return allEvents;
    }

    @Override
    public Event getNextEvent() {
        return null;
    }

    @Override
    public void addEvent(Event event) {
        allEvents.add(event);

    }

    @Override
    public void save() {

    }
}
