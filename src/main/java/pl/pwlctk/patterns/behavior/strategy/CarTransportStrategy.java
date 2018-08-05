package pl.pwlctk.patterns.behavior.strategy;

public class CarTransportStrategy implements TransportStrategy {
    @Override
    public int getTime(String from, String to) {
        if("białystok".equals(from) && "warszawa".equals(to)){
            return 180;
        }
        return 300;
    }

    @Override
    public int roadLength(String from, String to) {
        if("białystok".equals(from) && "warszawa".equals(to)){
            return 200;
        }
        return 500;
    }
}
