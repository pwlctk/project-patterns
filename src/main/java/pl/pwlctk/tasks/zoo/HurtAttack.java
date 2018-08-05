package pl.pwlctk.tasks.zoo;

public class HurtAttack implements AttackStrategy {

    @Override
    public String attack(Animal attacker, Animal deffender) {

        return attacker.getName() + " poważnie rani " + deffender.getName();

    }
}
