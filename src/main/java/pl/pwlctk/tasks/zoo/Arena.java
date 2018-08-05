package pl.pwlctk.tasks.zoo;

import java.util.HashMap;
import java.util.Map;

public class Arena {

    private Map<String, Bear> bears = new HashMap<>();

    public void add(Bear bear) {
        bear.setArena(this);
        bears.put(bear.getName().toLowerCase(), bear);
    }

    public void attack(Bear attacker, String deffenderName) {
        String deffender = deffenderName.toLowerCase();
        if (bears.containsKey(deffender)) {
            attacker.attack(bears.get(deffender));
        } else {
            System.out.println(attacker.getName() + " nie znalazł " + deffenderName + " na arenie");
        }
    }
}
