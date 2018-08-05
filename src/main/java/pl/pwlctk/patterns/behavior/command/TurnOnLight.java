package pl.pwlctk.patterns.behavior.command;

public class TurnOnLight implements Command {
    private final Light light;

    public TurnOnLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("Włączam światło");
        light.turnOn();
    }
}
