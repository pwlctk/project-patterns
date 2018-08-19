package pl.pwlctk.tasks.calendar;

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

//        service.showAllEvents();
//        System.out.println();
//        System.out.println("Najbliższe wydarzenie:");
//        service.showNextEvent();
//
//        LocalDateTime randomDate = RandomDateTime.createRandomDate(2017, 2020);
//        String date = localDateParser.toInputString(randomDate);
//
//        service.addEvent(date, "Ważny event");
        System.out.println("Program Kalendarz");
        Map<String, String> availableCommands = new HashMap<>();
        availableCommands.put("help","Tutaj będą dostępne komendy");
        availableCommands.put("exit","Koniec programu!");

        Scanner scanner = new Scanner(System.in);
        String command;
        do {

            command = scanner.nextLine();
            if(availableCommands.containsKey(command)){
                System.out.println(availableCommands.get(command));
            } else {
                System.out.println("Niepoprawna komenda!");
            }


        } while (!command.equalsIgnoreCase("exit"));

    }
}
