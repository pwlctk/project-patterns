package pl.pwlctk.patterns.behavior.observer;

public class PrepareFirstPlaylist implements Observer {

    @Override
    public void update(User user) {
        Playlist playlist = new Playlist();
        playlist.getSongs().add("Bieber - Baby");
        playlist.setCreator(user);
        System.out.println("Stworzono playliste: ");
        System.out.println(playlist.getSongs());
    }
}
