package pl.pwlctk.tasks.zoo;

public class TeddyBear extends Animal {
    private String name;
    private int weight;

    TeddyBear() {
        this.name = "Pluszowy Miś";
        this.weight = 1;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Opis: To jest misio zabawka");
    }

    @Override
    boolean isAlive() {
        return super.isAlive();
    }

    @Override
    void eat() {
        throw new IdontEatException();
    }
}
