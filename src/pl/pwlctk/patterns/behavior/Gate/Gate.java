package pl.pwlctk.patterns.behavior.Gate;

public class Gate {

    private GateState gateState = new CloseGateState();

    public void pay(String creditCardNumber) {
        gateState.pay(creditCardNumber);

        if (gateState.paymentOk()) {
            gateState = new OpenGateState();
        }

    }

    public boolean enter() {
        if (gateState.paymentOk()) {
            System.out.println("użytkownik wszedl");
            gateState = new CloseGateState();
            return true;
        }
        System.out.println("bramka zamknieta");
        return false;
    }
}
