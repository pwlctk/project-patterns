package pl.pwlctk.patterns.creational.builder;

public interface VehicleBuilder {
    VehicleBuilder addWheel();

    VehicleBuilder setTank(int size);
    Vehicle build();
}
