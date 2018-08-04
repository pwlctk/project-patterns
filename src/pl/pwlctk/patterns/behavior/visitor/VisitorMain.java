package pl.pwlctk.patterns.behavior.visitor;

public class VisitorMain {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();

        Customer customer = new RichCustomer("Bogaty Janek");
        customer.accept(taxi);
    }
}
