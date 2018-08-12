package pl.pwlctk.tasks.calendar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;

public class PropertyTest {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\resources\\calendarApp\\app.properties");
        FileInputStream fileInputStream = new FileInputStream(file);

        Properties properties = new Properties();
        properties.load(fileInputStream);
        System.out.println(properties.getProperty("name"));


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy HH:mm");
        String date = "12082018 13:30";
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        System.out.println(outputFormatter.format(localDateTime));
    }
}
