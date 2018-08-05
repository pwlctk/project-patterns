package pl.pwlctk.patterns.creational.prototype;

public class PrototypeComputerBuilder {
    private final static Computer prototype = new Computer("AMD", 64, "LCD 32\"");

    Computer getComputer() {
        return (Computer) prototype.clone();
    }
}
