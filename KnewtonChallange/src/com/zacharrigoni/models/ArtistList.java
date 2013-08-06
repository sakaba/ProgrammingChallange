package com.zacharrigoni.models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zach Arrigoni
 */
public class ArtistList {
    private Map<String, Artist> artists;
    private int nextIndex;
    
    public ArtistList(){
        artists = new HashMap<>();
        nextIndex = 0;   
    }
    
    public Artist getArtist(String artistName)
    {
        Artist artist = null;
        if ((artist = artists.get(artistName)) == null)
        {
            artist = new Artist(nextIndex, artistName);
            artists.put(artistName, artist);
            nextIndex++;
        }
        
        return artist;
    }
}
