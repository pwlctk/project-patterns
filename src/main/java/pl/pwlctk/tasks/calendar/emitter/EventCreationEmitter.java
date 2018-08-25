package pl.pwlctk.tasks.calendar.emitter;

import pl.pwlctk.tasks.calendar.Event;
import pl.pwlctk.tasks.calendar.Member;

import java.util.ArrayList;
import java.util.List;

public class EventCreationEmitter {
    private List<EventCreationObserver> observators = new ArrayList<>();

    public void registerObserver(EventCreationObserver printEventCreationObserver) {
        observators.add(printEventCreationObserver);
    }

    public void unRegisterObserver(PrintEventCreationObserver printEventCreationObserver) {
        observators.remove(printEventCreationObserver);
    }

    public void notify(Event event, Member member) {
        notifyObservers(event, member);
    }

    private void notifyObservers(Event event, Member member) {
        for (EventCreationObserver observator : observators) {
            observator.notify(event, member);
        }
    }
}
