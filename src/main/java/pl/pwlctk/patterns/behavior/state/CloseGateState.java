package pl.pwlctk.patterns.behavior.state;

public class CloseGateState implements GateState {
        private boolean payment = false;

    @Override
    public void pay(String cardNumber) {
        if(cardNumber.startsWith("34")){
            System.out.println("płatnośc przebiegla pomyslne");
            payment = true;
        } else {
            System.out.println("błędny numer karty");
            payment = false;
        }
    }

    @Override
    public boolean paymentOk() {
        return payment;
    }

    @Override
    public boolean enter() {
        return false;
    }
}
