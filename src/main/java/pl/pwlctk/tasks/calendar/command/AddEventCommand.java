package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import pl.pwlctk.tasks.calendar.Member;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AddEventCommand implements Command {
    private EventService service;
    private LocalDateParser parser;
    private Member member;

    AddEventCommand(EventService service, LocalDateParser parser, Member member) {
        this.service = service;
        this.parser = parser;
        this.member = member;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String date = parser.getProperDate();
        System.out.println("Podaj nazwę wydarzenia:");
        String name = scanner.nextLine();

        service.addEvent(date, name, member);
        System.out.println("Wydarzenie dodano pomyślnie!");
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
