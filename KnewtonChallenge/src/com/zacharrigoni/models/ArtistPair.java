/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zacharrigoni.models;

/**
 *
 * @author Zach
 */
public class ArtistPair {
    private Artist artistOne;
    private Artist artistTwo;
    private int commonPlaylistCount;

    public ArtistPair(Artist artistOne, Artist artistTwo)
    {
        this.artistOne = artistOne;
        this.artistTwo = artistTwo;
        commonPlaylistCount = 0;
    }

    /**
     * @return the artistOne
     */
    public Artist getArtistOne() {
        return artistOne;
    }

    /**
     * @param artistOne the artistOne to set
     */
    public void setArtistOne(Artist artistOne) {
        this.artistOne = artistOne;
    }

    /**
     * @return the artistTwo
     */
    public Artist getArtistTwo() {
        return artistTwo;
    }

    /**
     * @param artistTwo the artistTwo to set
     */
    public void setArtistTwo(Artist artistTwo) {
        this.artistTwo = artistTwo;
    }

    /**
     * @return the commonPlaylistCount
     */
    public int getCommonPlaylistCount() {
        return commonPlaylistCount;
    }
    
    @Override
    public String toString(){
        return artistOne.getName() + "," + artistTwo.getName() + "\n";
    }

    public void incrementCount() {
        commonPlaylistCount++;
    }
    
}
