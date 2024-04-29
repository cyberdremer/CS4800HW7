package org.example.proxy.streamingservice;

import org.example.proxy.song.Song;

import java.util.HashMap;
import java.util.List;

public class AppleMusicCache implements SongService {
    HashMap<Integer, Song> integerSongHashMap;
    HashMap<String, List<Song>> titleSongHashmap;

    HashMap<String, List<Song>> albumSongHashmap;

    private AppleMusic appleMusic;

    public AppleMusicCache(){
        this.appleMusic = new AppleMusic();
        integerSongHashMap = new HashMap<>();
        titleSongHashmap = new HashMap<>();
        albumSongHashmap = new HashMap<>();

    }
    @Override
    public Song searchById(Integer songID) {
        if (!integerSongHashMap.containsKey(songID)){
            Song cachedSong = appleMusic.searchById(songID);
            integerSongHashMap.put(songID, cachedSong);

        }
        return integerSongHashMap.get(songID);

    }

    @Override
    public List<Song> searchByTitle(String title) {
        List<Song> titleList;
        if(!titleSongHashmap.containsKey(title)){
            titleList = appleMusic.searchByTitle(title);
            titleSongHashmap.put(title, titleList);

        }
        return titleSongHashmap.get(title);

    }

    @Override
    public List<Song> searchByAlbum(String album) {
        List<Song> albumList;
        if (!albumSongHashmap.containsKey(album)){
            albumList = appleMusic.searchByAlbum(album);
            albumSongHashmap.put(album, albumList);
        }
        return albumSongHashmap.get(album);
    }
}
