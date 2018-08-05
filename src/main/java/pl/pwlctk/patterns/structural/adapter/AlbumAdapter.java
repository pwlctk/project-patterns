package pl.pwlctk.patterns.structural.adapter;

import java.util.stream.Collectors;

public class AlbumAdapter implements ResourceProduct {
    private final Album album;

    public AlbumAdapter(Album album) {
        this.album = album;
    }

    @Override
    public String getPicture() {
        return album.front();
    }

    @Override
    public String getContent() {
        return album.listofSongs()
                .stream().collect(
                        Collectors.joining("\n")
                );
    }
}
