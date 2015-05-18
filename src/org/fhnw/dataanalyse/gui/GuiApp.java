package org.fhnw.dataanalyse.gui;

import com.sun.deploy.security.MozillaJSSDSASignature;

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


    /*Panels initialisation*/
    public JPanel toolbar1 = new JPanel(new BorderLayout());
    public JPanel toolbar2_plot = new JPanel(new BorderLayout());
    public JPanel toolbar2_histo = new JPanel(new BorderLayout());
    public JPanel plot = new JPanel(new BorderLayout());
    public JPanel histo = new JPanel(new BorderLayout());


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
        c = setConstraintParameters(0,0,2,1,"NORTH",0,1);
        distributor.setConstraints(toolbar1, c);
        surface.add(toolbar1);
        toolbar1.setBackground(Color.blue);


        /*toolbar2 layout*/
        c = setConstraintParameters(0,1,1,1,"NORTH",0,1);
        distributor.setConstraints(toolbar2_plot, c);
        surface.add(toolbar2_plot);
        toolbar2_plot.setBackground(Color.darkGray);

        /*toolbar2_histo Layout*/
        c = setConstraintParameters(1,1,1,1,"NORTH",0,1);
        distributor.setConstraints(toolbar2_histo, c);
        surface.add(toolbar2_histo);
        toolbar2_histo.setBackground(Color.GRAY);


        /*PlotingArea layout*/

        /*ScatterPlot Layout*/
        c = setConstraintParameters(0,2,1,0,"SOUTH",1,10);
        distributor.setConstraints(plot, c);
        surface.add(plot);
        plot.setBackground(Color.orange);

        /*histogramm Layout*/
        c = setConstraintParameters(1,2,1,0,"SOUTH",1,10);
        distributor.setConstraints(histo, c);
        surface.add(histo);
        histo.setBackground(Color.cyan);


        setVisible(true);
    }


    /**
     * return Constraints Parameters
     */
    public GridBagConstraints setConstraintParameters(int gridx, int gridy, int gridwidth,int gridheight, String position, int weigthx, int weighty)
    {

        GridBagConstraints c;

        c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.fill = GridBagConstraints.BOTH;

        if (position.equals("NORTH") || position.equals("north"))
        {
            c.anchor = GridBagConstraints.NORTH;
        }

        else if (position.equals("SOUTH" ) || position.equals("south"))
        {
            c.anchor = GridBagConstraints.SOUTH;
        }

        c.weightx = weigthx;
        c.weighty = weighty;

        return c;
    }

}
