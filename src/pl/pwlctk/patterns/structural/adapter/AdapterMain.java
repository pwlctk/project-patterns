package pl.pwlctk.patterns.structural.adapter;

public class AdapterMain {
    public static void main(String[] args) {
        Book book = new FantasyBook();
        Album album = new HipHopAlbum();
        ResourceProduct resource = new AlbumResource(album); //tutaj uzywamy naszych adapterów
        ResourceProduct resource2 = new BookResource(book); //tutaj uzywamy naszych adapterów
        ViewProduct viewProduct = new ViewProduct(resource);
        ViewProduct viewProduct2 = new ViewProduct(resource2);
        viewProduct.show();
        viewProduct2.show();
    }
}
