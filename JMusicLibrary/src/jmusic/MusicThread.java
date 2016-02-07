package jmusic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import jmusic.util.UtilFunctions;

/**
 * Class to start the music thread
 * @author Ricardo Casanova
 * @version 1.0.0
 * @since JMusic 1.0.0
 */
public final class MusicThread extends Thread
{
    private static boolean          threadDone      = false;
    private static String           actualSongName;
    private static JMusicSong       actualSong;
    private static int              actualIndexSong;
    private static Player           MP3Player;
    private static boolean          playSong;
    private static boolean          pauseSong;
    private static boolean          resumeSong;
    private static boolean          repeatSong;
    private static boolean          repeatFromTheBeginning;
    private static boolean          stopSong;
    private static JMusicPlayerList playerList      = null;
    
    private static TimerThread      timerThread     = null;
    
    private static JList            listSongs;
    private static JLabel           songInfo;
    
    private static JList            listLastPlayed;
    
    private static JTable           container;
    private static int              columnInContainerForListSongs;
    private static int              rowInContainerForListLastPlayed;
    private static int              columnInContainerForListLastPlayed;

    /**
     * Constructor of the class
     * @since JMusic 1.0.0
     */
    public MusicThread()
    {
        MusicThread.threadDone              = false;
        MusicThread.playSong                = false;
        MusicThread.pauseSong               = false;
        MusicThread.resumeSong              = false;
        MusicThread.stopSong                = false;
        MusicThread.repeatSong              = false;
        MusicThread.repeatFromTheBeginning  = false;
        MusicThread.playerList              = new JMusicPlayerList();
        MusicThread.actualIndexSong         = 0;
        
        MusicThread.timerThread             = null;
        
        MusicThread.listSongs               = null;
        MusicThread.songInfo                = null;
        
        MusicThread.listLastPlayed          = null;
        MusicThread.container                           = null;
        MusicThread.rowInContainerForListLastPlayed     = -1;
        MusicThread.columnInContainerForListLastPlayed  = -1;
    }
    
    /**
     * Constructor of the class
     * @param listSongs The JList with the songs
     * @param songInfo The jLabel to display the information about the song
     * @since JMusic 1.0.0
     */
    public MusicThread(JList listSongs, JLabel songInfo)
    {
        MusicThread.threadDone              = false;
        MusicThread.playSong                = false;
        MusicThread.pauseSong               = false;
        MusicThread.resumeSong              = false;
        MusicThread.stopSong                = false;
        MusicThread.repeatSong              = false;
        MusicThread.repeatFromTheBeginning  = false;
        MusicThread.playerList              = new JMusicPlayerList();
        MusicThread.actualIndexSong         = 0;
        
        MusicThread.timerThread             = null;
        
        MusicThread.listSongs               = listSongs;
        MusicThread.songInfo                = songInfo;
        
        MusicThread.listLastPlayed          = null;
        MusicThread.container                           = null;
        MusicThread.rowInContainerForListLastPlayed     = -1;
        MusicThread.columnInContainerForListLastPlayed  = -1;
    }
    
    /**
     * Constructor of the class
     * @param listSongs The JList with the songs
     * @param songInfo The jLabel to display the information about the song
     * @param listLastPlayed The JList with the last played time
     * @param container The JTable container
     * @param columnInContainerForListSongs Column container position
     * @param rowInContainerForListLastPlayed Row container position
     * @param columnInContainerForListLastPlayed Column container positio for list last played
     * @since JMusic 1.0.0
     */
    public MusicThread(JList listSongs, JLabel songInfo, JList listLastPlayed, JTable container, int columnInContainerForListSongs, int rowInContainerForListLastPlayed, int columnInContainerForListLastPlayed)
    {
        MusicThread.threadDone              = false;
        MusicThread.playSong                = false;
        MusicThread.pauseSong               = false;
        MusicThread.resumeSong              = false;
        MusicThread.stopSong                = false;
        MusicThread.repeatSong              = false;
        MusicThread.repeatFromTheBeginning  = false;
        MusicThread.playerList              = new JMusicPlayerList();
        MusicThread.actualIndexSong         = 0;
        
        MusicThread.timerThread             = null;
        
        MusicThread.listSongs               = listSongs;
        MusicThread.songInfo                = songInfo;
        
        MusicThread.listLastPlayed          = listLastPlayed;
        MusicThread.container                           = container;
        MusicThread.columnInContainerForListSongs       = columnInContainerForListSongs;
        MusicThread.rowInContainerForListLastPlayed     = rowInContainerForListLastPlayed;
        MusicThread.columnInContainerForListLastPlayed  = columnInContainerForListLastPlayed;
    }
    
