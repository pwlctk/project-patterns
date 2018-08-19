package pl.pwlctk.tasks.calendar;

import pl.pwlctk.tasks.calendar.command.*;
import pl.pwlctk.tasks.calendar.repository.EventRepository;
import pl.pwlctk.tasks.calendar.repository.RepositoryFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalendarApplication {
    public static void main(String[] args) {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        LocalDateParser localDateParser = new LocalDateParser(propertiesLoader);
        EventParser eventParser = new EventParser();

        RepositoryFactory repositoryFactory = new RepositoryFactory(propertiesLoader, localDateParser, eventParser);
        EventRepository repository = repositoryFactory.createRepository();
        EventService service = new EventService(repository, localDateParser);
        System.out.println("Kalendarz");

//        service.showAllEvents();
//        System.out.println();
//        System.out.println("Najbliższe wydarzenie:");
//        service.showNextEvent();
//        LocalDateTime randomDate = RandomDateTime.createRandomDate(2017, 2020);
//        String date = localDateParser.toInputString(randomDate);
//        service.addEvent(date, "Ważny event");

        Map<String, Command> availableCommands = new HashMap<>();
        availableCommands.put("help", new HelpCommand(availableCommands));
        availableCommands.put("exit", new ExitCommand());
        availableCommands.put("all", new ShowAllEventsCommand(service));
        availableCommands.put("next", new NextEventCommand(service));
        availableCommands.put("add", new AddEventCommand(service, localDateParser, propertiesLoader));

        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("Podaj komendę:");
            command = scanner.nextLine();
            if (availableCommands.containsKey(command.trim())) {
                availableCommands.get(command).run();
            } else {
                System.out.println("Niepoprawna komenda! Wpisz help aby wyświetlić listę komend");
            }


        } while (!command.equalsIgnoreCase("exit"));

    }
}
