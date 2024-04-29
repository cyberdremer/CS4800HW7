package proxytest;

import org.example.proxy.streamingservice.AppleMusicCache;
import org.example.proxy.song.Song;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppleMusicCacheTest {
    private static AppleMusicCache appleMusicCache;
    @BeforeAll
    public static void setUp(){
        appleMusicCache = new AppleMusicCache();
    }


    @Test
    public void testColdSearch(){
        Integer songID = 1;
        Song foundSong = appleMusicCache.searchById(1);
        assertEquals(songID, foundSong.getId());

    }

    @Test
    public void testCachedSearch(){
        Song foundSong = appleMusicCache.searchById(1);
        Song cachedSong = appleMusicCache.searchById(1);
        assertEquals(foundSong, cachedSong);

    }


    @Test
    public void testAlbumSearchCold(){
        List<Song> actualSongList = appleMusicCache.searchByAlbum("Is This It");
        String expectedAlbumTitle = "Is This It";
        for (Song song: actualSongList){
                assertEquals(expectedAlbumTitle, song.getAlbumTitle());
        }

    }

    @Test
    public void testAlbumSearchCached(){
        List<Song> actualSongList = appleMusicCache.searchByAlbum("Is This It");
        List<Song> cachedSongList = appleMusicCache.searchByAlbum("Is This It");
        assertEquals(cachedSongList, actualSongList);

    }

    @Test
    public void testColdTitleSearch(){
        List<Song> actualSongList = appleMusicCache.searchByTitle("Disorder");
        String expectedTitle = "Disorder";
        assertEquals(expectedTitle, actualSongList.get(0).getTitle());

    }

    @Test
    public void testCachedTitleSearch(){
        List<Song> actualSongList = appleMusicCache.searchByTitle("Disorder");
        List<Song> cachedTitleList = appleMusicCache.searchByTitle("Disorder");
        assertEquals(actualSongList, cachedTitleList);

    }
}
