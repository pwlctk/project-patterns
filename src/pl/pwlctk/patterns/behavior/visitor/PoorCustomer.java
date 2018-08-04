package pl.pwlctk.patterns.behavior.visitor;

public class PoorCustomer implements Customer {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(Taxi taxi) {
        taxi.handleCustomer(this);
    }

    public PoorCustomer(String name) {
        this.name = name;
    }
}
