package pl.pwlctk.patterns.creational.singleton;

public enum EnumSingleton {
    INSTANCE("Jakaś wartość");

    private final String value;

    EnumSingleton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
