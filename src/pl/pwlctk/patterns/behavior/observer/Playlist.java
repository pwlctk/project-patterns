package pl.pwlctk.patterns.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private User user;
    private List<String> songs = new ArrayList<>();

    public List<String> getSongs() {
        return songs;
    }

    public void setCreator(User user) {
        this.user = user;
    }
}
