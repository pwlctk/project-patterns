package pl.pwlctk.patterns.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class RegisterUser {
    private List<User> database = new ArrayList<>();
    private List<Observer> observators = new ArrayList<>();

    void register(User user) {
        database.add(user);
        notifyObservers(user);
    }

    public void registerObservers(Observer observer) {
        observators.add(observer);
    }

    public void unRegisterObservers(Observer observer) {
        observators.remove(observer);
    }

    private void notifyObservers(User user) {
        for (Observer observator : observators) {
            observator.update(user);
        }
    }
}
