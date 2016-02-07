package jmusic;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import jmusic.util.UtilFunctions;

/**
 * Class to start the music thread
 * @author Ricardo Casanova
 * @version 1.0.0
 * @since JMusic 1.0.0
 */
public final class MusicPlayerControl
{
    private static MusicThread musicThread = null;

    /**
     * Method to init the music player
     * @param currentDirectory The current directory with the songs
     * @since JMusic 1.0.0
     */
    public static void initMusicPlayer(String currentDirectory) 
    {
        UtilFunctions.showInitialMessage();
        UtilFunctions.setCurrentDirectory(currentDirectory);
        MusicPlayerControl.musicThread = new MusicThread();
        MusicPlayerControl.musicThread.start();
    }
    
    /**
     * Method to init the music player
     * @param currentDirectory The current directory with the songs
     * @param listSongs The JList with the songs
     * @param songInfo The jLabel to display the information about the song
     * @since JMusic 1.0.0
     */
    public static void initMusicPlayer(String currentDirectory, JList listSongs, JLabel songInfo)
    {
        UtilFunctions.showInitialMessage();
        UtilFunctions.setCurrentDirectory(currentDirectory);
        MusicPlayerControl.musicThread = new MusicThread(listSongs, songInfo);
        MusicPlayerControl.musicThread.start();
    }
    
    /**
     * Method to init the music player
     * @param currentDirectory The current directory with the songs
     * @param listSongs The JList with the songs
     * @since JMusic 1.0.0
     */
    public static void initMusicPlayer(String currentDirectory, JList listSongs)
    {
        UtilFunctions.showInitialMessage();
        UtilFunctions.setCurrentDirectory(currentDirectory);
        MusicPlayerControl.musicThread = new MusicThread(listSongs);
        MusicPlayerControl.musicThread.start();
    }
    
    /**
     * Method to init the music player
     * @param currentDirectory The current directory with the songs
     * @param songInfo The jLabel to display the information about the song
     * @since JMusic 1.0.0
     */
    public static void initMusicPlayer(String currentDirectory, JLabel songInfo)
    {
        UtilFunctions.showInitialMessage();
        UtilFunctions.setCurrentDirectory(currentDirectory);
        MusicPlayerControl.musicThread = new MusicThread(songInfo);
        MusicPlayerControl.musicThread.start();
    }
    
    /**
     * Method to init the music player
     * @param currentDirectory The current directory with the songs
     * @param listSongs The JList with the songs
     * @param songInfo The jLabel to display the information about the song
     * @param listLastPlayed The JList with the last played time
     * @param container The JTable container of the songs
     * @param columnInContainerForListSongs The column that contains the ListSongs
     * @param rowInContainerForListLastPlayed The row that contains the ListLastPlayed
     * @param columnInContainerForListLastPlayed The column that contains the ListLastPlayed
     * @since JMusic 1.0.0
     */
    public static void initMusicPlayer(String currentDirectory, JList listSongs, JLabel songInfo, JList listLastPlayed, JTable container, int columnInContainerForListSongs, int rowInContainerForListLastPlayed, int columnInContainerForListLastPlayed)
    {
        UtilFunctions.showInitialMessage();
        UtilFunctions.setCurrentDirectory(currentDirectory);
        MusicPlayerControl.musicThread = new MusicThread(listSongs, songInfo, listLastPlayed, container, columnInContainerForListSongs, rowInContainerForListLastPlayed, columnInContainerForListLastPlayed);
        MusicPlayerControl.musicThread.start();
    }
    
    /**
     * Method to update de container information
     * @param listSongs The JList with the songs
     * @param listLastPlayed The JList with the last played time
     * @param container The JTable container
     * @param rowInContainerForListLastPlayed The row that contains the ListLastPlayed
     * @since JMusic 1.0.0
     */
    public static void updateContainerInformation(JList listSongs, JList listLastPlayed, JTable container, int rowInContainerForListLastPlayed)
    {
        MusicThread.updateContainerInformation(listSongs, listLastPlayed, container, rowInContainerForListLastPlayed);
    }
    
