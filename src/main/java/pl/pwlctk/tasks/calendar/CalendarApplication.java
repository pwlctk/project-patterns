package pl.pwlctk.tasks.calendar;

import pl.pwlctk.tasks.calendar.command.CommandRunner;
import pl.pwlctk.tasks.calendar.repository.EventRepository;
import pl.pwlctk.tasks.calendar.repository.RepositoryFactory;

import java.util.Scanner;

public class CalendarApplication {
    public static void main(String[] args) {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        LocalDateParser localDateParser = new LocalDateParser(propertiesLoader);
        EventParser eventParser = new EventParser();

        RepositoryFactory repositoryFactory = new RepositoryFactory(propertiesLoader, localDateParser, eventParser);
        EventRepository repository = repositoryFactory.createRepository();
        EventService service = new EventService(repository, localDateParser);
        CommandRunner commandRunner = new CommandRunner(service, localDateParser);

        System.out.println("Kalendarz");

        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("Podaj komendę:");
            command = scanner.nextLine();
            commandRunner.runCommand(command);

        } while (!command.equalsIgnoreCase("exit"));

    }
}
