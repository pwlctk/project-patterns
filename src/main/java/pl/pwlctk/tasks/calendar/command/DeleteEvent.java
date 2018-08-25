package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.repository.EventRepository;

import java.util.Scanner;

public class DeleteEvent implements Command {
    private EventService eventService;
    private EventRepository eventRepository;

    DeleteEvent(EventService eventService, EventRepository eventRepository) {
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
        eventService.save();
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
