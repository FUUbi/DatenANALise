package org.fhnw.dataanalyse.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

/**
 * Created by Vallat on 14.05.2015.
 *
 */
public class GuiApp extends JFrame{

    /*Get Dimension of the Desktop*/
    Toolkit toolkit =  Toolkit.getDefaultToolkit ();
    Dimension dim = toolkit.getScreenSize();



    public GuiApp() {

    /* Frame Initialisaton*/
        setTitle("Dataanalyse");
        int height = dim.height;
        int width = dim.width;
        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JPanel toolbar1 = new JPanel();
        JPanel toolbar2_plot = new JPanel();
        JPanel toolbar2_histo = new JPanel();
        JPanel plot = new JPanel();
        JPanel histo = new JPanel();

    /*Layout*/
        GridBagLayout distributor = new GridBagLayout();
        GridBagConstraints c;
        Container surface = getContentPane();

        surface.setLayout(distributor);
        /*toolbar1 layout */

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.weightx =1;
        c.weighty =1;
        distributor.setConstraints(toolbar1, c);
        surface.add(toolbar1);
        toolbar1.setBackground(Color.blue);

        /*toolbar2 layout*/

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 1;
        c.weighty = 1;
        distributor.setConstraints(toolbar2_plot, c);
        surface.add(toolbar2_plot);
        toolbar2_plot.setBackground(Color.darkGray);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 1;
        c.weighty = 1;
        distributor.setConstraints(toolbar2_histo, c);
        surface.add(toolbar2_histo);
        toolbar2_histo.setBackground(Color.GRAY);




        /*PlotingArea layout*/
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.SOUTH;
        c.weightx = 1;
        c.weighty = 10;
        distributor.setConstraints(plot, c);
        surface.add(plot);
        plot.setBackground(Color.orange);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.SOUTH;
        c.weightx = 1;
        c.weighty = 10;
        distributor.setConstraints(histo, c);
        surface.add(histo);
        histo.setBackground(Color.yellow);


        setVisible(true);
    }

}
