package pl.pwlctk.tasks.calendar;

import pl.pwlctk.tasks.calendar.command.CommandRunner;
import pl.pwlctk.tasks.calendar.repository.EventRepository;
import pl.pwlctk.tasks.calendar.repository.RepositoryFactory;
import pl.pwlctk.tasks.calendar.tools.Input;

public class CalendarApplication {
    public static void main(String[] args) {
        System.out.println("Super KALENDARZ");

        UserRegistrationService userRegistrationService = new UserRegistrationService();

        PropertiesLoader propertiesLoader = new PropertiesLoader();
        LocalDateParser localDateParser = new LocalDateParser(propertiesLoader);
        EventParser eventParser = new EventParser();

        RepositoryFactory repositoryFactory = new RepositoryFactory(propertiesLoader, localDateParser, eventParser);
        EventRepository repository = repositoryFactory.createRepository();
        EventService service = new EventService(repository, localDateParser);
        CommandRunner commandRunner = new CommandRunner(service, localDateParser, repository, userRegistrationService);

        String command;
        System.out.println("Jesteś zalogowany jako: " + userRegistrationService.getLogInUser().getMember());
        do {
            System.out.println("Podaj komendę: ");
            command = Input.in.nextLine();
            commandRunner.runCommand(command);

        } while (!command.equalsIgnoreCase("exit"));

    }
}
