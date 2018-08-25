package pl.pwlctk.tasks.calendar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    private String dateTimeInputFormatter;
    private String dateTimeOutputFormatter;
    private String pathEvent;

    PropertiesLoader() {
        File file = new File("src\\main\\resources\\calendarApp\\app.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInputStream);

            dateTimeInputFormatter = properties.getProperty("inputDateTime");
            dateTimeOutputFormatter = properties.getProperty("outputDateTime");
            pathEvent = properties.getProperty("path.event");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getDateTimeInputFormatter() {
        return dateTimeInputFormatter;
    }

    String getDateTimeOutputFormatter() {
        return dateTimeOutputFormatter;
    }

    public String getPathEvent() {
        return pathEvent;
    }
}
