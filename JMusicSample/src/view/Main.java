/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainWindowViewController;
import jmusic.JMusicPlayer;
import jmusic.JMusicPlayerList;
import jmusic.JMusicSong;
import jmusic.MusicPlayerControl;

/**
 *
 * @author ricardocasanova
 */
public class Main
{
    public static void main(String [] args)
    {
        //__ Use this code if you want to use the JMusic Player
        /*JMusicPlayerList list = new JMusicPlayerList();
        
        list.addSongToPlayerList(new JMusicSong(0,
                                                "01 D'you Know What I Mean_",
                                                "D'you Know What I Mean",
                                                "Oasis",
                                                "Be Here Now"));
        list.addSongToPlayerList(new JMusicSong(1,
                                                "01 Go Let It Out",
                                                "Go Let It Out",
                                                "Oasis",
                                                "Standing On The Shoulders Of Giants"));
        list.addSongToPlayerList(new JMusicSong(2,
                                                "01 Let There Be Love",
                                                "Let There Be Love",
                                                "Oasis",
                                                "Don't Believe The Truth"));
        
        JMusicPlayer.main("/Users/ricardocasanova/Desktop/jSoundsLibrary/", list);*/
        
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
    
}
