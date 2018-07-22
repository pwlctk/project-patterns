package pl.pwlctk.patterns.creational.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vehicle {
    private final int tankSize;
    private final List<Wheel> wheels;

    public Vehicle(int tankSize, List<Wheel> wheels) {
        this.tankSize = tankSize;
        this.wheels = Collections.unmodifiableList(new ArrayList<>(wheels)); //nie pozwala nam dodać nic do listy (będzie wyrzucać wyjątek przy próbie dodania czegoś do listy)
    }

    public int getTankSize() {
        return tankSize;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "tankSize=" + tankSize +
                ", wheels=" + wheels +
                '}';
    }
}

