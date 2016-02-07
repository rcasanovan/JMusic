package jmusic;

/**
 * Class to represent a song
 * @author Ricardo Casanova
 * @version 1.0.0
 * @since JMusic 1.0.0
 */
public final class JMusicSong
{
    private int     numberSong;
    private String  fileName;
    private String  songName;
    private String  artist;
    private String  album;
    
    private String  songNameForDisplay;
    private String  artistForDisplay;
    private String  albumForDisplay;

    /**
     * Constructor of the class
     * @param numberSong The number of the song
     * @param fileName The file's name of the song
     * @param songName The name of the song
     * @param artist The artist of the song
     * @param album The album of the song
     * @since JMusic 1.0.0
     */
    public JMusicSong(int numberSong, String fileName, String songName, String artist, String album)
    {
        this.numberSong = numberSong;
        this.fileName = fileName;
        this.songName = songName;
        this.artist = artist;
        this.album = album;
        
        this.songNameForDisplay = this.songName;
        this.artistForDisplay = this.artist;
        this.albumForDisplay = this.album;
    }
    
    /**
     * Constructor of the class
     * @param numberSong The number of the song
     * @param fileName The file's name of the song
     * @param songName The name of the song
     * @param songNameForDisplay The name of the song in the jLbael
     * @param artist The artist of the song
     * @param artistForDisplay The artist of the song in the JLabel
     * @param album The album of the song
     * @param albumForDisplay The album of the song in the JLabel
     * @since JMusic 1.0.0
     */
    public JMusicSong(int numberSong, String fileName, String songName, String songNameForDisplay, String artist, String artistForDisplay, String album, String albumForDisplay)
    {
        this.numberSong = numberSong;
        this.fileName = fileName;
        this.songName = songName;
        this.artist = artist;
        this.album = album;
        
        this.songNameForDisplay = songNameForDisplay;
        this.artistForDisplay = artistForDisplay;
        this.albumForDisplay = albumForDisplay;
    }

    /**
     * Method to get the number of the song
     * @return The number of the song
     * @since JMusic 1.0.0
     */
    public int getNumberSong()
    {
        return numberSong;
    }

    /**
     * Method to set the number of the song
     * @param numberSong The number of the song
     * @since JMusic 1.0.0
     */
    public void setNumberSong(int numberSong)
    {
        this.numberSong = numberSong;
    }

    /**
     * Method to get the file name of the song
     * @return The file name of the song
     * @since JMusic 1.0.0
     */
    public String getFileName()
    {
        return fileName;
    }

    /**
     * Method to set the file name of the song
     * @param fileName The file name of the song
     * @since JMusic 1.0.0
     */
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    /**
     * Method to get the name of the song
     * @return The name of the song
     * @since JMusic 1.0.0
     */
    public String getSongName()
    {
        return songName;
    }

    /**
     * Method to set the name of the song
     * @param songName The name of the song
     * @since JMusic 1.0.0
     */
    public void setSongName(String songName)
    {
        this.songName = songName;
    }

    /**
     * Method to get the artist of the song
     * @return The artist of the song
     * @since JMusic 1.0.0
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * Method to set the name of the artist
     * @param artist The name of the artist
     * @since JMusic 1.0.0
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    /**
     * Method to get the name of the album
     * @return The name of the album
     * @since JMusic 1.0.0
     */
    public String getAlbum()
    {
        return album;
    }

    /**
     * Method to set the name of the album
     * @param album The name of the album
     * @since JMusic 1.0.0
     */
    public void setAlbum(String album)
    {
        this.album = album;
    }

    /**
     * Method to get the file name of the song in the display
     * @return The file name of the song in the display
     * @since JMusic 1.0.0
     */
    public String getSongNameForDisplay()
    {
        return songNameForDisplay;
    }

    /**
     * Method to set the name of the song in the display
     * @param songNameForDisplay The name of the song
     * @since JMusic 1.0.0
     */
    public void setSongNameForDisplay(String songNameForDisplay)
    {
        this.songNameForDisplay = songNameForDisplay;
    }

    /**
     * Method to get the file name of the artist in the display
     * @return The file name of the artist in the display
     * @since JMusic 1.0.0
     */
    public String getArtistForDisplay()
    {
        return artistForDisplay;
    }

    /**
     * Method to set the name of the artist in the display
     * @param artistForDisplay The name of the artist
     * @since JMusic 1.0.0
     */
    public void setArtistForDisplay(String artistForDisplay)
    {
        this.artistForDisplay = artistForDisplay;
    }

    /**
     * Method to get the file name of the album in the display
     * @return The file name of the album in the display
     * @since JMusic 1.0.0
     */
    public String getAlbumForDisplay()
    {
        return albumForDisplay;
    }

    /**
     * Method to set the name of the album in the display
     * @param albumForDisplay The name of the album
     * @since JMusic 1.0.0
     */
    public void setAlbumForDisplay(String albumForDisplay)
    {
        this.albumForDisplay = albumForDisplay;
    }

    /**
     * Method to create the hashcode of the objects
     * @return The hascode of the object
     * @since JMusic 1.0.0
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 53 * hash + this.numberSong;
        return hash;
    }

    /**
     * Method to compare 2 objects from the same class
     * @return The boolean with the return of the comparation
     * @since JMusic 1.0.0
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final JMusicSong other = (JMusicSong) obj;
        if (this.numberSong != other.numberSong)
        {
            return false;
        }
        return true;
    }
}
