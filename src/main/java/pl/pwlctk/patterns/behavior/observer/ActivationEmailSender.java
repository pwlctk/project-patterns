package pl.pwlctk.patterns.behavior.observer;

public class ActivationEmailSender implements Observer {

    @Override
    public void update(User user) {
        System.out.println("Wysłano email aktywacyjny do użytkownika: " + user.getEmail());
    }
}
