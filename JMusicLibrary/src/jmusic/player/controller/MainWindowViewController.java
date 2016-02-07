package jmusic.player.controller;

import java.awt.Cursor;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import jmusic.JMusicPlayerList;
import jmusic.JMusicSong;
import jmusic.MusicPlayerControl;
import jmusic.player.view.AboutWindow;
import jmusic.player.view.MyOwnJFrame;
import jmusic.util.UtilFunctions;

/**
 * View controller class for the JMusic player window
 * @author Ricardo Casanova
 * @version 1.0.0
 * @since JMusic 1.0.0
 */
public final class MainWindowViewController
{
    private static boolean              iPressedThePauseButton;
    private static boolean              iPressedTheResumeButton;
    private static boolean              iMustRepeatASong;
    private static boolean              iMustRepeatASongFromTheBeginning;
    private static boolean              secondPress;
    private static Date                 theFirstClicMoment;
    private static int                  jListIndexSelected;
    private static JMusicPlayerList     list;
    
    private static DefaultListModel     model;
    /* the outlets */
    private static MyOwnJFrame          mainWindow;
    private static JButton              playButton;
    private static JList                listSongs;
    private static JLabel               songInfo;
    private static JCheckBoxMenuItem    repeatSong;
    private static JCheckBoxMenuItem    repeatSongsFromTheBeginning;
    private static JLabel               repeatSongIcon;
    private static JMenuItem            playOrPauseText;
    
    /**
     * Method to init the outlets
     * @param mainWindow
     * @param playButton The play button in the GUI
     * @param listSongs The JList with the list of the songs
     * @param songInfo The JLabel with the song's information
     * @param repeatSong The JCheckBoxMenuItem to repeat a song
     * @param repeatSongIcon The JLabel with the icon for the repeat song action
     * @param repeatSongsFromTheBeginning The JCheckBoxMenuItem to repeat all songs from the beginning
     * @param playOrPauseText The JMenuItem with the "Play" or "Pause" text
     * @since JMusic 1.0.0
     */
    public static void initOutlets( MyOwnJFrame mainWindow, 
                                    JButton playButton, JList listSongs, 
                                    JLabel songInfo, 
                                    JCheckBoxMenuItem repeatSong, 
                                    JLabel repeatSongIcon, 
                                    JCheckBoxMenuItem repeatSongsFromTheBeginning, 
                                    JMenuItem playOrPauseText)
    {
        MainWindowViewController.mainWindow = mainWindow;
        MainWindowViewController.playButton = playButton;
        MainWindowViewController.listSongs  = listSongs;
        MainWindowViewController.songInfo   = songInfo;
        MainWindowViewController.repeatSong = repeatSong;
        MainWindowViewController.repeatSongIcon = repeatSongIcon;
        MainWindowViewController.repeatSongsFromTheBeginning = repeatSongsFromTheBeginning;
        MainWindowViewController.playOrPauseText = playOrPauseText;
    }
         
    /**
     * Method to get the current time
     * @return The current time (in a Date)
     * @since JMusic 1.0.0
     */
    private static Date getCurrentTime()
    {
        return new Date();
    }
    
    /**
     * Method to verify if i'm doing a double clic
     * @return A boolean (i'm doing a double clic -true- or not -false-)
     * @since JMusic 1.0.0
     */
    private static boolean iamDoingDoubleClicOverTheComponent()
    {
        /* if it's the second press over the component &&
         * the difference between the first clic moment and the second is <= 1 sec &&
         * i'm doing the clic over the same element in the JList
         * THEN -> i'm doing double clic! :)
         */
        return secondPress && ( getCurrentTime().getTime() - theFirstClicMoment.getTime() ) / 1000 <= 1 && jListIndexSelected == MainWindowViewController.listSongs.getSelectedIndex();
    }  
    
