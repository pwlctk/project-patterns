package pl.pwlctk.patterns.behavior.command;

public class CommandLight {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteController remoteController = new RemoteController(light);

        remoteController.clickButton1();
        remoteController.clickButton2();

        remoteController.setButton1(new TurnOffLight(light));//programujemy przycisk1 na wyłączanie światła
        remoteController.clickButton1();
        remoteController.clickButton2();
    }
}
