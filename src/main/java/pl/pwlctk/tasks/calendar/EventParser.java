package pl.pwlctk.tasks.calendar;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventParser {
    private final Pattern PATTERN = Pattern.compile("(.*) - (.*)");

    public String parseToLine(Event event) {
        return event.getDate() + " - " + event.getName();
    }

    public Optional<Event> parseToEvent(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (matcher.find()) {
            String dateTime = matcher.group(1);
            String name = matcher.group(2);
            Event event = new Event(name, dateTime);

            return Optional.of(event);
        }
        return Optional.empty();
    }
}
