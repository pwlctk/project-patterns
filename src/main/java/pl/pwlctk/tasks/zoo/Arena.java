package pl.pwlctk.tasks.zoo;

import java.util.HashMap;
import java.util.Map;

public class Arena {

    private Map<String, Bear> bears = new HashMap<>();

    public void add(Bear bear) {
        bear.setArena(this);
        bears.put(bear.getName().toLowerCase(), bear);
    }

    public void attack(Bear attacker, String defenderName) {
        String defender = defenderName.toLowerCase();
        if (bears.containsKey(defender)) {

            attacker.attack(bears.get(defender));
        } else {
            System.out.println(attacker.getName() + " nie znalazł " + defenderName + " na arenie");
        }
    }

    void clear() {
        bears.entrySet().removeIf(entry -> entry.getValue().getLife() <= 0);
    }
}