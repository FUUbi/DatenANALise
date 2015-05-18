package org.fhnw.dataanalyse.gui;

import org.fhnw.dataanalyse.gui.toolbar.T1_Configuration;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by Vallat on 14.05.2015.
 *
 */
public class GuiApp extends JFrame{

    /*Get Dimension of the Desktop*/
    Toolkit toolkit =  Toolkit.getDefaultToolkit ();
    Dimension dim = toolkit.getScreenSize();

    // Comment for lise die m�end public si damit du zuegriff hesch vom main

    /*Panels initialisation*/
    /// das BorderLayout macht das des das frame womer ine f�end usgf�llt wird
    public JPanel toolbar1 = new JPanel(new BorderLayout());
    public JPanel toolbar2_plot = new JPanel();
    public JPanel toolbar2_histo = new JPanel();
    public JPanel plot = new JPanel();
    public JPanel histo = new JPanel(new BorderLayout());


    //public JPanel GuiApp(String panelName) {
    public GuiApp(){

    /* Frame Initialisaton*/
        setTitle("Dataanalyse");
        int height = dim.height;
        int width = dim.width;
        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


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

        /*Damit das gew�nschte Panel im Main return sei
        if (panelName.equals("toolbar1"))
        {
            return toolbar1;
        }
        else if(panelName.equals("toolbar2_plot"))
        {
            return toolbar2_plot;
        }
        else if(panelName.equals("toolbar2_histo"))
        {
            return toolbar2_histo;
        }
        */
    }



}
