package org.example.proxy.streamingservice;

import org.example.proxy.song.Song;

import java.util.ArrayList;
import java.util.List;

public class AppleMusic implements SongService {
    List<Song> songList;

    public AppleMusic(){
        createSongList();
    }


    private void createSongList(){
        songList = new ArrayList<>();
        songList.add(new Song(1, 200, "She Lost Control", "Unknown Pleasure", "Joy Division"));
        songList.add(new Song(2, 220, "Disorder", "Unknown Pleasure", "Joy Division"));
        songList.add(new Song(3, 190, "Insight", "Unknown Pleasure", "Joy Division"));
        songList.add(new Song(4, 156, "Candidate", "Unknown Pleasure", "Joy Division"));

        songList.add(new Song(5, 230, "Is This It", "Is This It", "The Strokes"));
        songList.add(new Song(6, 219, "The Modern Age", "Is This It", "The Strokes"));
        songList.add(new Song(7, 1228, "Soma", "Is This It", "The Strokes"));
        songList.add(new Song(8, 230, "Take it Or Leave it", "Is This It", "The Strokes"));


        songList.add(new Song(9, 230, "Alien Crime Lord", "Alien Crime Lord", "The Voidz"));
        songList.add(new Song(10, 256, "Mutually Assured Destruction", "Human Sadness", "The Voidz"));


    }

    private void simulateDelay(){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

    }

    @Override
    public Song searchById(Integer songID) {
        simulateDelay();
        Song searchedSong = searchByIdHelper(songID);
        return searchedSong;

    }

    private Song searchByIdHelper(Integer songID){
        Song foundSong = null;
        for (Song song : songList){
            if (song.getId() == songID){
                foundSong = song;
                return foundSong;
            }

        }
        return foundSong;

    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateDelay();
        List<Song> songArrayList = searchByTitleHelper(title);
        return songArrayList;


    }
    private List<Song> searchByTitleHelper(String title){
        List<Song> songTitleList = new ArrayList<>();
        for (Song song : songList){
            if (song.getTitle().equals(title)){
                songTitleList.add(song);
            }

        }
        return songTitleList;

    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateDelay();
        List<Song> songArrayList = searchByAlbumHelper(album);
        return songArrayList;


    }

    private List<Song> searchByAlbumHelper(String album){
        List<Song> songTitleList = new ArrayList<>();
        for (Song song : songList){
            if (song.getAlbumTitle().equals(album)){
                songTitleList.add(song);
            }

        }
        return songTitleList;

    }






}
