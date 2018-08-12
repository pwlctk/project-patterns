package pl.pwlctk.tasks.calendar;

public class CalendarApplication {
    public static void main(String[] args) {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        EventRepository textRepository = new TextRepository(propertiesLoader);
        textRepository.load();
        EventService service = new EventService(textRepository);

        service.showAllEvents();
    }
}
