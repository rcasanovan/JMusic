package jmusic.player.view.components;

import java.util.Objects;
import javax.swing.JList;

/**
 * Class to create a custom JList
 * @author Ricardo Casanova
 * @version 1.0.0
 * @since JMusic 1.0.0
 */
public class JMusicList extends JList
{
    private String  artistName;
    private String  albumName;
    private JList   jLLastPlayedSongList;
    private int     rowInJTable;

    /**
     * Class constructor
     * @param artistName The artist name
     * @param albumName The album name
     * @param rowInJTable The row in the JTable
     * @since JMusic 1.0.0
     */
    public JMusicList(String artistName, String albumName, int rowInJTable)
    {
        super();
        this.artistName = artistName;
        this.albumName = albumName;
        this.rowInJTable = rowInJTable;
        this.jLLastPlayedSongList = null;
    }
    
    /**
     * Class constructor
     * @param artistName The artist name
     * @param albumName The album name
     * @param rowInJTable The row in the JTable
     * @param jLLastPlayedSongList The JList with the last played song information
     * @since JMusic 1.0.0
     */
    public JMusicList(String artistName, String albumName, int rowInJTable, JList jLLastPlayedSongList)
    {
        super();
        this.artistName = artistName;
        this.albumName = albumName;
        this.rowInJTable = rowInJTable;
        this.jLLastPlayedSongList = jLLastPlayedSongList;
    }

    /**
     * Method to get the artist name
     * @return The artist name
     * @since JMusic 1.0.0
     */
    public String getArtistName()
    {
        return artistName;
    }

    /**
     * Method to get the album name
     * @return The album name
     * @since JMusic 1.0.0
     */
    public String getAlbumName()
    {
        return albumName;
    }

    /**
     * Method to get the row in the JTable
     * @return The row in the JTable
     * @since JMusic 1.0.0
     */
    public int getRowInJTable()
    {
        return rowInJTable;
    }

    /**
     * Method to get the last played song list
     * @return The last played song list
     * @since JMusic 1.0.0
     */
    public JList getjLLastPlayedSongList()
    {
        return jLLastPlayedSongList;
    }

    /**
     * Method to generate the object hash code
     * @return The hash code
     * @since JMusic 1.0.0
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.artistName);
        hash = 71 * hash + Objects.hashCode(this.albumName);
        return hash;
    }

    /**
     * Method to determinate when a JMusicList object is equal to another
     * @return The return of the comparation
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
        final JMusicList other = (JMusicList) obj;
        if (!Objects.equals(this.artistName, other.artistName))
        {
            return false;
        }
        if (!Objects.equals(this.albumName, other.albumName))
        {
            return false;
        }
        return true;
    }
}
