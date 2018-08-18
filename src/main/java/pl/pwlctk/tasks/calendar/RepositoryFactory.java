package pl.pwlctk.tasks.calendar;

class RepositoryFactory {

    private PropertiesLoader propertiesLoader;
    private LocalDateParser localDateParser;
    private EventParser eventParser;

    RepositoryFactory(PropertiesLoader propertiesLoader, LocalDateParser localDateParser, EventParser eventParser) {
        this.propertiesLoader = propertiesLoader;
        this.localDateParser = localDateParser;
        this.eventParser = eventParser;
    }

    EventRepository createRepository() {
        if (propertiesLoader.getPathEvent().contains(".xml")) {
            return new XmlRepository(propertiesLoader, localDateParser);
        } else {
            return new TextRepository(propertiesLoader, eventParser, localDateParser);
        }
    }
}
