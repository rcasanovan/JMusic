package jmusic.player.controller;

import jmusic.player.view.MyOwnJFrame;

/**
 * View controller class for the About window
 * @author Ricardo Casanova
 * @version 1.0.0
 * @since JMusic 1.0.0
 */
public final class AboutWindowViewController
{
    /**
     * Method to return to the father window from here
     * @param here The "from" JFrame
     * @since JMusic 1.0.0
     */
    public static void returnToTheFatherWindowFromHere(MyOwnJFrame here)
    {
        here.restoreFatherWindow();
    }
}
