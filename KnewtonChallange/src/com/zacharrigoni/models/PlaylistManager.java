package com.zacharrigoni.models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zach Arrigoni
 */
public class PlaylistManager {
    
    private ArtistList artistList;
    private Map<String, ArtistPair> commonArtists;
    
    public PlaylistManager(){
        artistList = new ArtistList();
        commonArtists = new HashMap<>();
    }

    public void recordPairs(Playlist playlist) {
        String[] artists = playlist.getArtists();
        for (int index = 0; index < artists.length; index++)
        {
            Artist firstArtist = artistList.getArtist(artists[index]);
            
            for (int pairIndex = index + 1; pairIndex < artists.length; pairIndex++)
            {
                Artist secondArtist = artistList.getArtist(artists[pairIndex]);
                incrementArtistPair(firstArtist, secondArtist);                
            }            
        }
    }

    public String getCommonPlaylistArtistByThreshhold(int commonThreshhold) {
        String commonPlaylistArtists = "";
        
        for (String key : commonArtists.keySet())
        {
            ArtistPair pair = commonArtists.get(key);
            if (pair.getCommonPlaylistCount() >= commonThreshhold){
                commonPlaylistArtists += pair.toString();
            }
        }
        
        return commonPlaylistArtists;
    }

    private void incrementArtistPair(Artist artistOne, Artist artistTwo) {
        String pairKey;
        if (artistOne.getId() < artistTwo.getId())
        {
            pairKey = + artistOne.getId() + "|" + artistTwo.getId();
        } else
        {
            pairKey = + artistTwo.getId() + "|" + artistOne.getId();
        }
        
        ArtistPair pair;
        if ((pair = commonArtists.get(pairKey)) == null)
        {
            pair = new ArtistPair(artistOne, artistTwo);
        } 
        pair.incrementCount();
        
        commonArtists.put(pairKey, pair);
    }
}
