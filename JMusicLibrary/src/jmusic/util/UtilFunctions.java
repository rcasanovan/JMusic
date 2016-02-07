package jmusic.util;

/**
 * Class to store useful and common functions
 * @author Ricardo Casanova
 * @version 1.0.0
 * @since JMusic 1.0.0
 */
public final class UtilFunctions
{    
    private static final    String VERSION = "1.0.0";
    private static final    String DATE_RELEASE = "feb 2016";
    private static final    String AUDIO_FORMAT  = ".mp3";
    private static          String currentDirectory;
    private static          String playTextButton = "Play";
    private static          String pauseTextButton = "Pause";
    
    /**
     * Method to get the current version of JMusic
     * @return The current version
     * @since JMusic 1.0.0
     */
    public static String getCurrentVersion()
    {
        return VERSION;
    }
    
    /**
     * Method to get the date release of the actual version of JMusic
     * @return The date release of the actual version
     * @since JMusic 1.0.0
     */
    public static String getDateRelease()
    {
        return DATE_RELEASE;
    }
    
    /**
     * Method to get the audio format
     * @return The audio format
     * @since JMusic 1.0.0
     */
    public static String getAudioFormat()
    {
        return AUDIO_FORMAT;
    }
    
    /**
     * Method to show initial welcome message
     * @since JMusic 1.0.0
     */
    public static void showInitialMessage()
    {
        System.out.println("|------------------------------------------------------------|");
        System.out.println("| JMusic© Library " + UtilFunctions.getCurrentVersion() + " (" + UtilFunctions.getDateRelease() +")                           |");
        System.out.println("| JMusic© is based on JLayer open source project (v1.0.1)    |");
        System.out.println("| (http://www.javazoom.net/javalayer/javalayer.html)         |");
        System.out.println("|------------------------------------------------------------|");
        System.out.println("| TM and © 2016 Ricardo Casanova N.                          |");
        System.out.println("| All rights reserved                                        |");
        System.out.println("|------------------------------------------------------------|");
        System.out.println("| Developer:                                                 |");
        System.out.println("| Specialist Engineer Ricardo Casanova N.                    |");
        System.out.println("| Web page: www.ricardocasanova.me                           |");
        System.out.println("| Email: ricardo.casanova@outlook.com                        |");
        System.out.println("| Twitter: @rcasanovan                                       |");
        System.out.println("| http://www.youtube.com/user/liamkc                         |");
        System.out.println("|------------------------------------------------------------|");
        System.out.println();
    }
    
    /**
     * Method to set the current directory
     * @param directory The main directory
     * @since JMusic 1.0.0
     */
    public static void setCurrentDirectory(String directory)
    {
        currentDirectory = directory;
    }
    
    /**
     * Method to get the current directory
     * @return String with the current directory
     * @since JMusic 1.0.0
     */
    public static String getCurrentDirectory()
    {
        return currentDirectory;
    }
    
    /**
     * Method to get the play text fot the button
     * @return String with the play text
     * @since JMusic 1.0.0
     */
    public static String getPlayTextButton()
    {
        return playTextButton;
    }
    
    /**
     * Method to get the pause text fot the button
     * @return String with the pause text
     * @since JMusic 1.0.0
     */
    public static String getPauseTextButton()
    {
        return pauseTextButton;
    }
    
    /**
     * Method to generate a sleep with a Thread
     * @param milisecs The miliseconds to sleep
     * @since JMusic 1.0.0
     */
    public static void sleep(int milisecs)
    {
        try 
        {
            Thread.sleep(milisecs);
        } 
        catch (InterruptedException e)
        {   
        }
    }
}