    /**
     * Method to update de container information
     * @param listSongs The JList with the songs
     * @param listLastPlayed The JList with the last played time
     * @param container The JTable container
     * @param rowInContainerForListLastPlayed The row that contains the ListLastPlayed
     * @since JMusic 1.2.0
     */
    public static void updateContainerInformation(JList listSongs, JList listLastPlayed, JTable container, int rowInContainerForListLastPlayed)
    {
        MusicThread.listSongs                           = listSongs;
        MusicThread.listLastPlayed                      = listLastPlayed;
        MusicThread.container                           = container;
        MusicThread.rowInContainerForListLastPlayed     = rowInContainerForListLastPlayed;
        
        if (actualIndexSong != -1)
        {
            listSongs.setSelectedIndex(actualIndexSong);
        }
    }
    
    /**
     * Constructor of the class
     * @param listSongs The JList with the songs
     * @since JMusic 1.0.0
     */
    public MusicThread(JList listSongs)
    {
        MusicThread.threadDone              = false;
        MusicThread.playSong                = false;
        MusicThread.pauseSong               = false;
        MusicThread.resumeSong              = false;
        MusicThread.stopSong                = false;
        MusicThread.repeatSong              = false;
        MusicThread.repeatFromTheBeginning  = false;
        MusicThread.playerList              = new JMusicPlayerList();
        MusicThread.actualIndexSong         = 0;
        
        MusicThread.timerThread             = null;
        
        MusicThread.listSongs               = listSongs;
        MusicThread.songInfo                = null;
        
        MusicThread.listLastPlayed          = null;
        MusicThread.container                           = null;
        MusicThread.rowInContainerForListLastPlayed     = -1;
        MusicThread.columnInContainerForListLastPlayed  = -1;
    }
    
    /**
     * Constructor of the class
     * @param songInfo The jLabel to display the information about the song
     * @since JMusic 1.0.0
     */
    public MusicThread(JLabel songInfo)
    {
        MusicThread.threadDone              = false;
        MusicThread.playSong                = false;
        MusicThread.pauseSong               = false;
        MusicThread.resumeSong              = false;
        MusicThread.stopSong                = false;
        MusicThread.repeatSong              = false;
        MusicThread.repeatFromTheBeginning  = false;
        MusicThread.playerList              = new JMusicPlayerList();
        MusicThread.actualIndexSong         = 0;
        
        MusicThread.timerThread             = null;
        
        MusicThread.listSongs               = null;
        MusicThread.songInfo                = songInfo;
        
        MusicThread.listLastPlayed          = null;
    }

    /**
     * Method to set the player list
     * @param playerList The JMusicPlayerList object with the list of songs
     * @since JMusic 1.0.0
     */
    public static void setPlayerList(JMusicPlayerList playerList)
    {
        MusicThread.playerList = playerList;
    }
    
    /**
     * Method to start the music thread
     * @since JMusic 1.0.0
     */
    @Override
    public void run() 
    {   
        while (!MusicThread.threadDone)
        {
            UtilFunctions.sleep(200);
            
            if (MusicThread.playSong)
            {
                while (!MusicThread.stopSong && MusicThread.actualIndexSong < MusicThread.playerList.size())
                {
                    JMusicSong song = MusicThread.playerList.getSongAtIndex(MusicThread.actualIndexSong);

                    if (song != null)
                    {
                        try
                        {
                            MusicThread.actualSongName = song.getSongNameForDisplay();
                            MusicThread.actualSong = song;
                            FileInputStream fis = new FileInputStream(UtilFunctions.getCurrentDirectory() + 
                                                                      "/" + song.getArtist() + 
                                                                      "/" + song.getAlbum() + 
                                                                      "/" + song.getFileName() + 
                                                                      UtilFunctions.getAudioFormat());
                            MusicThread.MP3Player = new Player(fis);

                            System.out.println("JMusic is playing the song : " + MusicThread.actualSongName + " by: " + MusicThread.actualSong.getArtist());
                                
                            if (MusicThread.songInfo != null)
                            {
                                MusicThread.timerThread = new TimerThread(song, MusicThread.songInfo);
                                MusicThread.timerThread.start();
                            }
                            
                            if (MusicThread.listSongs != null)
                            {
                                MusicThread.listSongs.setSelectedIndex(MusicThread.actualIndexSong);
                                
                                if (MusicThread.container != null)
                                    ((DefaultTableModel) MusicThread.container.getModel()).fireTableCellUpdated(MusicThread.rowInContainerForListLastPlayed, MusicThread.columnInContainerForListSongs);
                            }
                                                            
                            do
                            {
                                MusicThread.MP3Player.play();
                            } while (!MusicThread.MP3Player.isComplete() && !MusicThread.stopSong);
                                                                                    
                            if (MusicThread.MP3Player.isComplete() && MusicThread.listLastPlayed != null && MusicThread.container != null)
                            {
                                DefaultListModel model = (DefaultListModel) MusicThread.listLastPlayed.getModel();
                                
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                Date date = new Date();
                                model.setElementAt(dateFormat.format(date), MusicThread.actualIndexSong);
                                
                                ((DefaultTableModel) MusicThread.container.getModel()).fireTableCellUpdated(MusicThread.rowInContainerForListLastPlayed, MusicThread.columnInContainerForListLastPlayed);
                            }
                        }
                        catch (FileNotFoundException | JavaLayerException e)
                        {
                            System.err.println("ERROR with " + UtilFunctions.getCurrentDirectory() + "/" + song.getArtist() + "/" + song.getAlbum() + "/" + song.getFileName() + ".mp3");
                        }
                        finally
                        {
                            if (MusicThread.songInfo != null)
                                MusicThread.timerThread.stopThread();
                            
                            if (!MusicThread.stopSong && !MusicThread.repeatSong)
                            {
                                
                                MusicThread.actualIndexSong++;
                                
                                if (MusicThread.repeatFromTheBeginning && MusicThread.actualIndexSong == MusicThread.playerList.size())
                                    MusicThread.actualIndexSong = 0;
                            }     
                        }
                    }
                }
            }    
        }
    }
    
