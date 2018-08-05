package pl.pwlctk.patterns.creational.factoryMethod;

public class FMMain {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalNameFactory("Reksio");
        Animal animal = animalFactory.createAnimal();
        animal.makeASound();
    }
}
