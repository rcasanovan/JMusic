package jmusic.player.view;

import jmusic.player.controller.AboutWindowViewController;

/**
 * About window class for the JMusic player
 * @author Ricardo Casanova
 * @version 1.0.1
 * @since JMusic 1.0.0
 */
public final class AboutWindow extends MyOwnJFrame
{

    /**
     * Creates new form AboutWindow
     */
    public AboutWindow()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLMacLogo = new javax.swing.JLabel();
        jLTittle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAMacInfo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAAbout = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLMacLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jmusic/player/view/images/macLogo.jpg"))); // NOI18N
        jLMacLogo.setSize(new java.awt.Dimension(50, 66));
        getContentPane().add(jLMacLogo);
        jLMacLogo.setBounds(10, 210, 50, 66);

        jLTittle.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLTittle.setText("jMusic Player 1.0.0");
        getContentPane().add(jLTittle);
        jLTittle.setBounds(10, 10, 190, 30);

        jTAMacInfo.setColumns(20);
        jTAMacInfo.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jTAMacInfo.setRows(5);
        jTAMacInfo.setText("jMusic Player was developed for\nMac OS X Lion with JDK 1.8.\nNo guarantees to maintain the appearance\nof components in other operating systems.");
        jTAMacInfo.setFocusable(false);
        jScrollPane1.setViewportView(jTAMacInfo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 210, 220, 70);

        jTAAbout.setColumns(20);
        jTAAbout.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jTAAbout.setRows(5);
        jTAAbout.setText("JMusic Player 1.0.0 is based on JMusic© Library 1.0.0\nJMusic© is based on JLayer open source project (v1.0.1)\n\nTM and © 2016 Ricardo Casanova N.\nAll rights reserved\n\nDeveloper:\nEnginner Ricardo Casanova N.\nWeb Page: www.ricardocasanova.m\nEmail: ricardo.casanova@outlook.com\nTwitter: @rcasanovan");
        jTAAbout.setFocusable(false);
        jScrollPane2.setViewportView(jTAAbout);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 50, 280, 150);

        setSize(new java.awt.Dimension(301, 312));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        AboutWindowViewController.returnToTheFatherWindowFromHere(this);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(AboutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(AboutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(AboutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(AboutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new AboutWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLMacLogo;
    private javax.swing.JLabel jLTittle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAAbout;
    private javax.swing.JTextArea jTAMacInfo;
    // End of variables declaration//GEN-END:variables
}