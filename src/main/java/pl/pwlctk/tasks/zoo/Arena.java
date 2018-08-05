package pl.pwlctk.tasks.zoo;

import java.util.HashMap;
import java.util.Map;

public class Arena {

    private Map<String, Bear> bears = new HashMap<>();

    public void add(Bear bear) {
        bear.setArena(this);
        bears.put(bear.getName(), bear);
    }

    public void attack(Bear attacker, String deffenderName) {
        attacker.attack(bears.get(deffenderName));
    }
}
