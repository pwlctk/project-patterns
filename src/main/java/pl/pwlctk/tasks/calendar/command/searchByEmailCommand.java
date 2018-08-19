package pl.pwlctk.tasks.calendar.command;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.EventService;
import pl.pwlctk.tasks.calendar.repository.EventRepository;

import java.util.List;

public class searchByEmailCommand implements Command {
    private EventService service;

    searchByEmailCommand(EventService service) {
        this.service = service;
    }


    @Override
    public void run() {
        EventRepository repository = service.getRepository();
        List<Event> eventsList = repository.getAllEvents();
        for (Event event : eventsList) {
            if(!event.getMemberList().isEmpty()){
                service.showEvent(event);
            }
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
