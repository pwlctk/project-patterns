package pl.pwlctk.patterns.structural.adapter;

public class FantasyBook implements Book {
    @Override
    public String bio() {
        return "biografia autora";
    }

    @Override
    public String frontPicture() {
        return "Ładne zdjęcie";
    }
}
