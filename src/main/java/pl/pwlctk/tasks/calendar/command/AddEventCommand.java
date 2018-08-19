package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AddEventCommand implements Command {
    private EventService service;
    private LocalDateParser parser;

    AddEventCommand(EventService service, LocalDateParser parser) {
        this.service = service;
        this.parser = parser;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String date = getProperDate(scanner);
        System.out.println("Podaj nazwę wydarzenia:");
        String name = scanner.nextLine();

        service.addEvent(date, name);
        System.out.println("Wydarzenie dodano pomyślnie!");
    }

    private String getProperDate(Scanner scanner) {
        String date = "";
        boolean loop = true;
        while (loop) {
            System.out.println("Podaj datę i godzinę (format: " + parser.getInputDateTimeRegex() + "):");
            String text = scanner.nextLine();
            loop = false;
            try {
                date = parser.toInputString(text);
            } catch (DateTimeParseException e) {
                System.out.println("Zły format daty!");
                loop = true;
            }
        }
        return date;
    }

    @Override
    public String getHelpMessage() {
        return "Dodanie wydarzenia";
    }

    @Override
    public String getCommandName() {
        return "add";
    }
}
