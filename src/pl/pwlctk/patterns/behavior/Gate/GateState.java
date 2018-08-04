package pl.pwlctk.patterns.behavior.Gate;

public interface GateState {

    void pay(String cardNumber);

    boolean paymentOk();

    boolean enter();

}
