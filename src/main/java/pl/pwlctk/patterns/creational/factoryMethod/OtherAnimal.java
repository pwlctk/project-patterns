package pl.pwlctk.patterns.creational.factoryMethod;

public class OtherAnimal implements Animal {
    @Override
    public void makeASound() {
        System.out.println("Weird sound");
    }
}
