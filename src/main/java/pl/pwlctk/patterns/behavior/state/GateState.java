package pl.pwlctk.patterns.behavior.state;

public interface GateState {

    void pay(String cardNumber);

    boolean paymentOk();

    boolean enter();

}
