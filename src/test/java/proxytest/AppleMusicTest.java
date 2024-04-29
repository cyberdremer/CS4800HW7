package proxytest;

import org.example.proxy.streamingservice.AppleMusic;
import org.example.proxy.song.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppleMusicTest {
    private AppleMusic appleMusic;
    @BeforeEach
    public void setUp(){
        appleMusic = new AppleMusic();
    }

    @Test
    public void testSearchById(){
        Integer songID = 1;
        Song foundSong = appleMusic.searchById(1);
        assertEquals(songID, foundSong.getId());

    }


    @Test
    public void testSearchByNonExistentID(){
       Song foundSong = appleMusic.searchById(450);
       assertEquals(null, foundSong);
    }

    @Test
    public void testSearchByAlbum(){
        List<Song> actualSongList = appleMusic.searchByAlbum("Is This It");
        String expectedAlbumTitle = "Is This It";
        for (Song song: actualSongList){
            assertEquals(expectedAlbumTitle, song.getAlbumTitle());
        }

    }

    @Test
    public void testSearchByNonExistentAlbumTitle(){
        List<Song> actualSongList = appleMusic.searchByAlbum("Kaleidoscope Dreams");
        Integer expectedSizeOfList = 0;
        assertEquals(expectedSizeOfList, actualSongList.size());
    }


    @Test
    public void testSearchByTitle(){
        List<Song> actualSongList = appleMusic.searchByTitle("Disorder");
        String expectedTitle = "Disorder";
        assertEquals(expectedTitle, actualSongList.get(0).getTitle());
    }


    @Test
    public void testSearchByNonExistentTitle(){
        List<Song> actualSongList = appleMusic.searchByTitle("Rainbow Nights");
        Integer sizeOfList = 0;
        assertEquals(sizeOfList, actualSongList.size());

    }
}
