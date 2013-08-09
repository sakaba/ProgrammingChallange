package com.zacharrigoni;

import com.zacharrigoni.models.Playlist;
import com.zacharrigoni.models.PlaylistManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Runtime: Looping through the lines in the file is N.
 * Inserting the objects of one line into the playlistManager: N(N-1) 
 * Finding all the pairs with 50 or more matches = N
 * N(N(N-1)) + N = N(N^2 - N + N) = N^3 - N^2 + N^2 = O(N^3)
 * 
 * Space complexity: We store all possible pairs in a hash, which is essentially 
 * N^2 (Artists * Artists or N*N). We also have a hash of all the artists (N) for faster look up, N. The 
 * space complexity breaks down to N^2 + N which is O(N^2)
 * 
 * @author Zach Arrigoni
 */
public class KnewtonChallange {

    private static int COMMON_PLAYLIST_THRESHHOLD = 50;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileLocation;
        
        if (args.length > 0)
        {
            fileLocation = args[0];
        } 
        else 
        {
            System.out.println("Missing file location parameter");
            return;
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
