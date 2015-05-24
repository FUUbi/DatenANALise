package org.fhnw.dataanalyse.gui;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.gui.histogram.HistogramManager;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;
import org.fhnw.dataanalyse.gui.toolbar.T1_Configuration;
import org.fhnw.dataanalyse.gui.toolbar.T2h_Configuration;
import org.fhnw.dataanalyse.gui.toolbar.T2sp_Configuration;

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
    Toolkit toolkit =  Toolkit.getDefaultToolkit();
    Dimension dim = toolkit.getScreenSize();

    /*Panels initialisation*/

    JPanel toolbar2 = new JPanel(new GridLayout(0,2));
    JPanel toolbar2_left = new JPanel();
    JPanel toolbar2_right = new JPanel();
    JPanel splot = new JPanel(new BorderLayout());
    JPanel histo = new JPanel(new BorderLayout());

    T1_Configuration tb1content;
    T2sp_Configuration tb2LeftContent;

    public GuiApp(DataModel dataModel, HistogramManager histogramManager, ScatterPlotPanel scatterPlotPanel){

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
        JPanel toolbar1 =  new T1_Configuration(dataModel, histogramManager, scatterPlotPanel);
        c = setConstraintParameters(0,0,2,1,"NORTH",1,0);
        distributor.setConstraints(toolbar1, c);
        surface.add(toolbar1);
        toolbar1.setBackground(Color.blue);

        /*toolbar2 */
        c = setConstraintParameters(0,1,2,1,"NORTH",1,0);
        distributor.setConstraints(toolbar2, c);
        surface.add(toolbar2);
        toolbar2.setBackground(Color.darkGray);

        toolbar2_left = new T2sp_Configuration(dataModel,scatterPlotPanel);
        toolbar2_right = new T2h_Configuration(histogramManager,scatterPlotPanel);
        toolbar2.add(toolbar2_left);
        toolbar2.add(toolbar2_right);



        /*PlotingArea layout*/

        /*ScatterPlot Layout*/
        splot = scatterPlotPanel.getScatterPlotContent();
        c = setConstraintParameters(0,2,1,100,"CENTER",1,1);
        distributor.setConstraints(splot, c);
        surface.add(splot);
        //splot.setBackground(Color.orange);

        /*histogramm Layout*/
        histo = histogramManager.getDrawHisto1();
        c = setConstraintParameters(1,2,1,100,"SOUTH",1,1);
        distributor.setConstraints(histo, c);
        surface.add(histo);


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
        if (gridheight == 100)
        {
            c.gridheight = GridBagConstraints.REMAINDER;
        }
        else
        {
            c.gridheight = gridheight;
        }


        c.fill = GridBagConstraints.BOTH;

        if (position.equals("NORTH") || position.equals("north"))
        {
            c.anchor = GridBagConstraints.NORTH;
        }

        else if (position.equals("SOUTH" ) || position.equals("south"))
        {
            c.anchor = GridBagConstraints.SOUTH;
        }
        else if (position.equals("WEST") || position.equals("west"))
        {
            c.anchor = GridBagConstraints.WEST;
        }
        else if (position.equals("EAST") || position.equals("east"))
        {
            c.anchor = GridBagConstraints.EAST;
        }

        c.weightx = weigthx;
        c.weighty = weighty;

        return c;
    }

    public JPanel getToolbar2 ()
    {
        return toolbar2;
    }

    public JPanel getToolbar2Left ()
    {
        return toolbar2_left;
    }

    public JPanel getPlot() {
        return splot;
    }

    public JPanel getHisto() {
        return  histo;
    }



}
