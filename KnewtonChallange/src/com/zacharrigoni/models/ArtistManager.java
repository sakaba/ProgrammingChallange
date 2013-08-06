package com.zacharrigoni.models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zach Arrigoni
 */
public class ArtistManager {
    private Map<Integer, Artist> artists;
    private int nextIndex;
    
    public ArtistManager(){
        artists = new HashMap<>();
        nextIndex = 0;   
    }
}