    /**
     * Method to stop the music thread
     * @since JMusic 1.0.0
     */
    public void stopThread()
    {
        UtilFunctions.sleep(1000);
        if (MusicThread.songInfo != null)
            MusicThread.timerThread.stopThread();
            
        System.err.println("JMusic is shuting down...");
        MusicThread.threadDone = true;
    }
    
    /**
     * Method to play the actual song
     * @since JMusic 1.0.0
     */
    public void playSong()
    {
        if (!MusicThread.playSong)
        {
            MusicThread.playSong = true;  
            MusicThread.stopSong = false;
        }
    }
    
    /**
     * Method to play all songs
     * @since JMusic 1.0.0
     */
    public void playAllSongs()
    {
        if (!MusicThread.playSong)
        {
            if (MusicThread.actualIndexSong < MusicThread.playerList.size())
            {
                JMusicSong song = MusicThread.playerList.getSongAtIndex(MusicThread.actualIndexSong);
                
                if (song != null)
                {
                    MusicThread.actualSongName = song.getSongName();
                    playSong();
                }
            }
        }
    }
    
    /**
     * Method to change a song from index
     * @param indexSong The index of the song in the list
     * @since JMusic 1.0.0
     */
    public void changeSongFromIndexSong(int indexSong)
    {
        MusicThread.actualIndexSong = indexSong;
        UtilFunctions.sleep(200);
        playSong();
    }
    
    /**
     * Method to pause the actual song
     * @since JMusic 1.0.0
     */
    public void pauseSong()
    {
        if (!MusicThread.pauseSong && MusicThread.playSong)
        {
            if (MusicThread.songInfo != null)
                MusicThread.timerThread.pauseTimer(true);
            
            MusicThread.resumeSong = false;
            MusicThread.pauseSong = true;
            MusicThread.stopSong = false;
            System.out.println("JMusic is pausing the song : " + MusicThread.actualSongName + " by: " + MusicThread.actualSong.getArtist());
            MusicThread.MP3Player.pause();
        }
    }
    
    /**
     * Method to resume the actual song
     * @since JMusic 1.0.0
     */
    public void resumeSong()
    {
        if (!MusicThread.resumeSong && MusicThread.pauseSong)
        {
            if (MusicThread.songInfo != null)
                MusicThread.timerThread.pauseTimer(false);
            
            MusicThread.resumeSong = true;
            MusicThread.pauseSong = false;
            MusicThread.stopSong = false;
            System.out.println("JMusic is resuming the song : " + MusicThread.actualSongName + " by: " + MusicThread.actualSong.getArtist());
            MusicThread.MP3Player.resume();
        }
    }
    
