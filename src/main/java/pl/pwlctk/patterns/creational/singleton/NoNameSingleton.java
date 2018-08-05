package pl.pwlctk.patterns.creational.singleton;


//Jest to inna wersja Lazy Singletona
public class NoNameSingleton {

    private final String value;

    private static class Singleton {
        private static final NoNameSingleton INSTANCE = new NoNameSingleton();
    }

    private NoNameSingleton() {
        this.value = "Jakaś wartość";
    }

    public static NoNameSingleton getInstance() {
        return Singleton.INSTANCE;
    }

}


