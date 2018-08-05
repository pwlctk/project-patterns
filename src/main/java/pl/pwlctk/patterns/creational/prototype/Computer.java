package pl.pwlctk.patterns.creational.prototype;

public class Computer implements Cloneable {
    private final String processorType;
    private final Integer memorySize;
    private final String screen;

    public Computer(String processorType, Integer memorySize, String screen) {
        this.processorType = processorType;
        this.memorySize = memorySize;
        this.screen = screen;
    }

    public String getProcessorType() {
        return processorType;
    }

    public Integer getMemorySize() {
        return memorySize;
    }

    public String getScreen() {
        return screen;
    }

    @Override
    protected Object clone() {
        return new Computer(processorType, memorySize, screen);
    }
}
