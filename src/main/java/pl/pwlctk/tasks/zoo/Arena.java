package pl.pwlctk.tasks.zoo;

import java.util.HashMap;
import java.util.Map;

public class Arena {

    private Map<String, DangerousBear> bears = new HashMap<>();

    public void add(DangerousBear bear) {
        bear.setArena(this);
        bears.put(bear.getName(), bear);
    }

    public void attack(DangerousBear attacker, String deffenderName) {
        attacker.attack(bears.get(deffenderName));
    }
}
