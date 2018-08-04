package pl.pwlctk.patterns.behavior.observer;

public class ObserverMain {

    public static void main(String[] args) {
        RegisterUser registerUser = new RegisterUser();
        registerUser.registerObservers(new PrepareFirstPlaylist());
        registerUser.registerObservers(new ActivationEmailSender());
        registerUser.register(new User("Paweł", "pwlctk@gmail.com"));
    }
}
