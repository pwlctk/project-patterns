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

        polarBear.attack("Niedźwiedź Brunatny");
        blackBear.attack("Niedźwiedź Polarny");
        teddyBear.attack("Niedźwiedź Czarny");
    }
}
