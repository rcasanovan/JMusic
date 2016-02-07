package jmusic;

import jmusic.player.controller.MainWindowViewController;
import jmusic.player.view.MainWindow;

/**
 * Main class for the JMusic player
 * @author Ricardo Casanova
 * @version 1.0.0
 * @since JMusic 1.0.0
 */
public final class JMusicPlayer
{
    public static void main(String directory, JMusicPlayerList songsList)
    {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        
        MainWindowViewController.initMusicPlayer(directory, songsList);
    }
}
