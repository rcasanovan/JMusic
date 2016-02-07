package jmusic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Class to represent a list of songs
 * @author Ricardo Casanova
 * @version 1.0.0
 * @since JMusic 1.0.0
 */
public final class JMusicPlayerList
{
    private ArrayList <JMusicSong> playerList;

    /**
     * Constructor of the class
     * @param playerList The list of the songs
     * @since JMusic 1.0.0
     */
    public JMusicPlayerList(ArrayList<JMusicSong> playerList)
    {
        this.playerList = new ArrayList(playerList);
    }
    
    /**
     * Constructor of the class
     * @since JMusic 1.0.0
     */
    public JMusicPlayerList()
    {
        this.playerList = new ArrayList();
    }

    /**
     * Method to get the player list
     * @return The list of the songs
     * @since JMusic 1.0.0
     */
    public ArrayList<JMusicSong> getPlayerList()
    {
        return playerList;
    }

    /**
     * Method to set the player list
     * @param playerList List songs
     * @since JMusic 1.0.0
     */
    public void setPlayerList(ArrayList<JMusicSong> playerList)
    {
        this.playerList = playerList;
    }
    
    /**
     * Method to add song to the player list
     * @param song A particular song
     * @return Boolean with the result of the insertion
     * @since JMusic 1.0.0
     */
    public boolean addSongToPlayerList(JMusicSong song)
    {
        return this.playerList.add(song);
    }
    
    /**
     * Method to get a song from index
     * @param indexSong The selected index song
     * @return The song from index
     * @since JMusic 1.0.0
     */
    public JMusicSong getSongAtIndex(int indexSong)
    {
        if (indexSong >= 0 && indexSong < this.playerList.size())
            return (JMusicSong) this.playerList.get(indexSong);
        
        return null;
    }
    
    /**
     * Method to get the iterator of the list
     * @return The iterator of the list
     * @since JMusic 1.0.0
     */
    public Iterator iterator()
    {
        return this.playerList.iterator();
    }
    
    /**
     * Method to get the size of the list
     * @return The size of the list
     * @since JMusic 1.0.0
     */
    public int size()
    {
        return this.playerList.size();
    }
    
    /**
     * Method to shuffle the list
     * @since JMusic 1.0.0
     */
    public void shuffle()
    {
        Collections.shuffle(playerList);
    }
}