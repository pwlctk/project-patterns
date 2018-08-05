package pl.pwlctk.patterns.creational.singleton;

public class LazyDoubleCheckSingleton {
    private static volatile LazyDoubleCheckSingleton INSTANCE; //volatile mowi ze zarezerwoj od razu blok pamieci na ta instancje
    private final String value;

    private LazyDoubleCheckSingleton() {
        this.value = "Wartość";
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyDoubleCheckSingleton.class) { //Taki lock dla wątku, aby dwa różne wątki nie mogły się dostać w tym samym czasie do tej metody (klasy)
                if (INSTANCE == null) {
                    INSTANCE = new LazyDoubleCheckSingleton();
                }
            }

        }
        return INSTANCE;
    }
}
