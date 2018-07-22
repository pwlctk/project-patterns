package pl.pwlctk.patterns.behavior.command;

public class Light {
    private boolean flash;

    public void turnOn() {
        flash = true;
    }

    public void turnOff() {
        flash = false;
    }
}
