package pl.pwlctk.patterns.behavior.command;

public class RemoteController {
    private Command button1;
    private Command button2;

    public RemoteController(Light light) {
        button1 = new TurnOnLight(light);
        button2 = new TurnOffLight(light);
    }

    public void setButton1(Command button1) {
        this.button1 = button1;
    }

    public void setButton2(Command button2) {
        this.button2 = button2;
    }

    public void clickButton1(){
        button1.execute();
    }

    public void clickButton2(){
        button2.execute();
    }
}
