package pl.pwlctk.tasks.calendar.repository;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.EventParser;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import pl.pwlctk.tasks.calendar.PropertiesLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TxtRepository implements EventRepository {
    private PropertiesLoader loader;
    private EventParser parser;
    private LocalDateParser dateParser;

    TxtRepository(PropertiesLoader loader, EventParser parser, LocalDateParser dateParser) {
        this.loader = loader;
        this.parser = parser;
        this.dateParser = dateParser;
    }

    @Override
    public List<Event> getAllEvents() {
        try {
            Path path = Paths.get(loader.getPathEvent());
            Stream<Event> eventStream = Files.lines(path)
                    .map(parser::parseToEvent)
                    .filter(Optional::isPresent)
                    .map(Optional::get);
            return eventStream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
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
        String path = loader.getPathEvent();
        String content = "\n" + parser.parseToLine(event);
        try {
            Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAllEventsToDisk() {
        List<Event> allEvents = getAllEvents();
        try {
            String path = loader.getPathEvent();
            StringBuilder content = new StringBuilder();
            for (Event event : allEvents) {
                content.append(parser.parseToLine(event)).append("\n");
            }
            Files.write(Paths.get(path), content.toString().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
