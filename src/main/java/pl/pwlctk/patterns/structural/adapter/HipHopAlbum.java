package pl.pwlctk.patterns.structural.adapter;

import java.util.Arrays;
import java.util.List;

public class HipHopAlbum implements Album {
    @Override
    public List<String> listofSongs() {
        return Arrays.asList(
                "piosenka 1",
                "piosenka 2",
                "piosenka 3"
        );
    }

    @Override
    public String front() {
        return "Zdjęcie Leroya";
    }
}
