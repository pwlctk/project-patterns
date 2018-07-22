package pl.pwlctk.patterns.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class AmericanVehicleBuilder implements VehicleBuilder {

    private List<Wheel> wheels = new ArrayList<>();
    private int tankSize;

    @Override
    public VehicleBuilder addWheel() {
        wheels.add(new Wheel(27));
        return this; //zwraca ten konkretnie obiekt
    }

    @Override
    public VehicleBuilder setTank(int size) {
        tankSize = size;
        return this;
    }

    @Override
    public Vehicle build() {
        return new Vehicle(tankSize, wheels);
    }
}
