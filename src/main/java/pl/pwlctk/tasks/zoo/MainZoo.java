package pl.pwlctk.tasks.zoo;

public class MainZoo {
    public static void main(String[] args) {
        Bear polarBear = new PolarBear();
        Bear brownBear = new BrownBear();
        Bear blackBear = new BlackBear();
        Bear teddyBear = new TeddyBear();

        Arena arena = new Arena();

        arena.add(polarBear);
        arena.add(brownBear);
        arena.add(blackBear);
        arena.add(teddyBear);

        System.out.println("Pierwsza runda:");
        polarBear.attack("Niedźwiedź BrUnatny");
        blackBear.attack("Niedźwiedź Polarny");
        teddyBear.attack("Niedźwiedź Czarny");
        teddyBear.attack("Niedźwiedź brunatny");
        polarBear.attack("Czarny Ninja");

        arena.clear();
        System.out.println("\nArena została wyczyszczona z trupów");
        System.out.println("Druga runda:");
        polarBear.attack("Niedźwiedź Brunatny");
        blackBear.attack("Niedźwiedź Polarny");
        teddyBear.attack("Niedźwiedź Czarny");
        teddyBear.attack("Niedźwiedź brunatny");
        brownBear.attack("Czarny Ninja");
    }
}