    /**
     * Method to change a song from index
     * @param indexSong The index of the song in the list
     * @since JMusic 1.0.0
     */
    public static void changeSongFromIndexSong(int indexSong)
    {
        MusicPlayerControl.musicThread.changeSongFromIndexSong(indexSong);
    }
    
    /**
     * Method to load the songs
     * @param playerList The JMusicPlayerList object with the list of songs
     * @since JMusic 1.0.0
     */
    public static void loadSongs(JMusicPlayerList playerList)
    {
        MusicThread.setPlayerList(playerList);
    }
    
    /**
     * Method to play the actual song
     * @since JMusic 1.0.0
     */
    public static void playSong()
    {
        MusicPlayerControl.musicThread.playSong();
    }
    
    /**
     * Method to play all songs
     * @since JMusic 1.0.0
     */
    public static void playAllSongs()
    {
        MusicPlayerControl.musicThread.playAllSongs();
    }
    
    /**
     * Method to stop the actual song
     * @since JMusic 1.0.0
     */
    public static void stopSong()
    {
        MusicPlayerControl.musicThread.stopSong(true);
    }
    
    /**
     * Method to pause the actual song
     * @since JMusic 1.0.0
     */
    public static void pauseSong()
    {
        MusicPlayerControl.musicThread.pauseSong();
    }
    
    /**
     * Method to resume the actual song
     * @since JMusic 1.0.0
     */
    public static void resumeSong()
    {
        MusicPlayerControl.musicThread.resumeSong();
    }
    
    /**
     * Method to play the previous song
     * @since JMusic 1.0.0
     */
    public static void prevSong()
    {
        MusicPlayerControl.musicThread.prevSong();
    }
    
    /**
     * Method to play the next song
     * @since JMusic 1.0.0
     */
    public static void nextSong()
    {
        MusicPlayerControl.musicThread.nextSong();
    }
    
    /**
     * Method to repeat the actual song
     * @param repeatSong Boolean to indicate if you want to repeat the song or not
     * @since JMusic 1.0.0
     */
    public static void repeatSong(boolean repeatSong)
    {
        MusicPlayerControl.musicThread.repeatSong(repeatSong);
    }
    
    /**
     * Method to repeat all the songs from the beginning of the list
     * @param repeatSongs Boolean to indicate if you want to repeat the songs from the beginning or not
     * @since JMusic 1.0.0
     */
    public static void repeatSongsFromTheBeginning(boolean repeatSongs)
    {
        MusicPlayerControl.musicThread.repeatSongsFromTheBeginning(repeatSongs);
    }
    
    /**
     * Method to validate if the actual song is complete
     * @return True if the actual song is complete, False in another case
     * @since JMusic 1.0.0
     */
    public static boolean isTheActualSongComplete()
    {
        return MusicPlayerControl.musicThread.isTheActualSongComplete();
    }
    
    /**
     * Method to validate if all songs are complete
     * @return True if all songs are complete, False in another case
     * @since JMusic 1.0.0
     */
    public static boolean isAllSongsComplete()
    {
        return MusicPlayerControl.musicThread.isAllSongsComplete();
    }
    
    /**
     * Method to shutdown the music thread
     * @since JMusic 1.0.0
     */
    public static void shutdown()
    {
        MusicPlayerControl.musicThread.stopThread();
    }
    
    /**
     * Method to update the order un the player list
     * @since JMusic 1.0.0
     */
    public static void updateOrderInPlayerList()
    {
        MusicPlayerControl.musicThread.updateOrderInPlayerList();
    }
    
    /**
     * Method to update the selected song in the JList
     * @since JMusic 1.0.0
     */
    public static void updateSelectedSongInList()
    {
        MusicPlayerControl.musicThread.updateSelectedSongInList();
    }
}