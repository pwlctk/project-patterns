package pl.pwlctk.patterns.behavior.command;

public class TurnOffLight implements Command{
    private final Light light;

    TurnOffLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("Wyłączam światło");
        light.turnOff();
    }
}