    /**
     * Method to validate the double clic event
     * @since JMusic 1.0.0
     */
    public static void validateDoubleClic()
    {
        int indexSong;
        
        if (iamDoingDoubleClicOverTheComponent())
        {
            /* stop the actual song */
            MusicPlayerControl.stopSong();
            
            /* select the new song (index) from the JList */
            indexSong = MainWindowViewController.listSongs.getSelectedIndex();
            
            inactiveRepeatSong();
        
            /* change the song in JMusic */
            MusicPlayerControl.changeSongFromIndexSong(indexSong);
            
            /* did I press the pause button? mmm.. no */
            iPressedThePauseButton = false;
            /* and did I press the resume button? mmm.. no */
            iPressedTheResumeButton = false;
            
            /* second press is false again (waiting for the next double clic) */
            secondPress = false;
            
            /* change the buttons images */
            changeLogicButtons();
        }
        else
        {
            /* this is the first clic... i'm waiting for the next */
            secondPress = !secondPress;
            
            /* select the index in the JList */
            jListIndexSelected = MainWindowViewController.listSongs.getSelectedIndex();
            
            /* get the time for the first clic moment */
            theFirstClicMoment = getCurrentTime();
        }
    }
    
    /**
     * Method to change the buttons images
     * @since JMusic 1.0.0
     */
    public static void changeLogicButtons()
    {
        /* did I press the pause button?... well, pause the song */
        if (iPressedThePauseButton)
            pauseSong();
        else
        {   
            /* did I press the resume button?... well, resume the song */
            if (iPressedTheResumeButton)
                resumeSong();
            else
                /* well... just play a song */
                playSong();
        }
        
        iPressedThePauseButton = !iPressedThePauseButton;
        
        /* if I didn't press the pause button, I'll change the image in the play button */
        if (iPressedThePauseButton)
        {
            try
            {
                playButton.setIcon(new ImageIcon(ImageIO.read(MainWindowViewController.class.getResource("/jmusic/player/view/images/IBPause.png"))));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                playOrPauseText.setText(UtilFunctions.getPauseTextButton());
            }
        }
        else
        {
            /* if I pressed the pause button, I'll change the image in the play button */
            try
            {
                playButton.setIcon(new ImageIcon(ImageIO.read(MainWindowViewController.class.getResource("/jmusic/player/view/images/IBPlay.png"))));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                playOrPauseText.setText(UtilFunctions.getPlayTextButton());
                iPressedTheResumeButton = true;
            }
        }
    }
    
    /**
     * Method to init the list songs
     * @param removeAllElements Boolean to determinate if I want to remove all elements in the list
     * @since JMusic 1.0.0
     */
    private static void initTheListSongsAndRemoveAllElements(boolean removeAllElements)
    {
        if (removeAllElements)
            MainWindowViewController.listSongs.removeAll();
        
        model = new DefaultListModel();
        MainWindowViewController.listSongs.setModel(model);
    }
    
    /**
     * Method to load song int the list
     * @since JMusic 1.0.0
     */
    private static void loadSongsInList()
    {
        Iterator listPlayerIterator = list.iterator();
        int i = 0;
        
        while (listPlayerIterator.hasNext()) 
        {
            JMusicSong song = (JMusicSong) listPlayerIterator.next();
            
            int numberSong = song.getNumberSong() + 1;
            String info = "" + numberSong + " " + song.getSongName();
            model.add(i, info);
            i++;
        }
    }
    
    /**
     * Method to init the music player
     * @param directory The directory path
     * @param songsList The song list
     * @since JMusic 1.0.0
     */
    public static void initMusicPlayer(String directory, JMusicPlayerList songsList)
    {
        /* init the music player with the path of the mp3 songs */
        MusicPlayerControl.initMusicPlayer(directory, listSongs, songInfo);
        
        list = songsList;
        
        initTheListSongsAndRemoveAllElements(true);

        loadSongsInList();
   
        MusicPlayerControl.loadSongs(list);
        iPressedThePauseButton = false;
        iPressedTheResumeButton = false;
        secondPress = false; 
        
        inactiveRepeatSong();
        inactiveRepeatSongsFromTheBeginning();
    }
    
