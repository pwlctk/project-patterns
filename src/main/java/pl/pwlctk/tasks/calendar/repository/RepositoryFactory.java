package pl.pwlctk.tasks.calendar.repository;

import pl.pwlctk.tasks.calendar.EventParser;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import pl.pwlctk.tasks.calendar.PropertiesLoader;

public class RepositoryFactory {

    private PropertiesLoader propertiesLoader;
    private LocalDateParser localDateParser;
    private EventParser eventParser;

    public RepositoryFactory(PropertiesLoader propertiesLoader, LocalDateParser localDateParser, EventParser eventParser) {
        this.propertiesLoader = propertiesLoader;
        this.localDateParser = localDateParser;
        this.eventParser = eventParser;
    }

    public EventRepository createRepository() {
        boolean isXml = propertiesLoader.getPathEvent().endsWith(".xml");
        if (isXml) {
            return new XmlRepository(propertiesLoader, localDateParser);
        } else {
            return new TxtRepository(propertiesLoader, eventParser, localDateParser);
        }
    }
}
