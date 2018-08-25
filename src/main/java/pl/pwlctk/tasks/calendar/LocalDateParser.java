package pl.pwlctk.tasks.calendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class LocalDateParser {
    private final PropertiesLoader propertiesLoader;

    LocalDateParser(PropertiesLoader propertiesLoader) {
        this.propertiesLoader = propertiesLoader;
    }

    String toDisplayString(String dateInRawString) {
        LocalDateTime localDateTime = toLocalDateTime(dateInRawString);
        return toDisplayString(localDateTime);
    }

    private String toDisplayString(LocalDateTime localDateTime) {
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

    private String toInputString(String dateInRawString){
        LocalDateTime localDateTime = toLocalDateTime(dateInRawString);
        return toInputString(localDateTime);
    }

    public LocalDateTime toLocalDateTime(String string) {
        String inputDateFormat = propertiesLoader.getDateTimeInputFormatter();
        DateTimeFormatter formatter = DateTimeFormatter.
                ofPattern(inputDateFormat);
        return LocalDateTime.parse(string, formatter);
    }

    private String getInputDateTimeRegex(){
        return propertiesLoader.getDateTimeInputFormatter();
    }

    public String getProperDate() {
        Scanner scanner = new Scanner(System.in);
        String date = "";
        boolean loop = true;
        while (loop) {
            System.out.println("Podaj datę i godzinę (format: " + getInputDateTimeRegex() + "):");
            String text = scanner.nextLine();
            loop = false;
            try {
                date = toInputString(text);
            } catch (DateTimeParseException e) {
                System.out.println("Zły format daty!");
                loop = true;
            }
        }
        return date;
    }
}
