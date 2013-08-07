package com.zacharrigoni;

import com.zacharrigoni.models.Playlist;
import com.zacharrigoni.models.PlaylistManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *  
 * 
 * @author zach4939
 */
public class KnewtonChallange {

    private static int COMMON_PLAYLIST_THRESHHOLD = 50;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileLocation = "Artist_lists_small.txt";
        
        if (args.length > 0)
        {
            fileLocation = args[0];
        }
        
        PlaylistManager manager = new PlaylistManager();
        
        try {
            FileReader fileReader = new FileReader(fileLocation);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String content;
            while ((content = bufferedReader.readLine()) != null)
            {
                Playlist playlist = new Playlist(content);
                manager.recordPairs(playlist);
            }
            
            System.out.write(manager.getCommonPlaylistArtistByThreshhold(COMMON_PLAYLIST_THRESHHOLD).getBytes());                    
        } catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
    }
    
}
