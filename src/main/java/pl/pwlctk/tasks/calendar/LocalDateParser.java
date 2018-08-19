package pl.pwlctk.tasks.calendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateParser {
    private final PropertiesLoader propertiesLoader;

    LocalDateParser(PropertiesLoader propertiesLoader) {
        this.propertiesLoader = propertiesLoader;
    }

    String toDisplayString(String dateInRawString) {
        LocalDateTime localDateTime = toLocalDateTime(dateInRawString);
        return toDisplayString(localDateTime);
    }

    public String toDisplayString(LocalDateTime localDateTime) {
        String outputDateFormat = propertiesLoader.getDateTimeOutputFormatter();
        DateTimeFormatter formatter = DateTimeFormatter.
                ofPattern(outputDateFormat);
        return localDateTime.format(formatter);
    }

    public String toInputString(LocalDateTime localDateTime){
        String inputDateFormat = propertiesLoader.getDateTimeInputFormatter();
        DateTimeFormatter formatter = DateTimeFormatter.
                ofPattern(inputDateFormat);
        return localDateTime.format(formatter);
    }

    public String toInputString(String dateInRawString){
        LocalDateTime localDateTime = toLocalDateTime(dateInRawString);
        return toInputString(localDateTime);
    }

    public LocalDateTime toLocalDateTime(String string) {
        String inputDateFormat = propertiesLoader.getDateTimeInputFormatter();
        DateTimeFormatter formatter = DateTimeFormatter.
                ofPattern(inputDateFormat);
        return LocalDateTime.parse(string, formatter);
    }

    public String getInputDateTimeRegex(){
        return propertiesLoader.getDateTimeInputFormatter();
    }
}
