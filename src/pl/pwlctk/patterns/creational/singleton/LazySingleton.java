package pl.pwlctk.patterns.creational.singleton;

public class LazySingleton {
    private static LazySingleton INSTANCE;
    private final String value;

    private LazySingleton() {
        this.value = "Wartość";
    }

    public LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
