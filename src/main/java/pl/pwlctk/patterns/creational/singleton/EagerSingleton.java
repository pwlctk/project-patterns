package pl.pwlctk.patterns.creational.singleton;

public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();
    private String value;

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    private EagerSingleton() {
        value = "Wartość";
    }
}
