package pl.pwlctk.tasks.calendar.emitter;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.Member;

public class SendEmailEventCreationObserver implements EventCreationObserver {

    @Override
    public void notify(Event event, Member member) {
        System.out.println("Wysłano maila");
    }
}