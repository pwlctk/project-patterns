package pl.pwlctk.tasks.calendar;

import pl.pwlctk.tasks.calendar.command.CommandRunner;
import pl.pwlctk.tasks.calendar.emitter.EventCreationEmitter;
import pl.pwlctk.tasks.calendar.emitter.PrintEventCreationObserver;
import pl.pwlctk.tasks.calendar.repository.EventRepository;
import pl.pwlctk.tasks.calendar.repository.RepositoryFactory;
import pl.pwlctk.tasks.calendar.tools.Input;

public class CalendarApplication {
    public static void main(String[] args) {
        System.out.println("Super KALENDARZ");

        UserRegistrationService userRegistrationService = new UserRegistrationService();

        EventCreationEmitter eventCreationEmitter = new EventCreationEmitter();
        eventCreationEmitter.registerObserver(new PrintEventCreationObserver());

        PropertiesLoader propertiesLoader = new PropertiesLoader();
        LocalDateParser localDateParser = new LocalDateParser(propertiesLoader);
        EventParser eventParser = new EventParser();

        RepositoryFactory repositoryFactory = new RepositoryFactory(propertiesLoader, localDateParser, eventParser);
        EventRepository repository = repositoryFactory.createRepository();
        EventService service = new EventService(repository, localDateParser, eventCreationEmitter);
        CommandRunner commandRunner = new CommandRunner(service, localDateParser, repository, userRegistrationService);

        String command;
        String currentName = userRegistrationService.getLogInUser().getName();
        String currentEmail = userRegistrationService.getLogInUser().getEmail();
        System.out.println("Jesteś zalogowany jako: " + currentName + " (" + currentEmail + ")");
        do {
            System.out.println("Podaj komendę: ");
            command = Input.in.nextLine();
            commandRunner.runCommand(command);

        } while (!command.equalsIgnoreCase("exit"));

    }
}
