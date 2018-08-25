package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.LocalDateParser;
import pl.pwlctk.tasks.calendar.Member;

import java.util.Scanner;

public class AddEvent implements Command {
    private EventService service;
    private LocalDateParser parser;
    private Member member;

    AddEvent(EventService service, LocalDateParser parser, Member member) {
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

        service.save();
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
