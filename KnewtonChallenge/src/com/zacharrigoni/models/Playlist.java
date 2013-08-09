package com.zacharrigoni.models;

/**
 *
 * @author Zach Arrigoni
 */
public class Playlist {

    private String[] artists;
    
    public Playlist(String content) {
        artists = content.split(",");
    }

    /**
     * @return the artists
     */
    public String[] getArtists() {
        return artists;
    }

    /**
     * @param artists the artists to set
     */
    public void setArtists(String[] artists) {
        this.artists = artists;
    }

}
