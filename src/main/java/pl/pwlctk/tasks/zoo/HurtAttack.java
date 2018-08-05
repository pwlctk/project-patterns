package pl.pwlctk.tasks.zoo;

public class HurtAttack implements AttackStrategy {

    @Override
    public void attack(Animal attacker, Animal deffender) {
        System.out.println(attacker.getName() + " poważnie rani " + deffender.getName());

    }
}
