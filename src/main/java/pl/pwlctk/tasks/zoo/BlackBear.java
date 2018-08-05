package pl.pwlctk.tasks.zoo;

public class BlackBear extends DangerousBear {
    private AttackStrategy attackStrategy;
    private int weight;
    private String name;

    BlackBear() {
        this.weight = 50;
        this.name = "Niedźwiedź Czarny";
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
        System.out.println("Opis: To jest czarny misio");
    }

    @Override
    public void attack(Animal animal) {
        attackStrategy.attack(this, animal);
    }
}
