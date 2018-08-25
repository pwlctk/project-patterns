package pl.pwlctk.tasks.calendar.emitter;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.Member;

public class PrintEventCreationObserver implements EventCreationObserver {

    @Override
    public void notify(Event event, Member member) {
        System.out.println("Utworzono nowe wydarzenie: " + event.getName());
        System.out.println("Przez: " + member.getMember());
    }
}
