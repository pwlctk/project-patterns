package pl.pwlctk.patterns.creational.factoryMethod;

public class Cat implements Animal {
    @Override
    public void makeASound() {
        System.out.println("Miau miau");
    }
}
