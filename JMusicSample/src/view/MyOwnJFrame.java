package view;

import javax.swing.JFrame;

/**
 * Class to create a custom JFrame
 * @author Ricardo Casanova
 * @version 1.0.0
 */
public class MyOwnJFrame extends JFrame
{
    private JFrame  fatherWindow;
    private boolean isFatherWindowHide;
    private boolean isFatherWindowDisable;
    
    /**
     * Method to get the father window from this
     * @return The father window from this
     */
    public JFrame getFatherWindow()
    {
        return fatherWindow;
    }

    /**
     * Method to set the father window from this
     * @param fatherWindow The father window from this
     * @param hideFatherWindow Boolean to determinate if we must hide the father window or not
     */
    public void setFatherWindow(JFrame fatherWindow, boolean hideFatherWindow)
    {
        this.fatherWindow = fatherWindow;
        
        if (hideFatherWindow)
        {
            this.fatherWindow.setVisible(false); 
            this.isFatherWindowHide = true;
            this.isFatherWindowDisable = false;
        }
        else
        {
            this.fatherWindow.setEnabled(false);
            this.setAlwaysOnTop(true);
            this.isFatherWindowHide = false;
            this.isFatherWindowDisable = true;
        }
    }
    
    /**
     * Method to restore the father window from this
     */
    public void restoreFatherWindow()
    {
        if (this.isFatherWindowHide)
            this.fatherWindow.setVisible(true);
        
        if (this.isFatherWindowDisable)
            this.fatherWindow.setEnabled(true);
        
        this.dispose();
    }
    
    /**
     * Method to set the enable window property
     * @param setEnable Boolean to set the property
     */
    public void setEnableWindow(boolean setEnable)
    {
        this.setEnabled(setEnable);
        this.setAlwaysOnTop(true);       
    }
}