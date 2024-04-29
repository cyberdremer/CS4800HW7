package org.example.proxy.streamingservice;

import org.example.proxy.song.Song;

import java.util.List;
public interface SongService {
    Song searchById(Integer songID);
    List<Song> searchByTitle(String title);
    List<Song> searchByAlbum(String album);
}
