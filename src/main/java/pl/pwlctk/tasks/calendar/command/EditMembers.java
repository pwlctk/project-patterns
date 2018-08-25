package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.Input;
import pl.pwlctk.tasks.calendar.repository.EventRepository;

import java.util.Scanner;

public class EditMembers implements Command {
    private EventService eventService;
    private EventRepository eventRepository;

    public EditMembers(EventService eventService, EventRepository eventRepository) {
        this.eventService = eventService;
        this.eventRepository = eventRepository;
    }

    @Override
    public void run() {
        eventService.showAllEvents();
        System.out.println("Podaj numer wydarzenia do edycji: ");
        Scanner in = new Scanner(System.in);
        int eventId = in.nextInt();

        Event event = eventRepository.getEvents().get(--eventId);
        if (event.getMemberList().isEmpty()) {
            System.out.println("Lista gości jest pusta!");
            System.out.println("Wprowadź dane nowego gościa:");
            eventService.addMember(event);
        } else {
            System.out.print("Wydarzenie: " + event.getName() + "\n");
            System.out.println(eventService.getMembersList(event));
            System.out.println("1 - Dodanie nowego gościa");
            System.out.println("2 - Usunięcie gościa");
            int choice = Input.in.nextInt();
            if (choice == 1) {
                eventService.addMember(event);
            }
            if (choice == 2) {
                eventService.removeMember(event);
            }

        }
        eventService.save();
        System.out.println("Zmieniono!");
    }

    @Override
    public String getHelpMessage() {
        return "Edycja gości w wydarzeniach";
    }

    @Override
    public String getCommandName() {
        return "edit members";
    }
}
