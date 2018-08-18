package pl.pwlctk.tasks.calendar;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EventParser {
    private final Pattern PATTERN = Pattern.compile("(.*) - (.*)");

    String parseToLine(Event event) {
        return event.getDate() + " - " + event.getName();
    }

    Optional<Event> parseToEvent(String line) {
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
