package pl.pwlctk.tasks.calendar.emitter;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.Member;

public class PrintEventCreationObserver implements EventCreationObserver {

    @Override
    public void notify(Event createdEvent, Member creator) {
        System.out.println("Utworzono wydarzenie: " + createdEvent.getName() + " przez " + creator.getName());
    }
}
