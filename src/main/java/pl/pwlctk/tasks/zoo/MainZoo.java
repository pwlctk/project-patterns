package pl.pwlctk.tasks.zoo;

public class MainZoo {

    public static void main(String[] args) {
        DangerousBear polarBear = new PolarBear();
        DangerousBear brownBear = new BrownBear();
        DangerousBear blackBear = new BlackBear();

        Arena arena = new Arena();

        arena.add(polarBear);
        arena.add(brownBear);
        arena.add(blackBear);

        polarBear.attack("Niedźwiedź Brunatny");
        blackBear.attack("Niedźwiedź Polarny");
    }
}
