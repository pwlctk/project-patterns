package pl.pwlctk.tasks.zoo;

public class BrownBear extends DangerousBear {
    private AttackStrategy attackStrategy;
    private int weight;
    private String name;

    BrownBear() {
        this.weight = 100;
        this.name = "Niedźwiedź Brunatny";
        attackStrategy = new HurtAttack();
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
        System.out.println("Opis: To jest brunatny misio");
    }

    @Override
    public void attack(Animal animal) {
        attackStrategy.attack(this, animal);
    }
}
