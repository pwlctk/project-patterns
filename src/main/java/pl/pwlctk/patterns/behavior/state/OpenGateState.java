package pl.pwlctk.patterns.behavior.state;

public class OpenGateState implements  GateState {
    @Override
    public void pay(String cardNumber) {
        System.out.println("Już zapłacone");
    }

    @Override
    public boolean paymentOk() {
        System.out.println("płatność zatwierdzona");
        return true;
    }

    @Override
    public boolean enter() {
        System.out.println("Użytkownik wszedł");
        return false;
    }
}