    /**
     * Method to stop the actual song
     * @param iWantToShowTheMessage Boolean to indicate if you want to show 
     * the message "JMusic is stoping the song" or not
     * @since JMusic 1.0.0
     */
    public void stopSong(boolean iWantToShowTheMessage)
    {
        if (!MusicThread.stopSong && MusicThread.playSong)
        {
            if (MusicThread.songInfo != null)
                MusicThread.timerThread.stopThread();
            
            if (iWantToShowTheMessage)
                System.out.println("JMusic is stoping the song : " + MusicThread.actualSongName + " by: " + MusicThread.actualSong.getArtist());
            
            MusicThread.MP3Player.stop();  
                        
            MusicThread.playSong = false;
            MusicThread.pauseSong = false;
            MusicThread.resumeSong = false;
            MusicThread.stopSong = true;
            
            UtilFunctions.sleep(800);
        }
    }
    
    /**
     * Method to play the previous song
     * @since JMusic 1.0.0
     */
    public void prevSong()
    {
        if (MusicThread.actualIndexSong - 1 >= 0)
        {
            stopSong(false);
            
            if (MusicThread.container != null)
                ((DefaultTableModel) MusicThread.container.getModel()).fireTableCellUpdated(MusicThread.rowInContainerForListLastPlayed, MusicThread.columnInContainerForListSongs);
            
            MusicThread.actualIndexSong--;
            UtilFunctions.sleep(800);
            playSong();
        }
    }
    
    /**
     * Method to play the next song
     * @since JMusic 1.0.0
     */
    public void nextSong()
    {
        if ((MusicThread.actualIndexSong + 1 < MusicThread.playerList.size()) || 
            (MusicThread.repeatFromTheBeginning && MusicThread.actualIndexSong + 1 == MusicThread.playerList.size()))
        {
            stopSong(false);
            
            if (MusicThread.container != null)
                ((DefaultTableModel) MusicThread.container.getModel()).fireTableCellUpdated(MusicThread.rowInContainerForListLastPlayed, MusicThread.columnInContainerForListSongs);
            
            if (MusicThread.actualIndexSong + 1 < MusicThread.playerList.size())
                MusicThread.actualIndexSong++;
            else
                MusicThread.actualIndexSong = 0;
            UtilFunctions.sleep(800);
            playSong();
        }
    }
    
    /**
     * Method to repeat the actual song
     * @param repeatSong Boolean to indicate if you want to repeat the song or not
     * @since JMusic 1.0.0
     */
    public void repeatSong(boolean repeatSong)
    {
        MusicThread.repeatSong = repeatSong;
        
        if (repeatSong)
            System.out.println("JMusic repeat mode ON for the song : " + MusicThread.actualSongName + " by " + MusicThread.actualSong.getArtist());
    }
    
    /**
     * Method to repeat all the songs from the beginning of the list
     * @param repeatSongs Boolean to indicate if you want to repeat the songs from the beginning or not
     * @since JMusic 1.0.0
     */
    public void repeatSongsFromTheBeginning(boolean repeatSongs)
    {
        MusicThread.repeatFromTheBeginning = repeatSongs;
                
        if (repeatSongs)
            System.out.println("JMusic repeat from the beginning mode ON");
    }
    
    /**
     * Method to validate if the actual song is complete
     * @return True if the actual song is complete, False in another case
     * @since JMusic 1.0.0
     */
    public boolean isTheActualSongComplete()
    {
        return MusicThread.MP3Player.isComplete();
    }
    
    /**
     * Method to validate if all songs are complete
     * @return True if all songs are complete, False in another case
     * @since JMusic 1.0.0
     */
    public boolean isAllSongsComplete()
    {
        if (MusicThread.MP3Player.isComplete() && MusicThread.actualIndexSong == MusicThread.playerList.size())
            return true;
        
        return false;
    }
    
    /**
     * Method to update the order in the player list
     * @since JMusic 1.0.0
     */
    public void updateOrderInPlayerList()
    {
        Iterator playerListIterator = MusicThread.playerList.iterator();
        boolean found = false;
        int i = 0;
        
        while (!found && playerListIterator.hasNext())
        {
            JMusicSong song = (JMusicSong) playerListIterator.next();
            
            if (MusicThread.actualIndexSong == song.getNumberSong())
                found = true;
            else
                i++;
        }
        
        if (found)
        {
            MusicThread.actualIndexSong = i;
                        
            playerListIterator = MusicThread.playerList.iterator();
            i = 0;

            while (playerListIterator.hasNext())
            {
                JMusicSong song = (JMusicSong) playerListIterator.next();

                song.setNumberSong(i);
                i++;
            }
        }
    }
    
    /**
     * Method to update the selected song in the list
     * @since JMusic 1.0.0
     */
    public void updateSelectedSongInList()
    {
        if (MusicThread.listSongs != null)
            MusicThread.listSongs.setSelectedIndex(MusicThread.actualIndexSong);
    }
}