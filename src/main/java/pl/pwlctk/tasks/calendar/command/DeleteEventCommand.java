package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.repository.EventRepository;

import java.util.Scanner;

public class DeleteEventCommand implements Command {
    private EventService eventService;
    private EventRepository eventRepository;

    DeleteEventCommand(EventService eventService, EventRepository eventRepository) {
        this.eventService = eventService;
        this.eventRepository = eventRepository;
    }

    @Override
    public void run() {
        eventService.showAllEvents();
        System.out.print("Podaj numer wydarzenia do usunięcia: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        eventRepository.getEvents().remove(--id);
        eventRepository.saveAllEventsToDisk();
        System.out.println("Usunięto!");

    }

    @Override
    public String getHelpMessage() {
        return "Edycja wydarzeń";
    }

    @Override
    public String getCommandName() {
        return "delete";
    }
}
