package pl.pwlctk.patterns.behavior.strategy;

public class TrainTransportStrategy implements TransportStrategy {

    @Override
    public int getTime(String from, String to) {
        if("białystok".equals(from) && "warszawa".equals(to)){
            return 120;
        }
        return 40;
    }

    @Override
    public int roadLength(String from, String to) {
        if("białystok".equals(from) && "warszawa".equals(to)){
            return 190;
        }
        return 400;
    }
}
