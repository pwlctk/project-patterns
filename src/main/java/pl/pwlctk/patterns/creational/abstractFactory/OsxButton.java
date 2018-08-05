package pl.pwlctk.patterns.creational.abstractFactory;

public class OsxButton implements Button {
    @Override
    public void click() {
        System.out.println("Nie znam tego systemu");
    }

    @Override
    public void show() {
        System.out.println("OSX button");
    }
}
