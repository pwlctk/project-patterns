package pl.pwlctk.patterns.behavior.strategy;

public class TransportMAin {

    public static void main(String[] args) {
        TransportStrategy carTransportStrategy = new CarTransportStrategy();
        TransportStrategy trainTransportStrategy = new TrainTransportStrategy();
        TransportService service = new TransportService(carTransportStrategy);

        System.out.println("Car: ");
        System.out.println("Time: " + service.getTime("białystok", "warszawa"));
        System.out.println("Length: " + service.roadLength("białystok", "warszawa"));

        service = new TransportService(trainTransportStrategy);

        System.out.println("Train: ");
        System.out.println("Time: " + service.getTime("białystok", "warszawa"));
        System.out.println("Length: " + service.roadLength("białystok", "warszawa"));

    }
}
