package pl.pwlctk.tasks.zoo;

public class KillAttack implements AttackStrategy {

    @Override
    public String attack(Animal attacker, Animal deffender) {
        return attacker.getName() + " zabija " + deffender.getName();
    }
}
