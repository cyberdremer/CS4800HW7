package org.example.proxy;

import org.example.proxy.song.Song;
import org.example.proxy.streamingservice.AppleMusicCache;

import java.util.List;

public class Main {
    public static void main(String[] args){
        AppleMusicCache musicStreaming = new AppleMusicCache();
        Song song = musicStreaming.searchById(9);
        System.out.println(song);

        Song cachedSong = musicStreaming.searchById(9);
        System.out.println(cachedSong);
        List<Song> songList = musicStreaming.searchByTitle("Soma");
        System.out.println(songList);

        songList = musicStreaming.searchByAlbum("Unknown Pleasure");
        System.out.println(songList);

        List<Song> cachedSongList = musicStreaming.searchByTitle("Soma");
        System.out.println(cachedSongList);

        cachedSongList = musicStreaming.searchByAlbum("Unknown Pleasure");
        System.out.println(cachedSongList);

    }


}
