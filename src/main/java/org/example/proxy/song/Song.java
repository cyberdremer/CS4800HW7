package org.example.proxy.song;

import java.time.Duration;

public class Song {
    private int id;
    private Duration length;
    private String title;

    private String artist;
    private String albumTitle;

    public Song(int songId, int duration, String title, String albumTitle, String artist){
        this.id = songId;
        this.title = title;
        this.albumTitle = albumTitle;
        this.artist = artist;
        length = Duration.ofSeconds(duration);
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + id +
                ", songTitle='" + title + '\'' +
                ", albumTitle='" + albumTitle + '\'' +
                ", artist='" + artist + '\'' +
                ", duration ='" + length.toMinutesPart() + ": " + length.toSeconds() + '\'' +
                "}\n";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }
}
