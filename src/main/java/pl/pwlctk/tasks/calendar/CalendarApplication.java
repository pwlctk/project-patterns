package pl.pwlctk.tasks.calendar;

public class CalendarApplication {
    public static void main(String[] args) {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        LocalDateParser localDateParser = new LocalDateParser(propertiesLoader);
        EventParser eventParser = new EventParser();
        EventRepository textRepository = new TextRepository(propertiesLoader, eventParser, localDateParser);

        EventService service = new EventService(textRepository, localDateParser);

        service.showAllEvents();
        System.out.println();
        System.out.println("Najbliższe wydarzenie:");
        service.showNextEvent();
        service.addEvent();
    }
}
