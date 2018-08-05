package pl.pwlctk.patterns.creational.abstractFactory;

public class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("Windows 10 jest słaby");
    }

    @Override
    public void show() {
        System.out.println("Windows button");
    }
}
