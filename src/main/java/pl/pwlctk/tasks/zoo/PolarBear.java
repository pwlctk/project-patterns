package pl.pwlctk.tasks.zoo;

public class PolarBear extends Bear {
    private AttackStrategy attackStrategy;
    private int weight;
    private String name;

    PolarBear() {
        this.weight = 200;
        this.name = "Niedźwiedź Polarny";
        this.life = 20;
        attackStrategy = new StrongAttack();
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
        System.out.println("Opis: To jest polarny misio");
    }

    @Override
    public void attack(Animal animal) {
        System.out.println(attackStrategy.attack(this, animal));
    }
}
