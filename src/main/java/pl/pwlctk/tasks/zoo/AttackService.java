package pl.pwlctk.tasks.zoo;

public class AttackService {
    private AttackStrategy attackStrategy;


    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    void attack(Animal attacker, Animal deffender) {
        attackStrategy.attack(attacker, deffender);
    }
}
