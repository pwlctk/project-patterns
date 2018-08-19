package pl.pwlctk.tasks.calendar;

import java.time.LocalDateTime;

public class CalendarApplication {
    public static void main(String[] args) {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        LocalDateParser localDateParser = new LocalDateParser(propertiesLoader);
        EventParser eventParser = new EventParser();

        RepositoryFactory repositoryFactory = new RepositoryFactory(propertiesLoader, localDateParser, eventParser);
        EventRepository repository = repositoryFactory.createRepository();
        EventService service = new EventService(repository, localDateParser);

        service.showAllEvents();
        System.out.println();
        System.out.println("Najbliższe wydarzenie:");
        service.showNextEvent();

        LocalDateTime randomDate = RandomDateTime.createRandomDate(2017, 2020);
        String date = localDateParser.toInputString(randomDate);

        service.addEvent(date, "Ważny event");

    }
}
