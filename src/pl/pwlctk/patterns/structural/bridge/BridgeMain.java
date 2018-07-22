package pl.pwlctk.patterns.structural.bridge;

public class BridgeMain {
    public static void main(String[] args) {
        Resource resource = new AlbumResource(
                "Mirage",
                "album_mirage.jpg",
                "piosenka 1\npiosenka 2\npiosenka dodatkowa",
                "Armada"
        );
        View view = new ShortView(resource);
        view.show();
    }
}