    /**
     * Method to play a song
     * @since JMusic 1.0.0
     */
    public static void playSong()
    {
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MusicPlayerControl.playAllSongs();
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    /**
     * Method to pause a song
     * @since JMusic 1.0.0
     */
    public static void pauseSong()
    {
        MusicPlayerControl.pauseSong();
    }
    
    /**
     * Method to resume a song
     * @since JMusic 1.0.0
     */
    public static void resumeSong()
    {
        MusicPlayerControl.resumeSong();
    }
    
    /**
     * Method to stop a song
     * @since JMusic 1.0.0
     */
    public static void stopSong()
    {
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MusicPlayerControl.stopSong();
        iPressedThePauseButton = false;
        iPressedTheResumeButton = false;
        try
        {
            playButton.setIcon(new ImageIcon(ImageIO.read(MainWindowViewController.class.getResource("/jmusic/player/view/images/IBPlay.png"))));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    /**
     * Method to play the song
     * @since JMusic 1.0.0
     */
    public static void nextSong()
    {
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        inactiveRepeatSong();
        MusicPlayerControl.repeatSong(iMustRepeatASong);
        repeatSong.setSelected(iMustRepeatASong);
        MusicPlayerControl.nextSong();
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    /**
     * Method to play the prev song
     * @since JMusic 1.0.0
     */
    public static void prevSong()
    {
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        inactiveRepeatSong();
        MusicPlayerControl.repeatSong(iMustRepeatASong);
        repeatSong.setSelected(iMustRepeatASong);
        MusicPlayerControl.prevSong();
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    /**
     * Method to inactive the repeat song process
     * @since JMusic 1.0.0
     */
    private static void inactiveRepeatSong()
    {
        iMustRepeatASong = false;
        MusicPlayerControl.repeatSong(iMustRepeatASong);
        repeatSong.setSelected(false);
        MainWindowViewController.repeatSongIcon.setVisible(iMustRepeatASong); 
    }
    
    /**
     * Method to repeat the actual song
     * @since JMusic 1.0.0
     */
    public static void repeatSong()
    {
        iMustRepeatASong = !iMustRepeatASong;
        MusicPlayerControl.repeatSong(iMustRepeatASong);
        
        MainWindowViewController.repeatSongIcon.setVisible(iMustRepeatASong);    
    }
    
    /**
     * Method to inactive the repeat songs from the beginning process
     * @since JMusic 1.0.0
     */
    private static void inactiveRepeatSongsFromTheBeginning()
    {
        iMustRepeatASongFromTheBeginning = false;
        MusicPlayerControl.repeatSongsFromTheBeginning(iMustRepeatASongFromTheBeginning);
        repeatSongsFromTheBeginning.setSelected(false);
    }
    
    /**
     * Method to repeat all songs from the beginning
     * @since JMusic 1.0.0
     */
    public static void repeatSongsFromTheBeginning()
    {
        iMustRepeatASongFromTheBeginning = !iMustRepeatASongFromTheBeginning;
        MusicPlayerControl.repeatSongsFromTheBeginning(iMustRepeatASongFromTheBeginning);
        
    }
    
    /**
     * Method to shuffle the list of songs
     * @since JMusic 1.0.0
     */
    public static void shuffle()
    {
        list.shuffle();
        
        MusicPlayerControl.updateOrderInPlayerList();
        
        initTheListSongsAndRemoveAllElements(true);
        
        loadSongsInList();
        
        MusicPlayerControl.updateSelectedSongInList();   
    }
    
    /**
     * Method to shutdown the music player
     * @since JMusic 1.0.0
     */
    public static void shutdown()
    {
        MusicPlayerControl.shutdown();
    }
    
    /**
     * Method to go to the next window from here
     * @param here The "from" JFrame
     * @since JMusic 1.0.0
     */
    public static void goToTheNexWindowFromHere(MyOwnJFrame here)
    {
        AboutWindow aboutWindow = new AboutWindow();
        aboutWindow.setFatherWindow(here, false);
        
        aboutWindow.setVisible(true);
    }
}