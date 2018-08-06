package pl.pwlctk.tasks.zoo;

public class StrongAttack implements AttackStrategy {

    @Override
    public String attack(Animal attacker, Animal deffender) {
        String attackStatus;
        if (deffender.getLife() > 0) {
            deffender.injuries(20);
            if (deffender.getLife() > 0) {
                attackStatus = attacker.getName() + " poważnie rani " + deffender.getName();
            } else {
                attackStatus = attacker.getName() + " zabija " + deffender.getName();
            }
        } else {
            attackStatus = "Cel już nie żyje!";
        }
        return attackStatus;
    }
}
