package pl.pwlctk.tasks.zoo;

public class TeddyBear extends Bear {
    private AttackStrategy attackStrategy;
    private String name;
    private int weight;

    TeddyBear() {
        this.name = "Pluszowy Miś";
        this.weight = 1;
        this.life = 1;
        attackStrategy = new HugAttack();
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

    @Override
    public void attack(Animal animal) {
        System.out.println(attackStrategy.attack(this, animal));
    }
}
