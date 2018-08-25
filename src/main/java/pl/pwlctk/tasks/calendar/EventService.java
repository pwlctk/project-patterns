package pl.pwlctk.tasks.calendar;

import pl.pwlctk.tasks.calendar.emitter.EventCreationEmitter;
import pl.pwlctk.tasks.calendar.repository.EventRepository;
import pl.pwlctk.tasks.calendar.tools.EmailValidation;
import pl.pwlctk.tasks.calendar.tools.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventService {
    private EventRepository repository;
    private LocalDateParser dateParser;
    private EventCreationEmitter eventCreationEmitter;

    EventService(EventRepository repository, LocalDateParser dateParser, EventCreationEmitter eventCreationEmitter) {
        this.repository = repository;
        this.dateParser = dateParser;
        this.eventCreationEmitter = eventCreationEmitter;
    }

    public void showAllEvents() {
        List<Event> allEvents = repository.getEvents();
        for (int i = 0; i < allEvents.size(); i++) {
            Event event = allEvents.get(i);
            System.out.println((i + 1) + ": " + getDisplayEvent(event));
        }
    }

    public void showNextEvent() {
        Optional<Event> event = repository.getNextEvent();
        String display = event.map(this::getDisplayEvent).orElse("Nie ma najbliższego wydarzenia");
        System.out.println(display);
    }

    public void addEvent(String date, String name, Member member) {
        Event newEvent = new Event(date, name, member);
        repository.saveEvent(newEvent);

        eventCreationEmitter.notify(newEvent, member);
    }

    public void removeEvent(Event event) {
        repository.removeEvent(event);
    }

    public void addMember(Event event) {
        EmailValidation emailValidation = new EmailValidation();
        System.out.println("Podaj imię:");
        Input.in.nextLine();
        String name = Input.in.nextLine();
        System.out.println("Podaj email (example@example.com):");
        String email = emailValidation.enterEmail();
        Member member = new Member(name, email);
        event.addMember(member);
    }

    public void removeMember(Event event) {
        if (event.getMemberList().isEmpty()) {
            System.out.println("Lista gości jest pusta");
        } else {
            List<Member> memberList = event.getMemberList();
            for (int i = 0; i < memberList.size(); i++) {
                Member mem = memberList.get(i);
                System.out.println(i + ": " + mem.getMember());
            }
            System.out.println("Podaj numer gościa do usunięcia:");
            int id = Input.in.nextInt();
            event.deleteMember(id);
        }
    }

    public String getDisplayMembersList(Event event) {
        if (event.getMemberList().isEmpty()) {
            return "";
        } else {
            StringBuilder members = new StringBuilder();
            members.append("Goście: ");
            event.getMemberList().forEach(m -> members.append(m.getName()).append("(").append(m.getEmail()).append("), "));

            members.deleteCharAt(members.length() - 1);
            members.deleteCharAt(members.length() - 1);

            return members.toString();
        }
    }

    public String getDisplayEvent(Event event) {
        return event.getName() + ": " + dateParser.toDisplayString(event.getDate()) + "\n" + getDisplayMembersList(event) + "\n";
    }

    public List<Event> findEventsWithGuestByEmail(String email) {
        List<Event> eventsList = repository.getEvents();
        List<Event> foundEvents = new ArrayList<>();
        for (Event event : eventsList) {
            if (isEventContainsGuest(event, email)) {
                foundEvents.add(event);
            }
        }
        return foundEvents;
    }

    private boolean isEventContainsGuest(Event event, String email) {
        for (Member member : event.getMemberList()) {
            if (email.equalsIgnoreCase(member.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public void save() {
        repository.saveAll();
    }
}
