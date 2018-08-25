package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.Member;
import pl.pwlctk.tasks.calendar.repository.EventRepository;

import java.util.List;
import java.util.Scanner;

public class SearchByEmail implements Command {
    private EventService service;
    private EventRepository eventRepository;

    SearchByEmail(EventService service, EventRepository eventRepository) {
        this.service = service;
        this.eventRepository = eventRepository;
    }


    @Override
    public void run() {
        System.out.print("Podaj email gościa: ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        List<Event> eventsList = eventRepository.getEventsFromDisk();
        boolean isFound = false;
        System.out.println("Lista wydarzeń, w którym bierze udział: " + email);
        for (Event event : eventsList) {
            if (!event.getMemberList().isEmpty()) {
                for (Member member : event.getMemberList()) {
                    if (member.getEmail().equalsIgnoreCase(email)) {
                        service.showEvent(event);
                        isFound = true;
                    }
                }
            }
        }
        if (!isFound) {
            System.out.println("Nie znaleziono żadnych wydarzeń!");
        }


    }

    @Override
    public String getHelpMessage() {
        return "Wyszukuje wydarzenia po emailu";
    }

    @Override
    public String getCommandName() {
        return "search";
    }
}

