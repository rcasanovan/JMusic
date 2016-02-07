package jmusic;

import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import jmusic.util.UtilFunctions;

/**
 * Class to start the timer thread
 * @author Ricardo Casanova
 * @version 1.0.0
 * @since JMusic 1.0.0
 */
public final class TimerThread extends Thread
{
    private static boolean          threadDone = false;
    private static boolean          pauseTimer;
    private static JMusicSong       actualSong;
    private static JLabel           songInfo;

    /**
     * Constructor of the class
     * @param actualSong The actual song played
     * @param songInfo The song info label
     * @since JMusic 1.0.0
     */
    public TimerThread(JMusicSong actualSong, JLabel songInfo)
    {
        TimerThread.actualSong = actualSong;
        TimerThread.songInfo = songInfo;
        TimerThread.threadDone = false;
        TimerThread.pauseTimer = false;
        
        setInfoWithTimer(0);
    }
    
    /**
     * Method to start the timer thread
     * @since JMusic 1.0.0
     */
    @Override
    public void run() 
    {
        int time = 0;
        
        while (!TimerThread.threadDone)
        {
            if (!TimerThread.pauseTimer)
            {
                setInfoWithTimer(time);
                time += 1000;
            }
            
            UtilFunctions.sleep(1000);
        }        
    }
    
    /**
     * Method to stop the timer thread
     * @since JMusic 1.0.0
     */
    public void stopThread()
    {       
        TimerThread.threadDone = true;
        UtilFunctions.sleep(1000);
    }
    
    /**
     * Method to pause the timer thread
     * @param pauseTimer Boolean to pause the timer thread. True, I want to pause the timer; 
     * False, I want to start the timer thread again
     * @since JMusic 1.0.0
     */
    public void pauseTimer(boolean pauseTimer)
    {
        TimerThread.pauseTimer = pauseTimer;
    }
    
    /**
     * Method to set the information of the song
     * @param timeInMilisecs Integer that represents the time to display in the information of the song
     * @since JMusic 1.0.0
     */
    private void setInfoWithTimer(int timeInMilisecs)
    {
        String songName;
        String timerInfo = String.format("%02d:%02d", 
                                        TimeUnit.MILLISECONDS.toMinutes(timeInMilisecs),
                                        TimeUnit.MILLISECONDS.toSeconds(timeInMilisecs) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeInMilisecs)));
        
        /* If the song name's lenght is over 28 && the label's height is minor than 290
         * THEN we must reduce the song name info
         */
        if (TimerThread.actualSong.getSongNameForDisplay().length() > 28 && TimerThread.songInfo.getSize().height <= 290)
            songName = TimerThread.actualSong.getSongNameForDisplay().substring(0, 28) + "...";
        else
            songName = TimerThread.actualSong.getSongNameForDisplay();
        
        if (TimerThread.actualSong.getAlbum().equals(""))
            TimerThread.songInfo.setText("<html>" + songName + " - " + timerInfo + "<br>" + TimerThread.actualSong.getArtistForDisplay() + " - unknown" + "</html>");
        else
            TimerThread.songInfo.setText("<html>" + songName + " - " + timerInfo + "<br>" + TimerThread.actualSong.getArtistForDisplay() + " - " + TimerThread.actualSong.getAlbumForDisplay() + "</html>");
    }
}
