package org.fhnw.dataanalyse.gui.toolbar;

import javax.swing.*;

/**
 * Created by Vallat on 16.05.2015.
 */
public class T1_Configuration extends JPanel {

    public JPanel T1Config()

    {
        JPanel toolbar1Content = new JPanel();
        JButton loadFileButton = new JButton("Load File");
        toolbar1Content.add(loadFileButton);


        return toolbar1Content;
    }


}
