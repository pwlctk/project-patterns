package pl.pwlctk.tasks.calendar.emitter;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.Member;

public interface EventCreationObserver {
    void notify(Event event, Member member);
}
