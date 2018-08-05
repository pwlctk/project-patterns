package pl.pwlctk.tasks.zoo;

public class HugAttack implements AttackStrategy{
    @Override
    public String attack(Animal attacker, Animal deffender) {
       return attacker.getName() + " przytula " + deffender.getName();
    }
}
