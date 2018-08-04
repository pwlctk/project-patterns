package pl.pwlctk.patterns.behavior.strategy;

public class TransportService {

    private TransportStrategy transportStrategy;

    public TransportService(TransportStrategy transportStrategy) {
        this.transportStrategy = transportStrategy;
    }

    public void setTransportStrategy(TransportStrategy transportStrategy) {
        this.transportStrategy = transportStrategy;
    }

    public int getTime(String from, String to){
        return transportStrategy.getTime(from, to);
    }

    public int roadLength(String from, String to){
        return transportStrategy.roadLength(from, to);
    }



}
