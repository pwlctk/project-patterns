package pl.pwlctk.tasks.calendar;

import pl.pwlctk.tasks.calendar.command.CommandRunner;
import pl.pwlctk.tasks.calendar.repository.EventRepository;
import pl.pwlctk.tasks.calendar.repository.RepositoryFactory;

import java.util.Scanner;

public class CalendarApplication {
    public static void main(String[] args) {
        System.out.println("Super KALENDARZ");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj imię: ");
        String name = scanner.nextLine();
        String email;

        email = EmailValidation.enterEmail();


        Member member = new Member(name, email);

        PropertiesLoader propertiesLoader = new PropertiesLoader();
        LocalDateParser localDateParser = new LocalDateParser(propertiesLoader);
        EventParser eventParser = new EventParser();

        RepositoryFactory repositoryFactory = new RepositoryFactory(propertiesLoader, localDateParser, eventParser);
        EventRepository repository = repositoryFactory.createRepository();
        EventService service = new EventService(repository, localDateParser);
        CommandRunner commandRunner = new CommandRunner(service, localDateParser, member, repository);

        String command;
        System.out.println("Jesteś zalogowany jako: " + name + " (" + email + ")");
        do {
            System.out.println("Podaj komendę: ");
            command = scanner.nextLine();
            commandRunner.runCommand(command);

        } while (!command.equalsIgnoreCase("exit"));

    }
}
