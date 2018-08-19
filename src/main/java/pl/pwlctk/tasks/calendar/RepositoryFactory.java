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
        boolean isXml = propertiesLoader.getPathEvent().contains(".xml");
        if (isXml) {
            return new XmlRepository(propertiesLoader, localDateParser);
        } else {
            return new TxtRepository(propertiesLoader, eventParser, localDateParser);
        }
    }
}
