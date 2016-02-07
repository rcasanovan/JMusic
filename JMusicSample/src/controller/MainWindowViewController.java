/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import jmusic.JMusicPlayerList;
import jmusic.JMusicSong;
import jmusic.MusicPlayerControl;
import view.AboutWindow;
import view.MyOwnJFrame;

/**
 *
 * @author ricardocasanova
 */
public class MainWindowViewController
{
    private static JLabel jLInfo;
    private static JCheckBoxMenuItem jCBMIRepeatFromTheBeginning;
    private static MyOwnJFrame actualWindow;
    
    public static void initOutlets( JLabel jLInfo, 
                                    JCheckBoxMenuItem jCBMIRepeatFromTheBeginning,
                                    MyOwnJFrame actualWindow)
    {
        MainWindowViewController.jLInfo = jLInfo;
        MainWindowViewController.jCBMIRepeatFromTheBeginning = jCBMIRepeatFromTheBeginning;
        MainWindowViewController.jCBMIRepeatFromTheBeginning.setSelected(false);
        
        MainWindowViewController.actualWindow = actualWindow;
    }
    
    public static void start()
    {
        JMusicPlayerList list = new JMusicPlayerList();
        
        list.addSongToPlayerList(new JMusicSong(1,
                                                "01 D'you Know What I Mean_",
                                                "D'you Know What I Mean",
                                                "Oasis",
                                                "Be Here Now"));
        list.addSongToPlayerList(new JMusicSong(2,
                                                "01 Go Let It Out",
                                                "Go Let It Out",
                                                "Oasis",
                                                "Standing On The Shoulders Of Giants"));
        list.addSongToPlayerList(new JMusicSong(3,
                                                "01 Let There Be Love",
                                                "Let There Be Love",
                                                "Oasis",
                                                "Don't Believe The Truth"));
        
        MusicPlayerControl.initMusicPlayer("/Users/ricardocasanova/Desktop/jSoundsLibrary/", MainWindowViewController.jLInfo);
        MusicPlayerControl.loadSongs(list);
        MusicPlayerControl.playAllSongs();
    }
    
    public static void repeatFromTheBeginning()
    {
        if (MainWindowViewController.jCBMIRepeatFromTheBeginning.isSelected())
            MusicPlayerControl.repeatSongsFromTheBeginning(true);
        else
            MusicPlayerControl.repeatSongsFromTheBeginning(false);
    }
    
    public static void nextSong()
    {
        MusicPlayerControl.nextSong();
    }
    
    public static void goToAboutWindow()
    {
        AboutWindow aboutWindow = new AboutWindow();
        aboutWindow.setVisible(true);
        aboutWindow.setFatherWindow(actualWindow, false);
    }
}
          
    

