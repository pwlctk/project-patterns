package pl.pwlctk.tasks.calendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EventParser {
    private final Pattern PATTERN = Pattern.compile("(.*) - (.*)");
    private final PropertiesLoader loader;

    EventParser(PropertiesLoader loader) {
        this.loader = loader;
    }

    Optional<Event> parseToEvent(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (matcher.find()) {
            String dateTime = matcher.group(1);
            String name = matcher.group(2);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(loader.getDateTimeInputFormatter());
            LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);
            Event event = new Event(name, localDateTime);

            return Optional.of(event);
        }
        return Optional.empty();
    }
}
