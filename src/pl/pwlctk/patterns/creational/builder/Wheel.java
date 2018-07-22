package pl.pwlctk.patterns.creational.builder;

public class Wheel {
    private final int size;

    public Wheel(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "size=" + size +
                '}';
    }
}
