package pl.pwlctk.tasks.zoo;

public class HugAttack implements AttackStrategy {
    @Override
    public String attack(Animal attacker, Animal deffender) {
        String attackStatus;
        if (deffender.getLife() > 0) {
            deffender.injuries(-5);
            attackStatus = attacker.getName() + " przytula i leczy " + deffender.getName();
        } else {
            attackStatus = deffender.getName() + " niestety już nie żyje :(";
        }
        return attackStatus;
    }
}
