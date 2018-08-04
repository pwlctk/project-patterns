package pl.pwlctk.patterns.behavior.Gate;

public class MetroApplication {
    public static void main(String[] args) {
        Gate gate = new Gate();
        gate.enter();
        gate.pay("34221");
        gate.enter();

        gate.pay("212");
        gate.enter();
    }
}
