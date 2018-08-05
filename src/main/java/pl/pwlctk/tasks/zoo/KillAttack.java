package pl.pwlctk.tasks.zoo;

public class KillAttack implements AttackStrategy {

    @Override
    public void attack(Animal attacker, Animal deffender) {
        System.out.println(attacker.getName() + " zabija " + deffender.getName());
    }
}
