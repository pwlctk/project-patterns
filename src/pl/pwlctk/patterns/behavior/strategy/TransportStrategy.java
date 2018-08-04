package pl.pwlctk.patterns.behavior.strategy;

public interface TransportStrategy {
    int getTime(String from, String to);

    int roadLength(String from, String to);
}
