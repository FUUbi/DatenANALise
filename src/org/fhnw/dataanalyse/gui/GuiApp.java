package org.fhnw.dataanalyse.gui;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.gui.histogram.HistogramManager;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;
import org.fhnw.dataanalyse.gui.toolbar.T1_Configuration;
import org.fhnw.dataanalyse.gui.toolbar.T2h_Configuration;
import org.fhnw.dataanalyse.gui.toolbar.T2sp_Configuration;

import java.awt.*;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;

/**
 * Created by Vallat on 14.05.2015.
 *
 */

public class GuiApp extends JFrame {
    private T2h_Configuration t2h_configuration;
    private T1_Configuration t1_configuration;
    private HistogramManager histogramManager;
    private ScatterPlotPanel scatterPlotPanel;
    private String fileName;

    /*Panels initialisation*/

    public GuiApp(DataModel dataModel, HistogramManager histogramManager, ScatterPlotPanel scatterPlotPanel, String fileName) {
        this.histogramManager = histogramManager;
        this.scatterPlotPanel = scatterPlotPanel;
        this.fileName = fileName;

        /*Get Dimension of the Desktop*/
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();

        /* Frame Initialisaton*/
        setTitle("Dataanalyse File: ");
        int height = dim.height;
        int width = dim.width;
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         /*Layout*/
        GridBagLayout distributor = new GridBagLayout();
        GridBagConstraints c;
        Container surface = getContentPane();
        surface.setLayout(distributor);

        /*toolbar1 layout */
        t1_configuration = new T1_Configuration(dataModel, histogramManager, scatterPlotPanel, fileName, this);
        JPanel toolbar1 = t1_configuration.getPanel();
        c = setConstraintParameters(0, 0, 2, 1, "NORTH", 1, 0);
        distributor.setConstraints(toolbar1, c);
        surface.add(toolbar1);

        /*toolbar2 */
        JPanel toolbar2 = new JPanel(new GridLayout(0, 2));
        c = setConstraintParameters(0, 1, 2, 1, "NORTH", 1, 0);
        distributor.setConstraints(toolbar2, c);
        surface.add(toolbar2);

        t2h_configuration = new T2h_Configuration(dataModel, this);

        JPanel toolbar2_left = new T2sp_Configuration(dataModel, this);
        JPanel toolbar2_right = t2h_configuration.getPanel();
        toolbar2.add(toolbar2_left);
        toolbar2.add(toolbar2_right);


        JPanel  plotArea = new JPanel(new BorderLayout());
        c = setConstraintParameters(0, 2, 2, 100, "SOUTH", 1, 1);
        distributor.setConstraints(plotArea, c);
        surface.add(plotArea);


        JPanel plotContent = new JPanel();
        plotContent.setLayout(new BoxLayout(plotContent,BoxLayout.X_AXIS));

        plotContent.add(scatterPlotPanel.getScatterPlotContent());
        plotContent.add(histogramManager);

        plotArea.add(plotContent);

        setVisible(true);
        repaint();

    }


    /**
     * return Constraints Parameters
     */
    public GridBagConstraints setConstraintParameters(int gridx, int gridy, int gridwidth, int gridheight, String position, int weigthx, int weighty) {

        GridBagConstraints c;

        c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        if (gridheight == 100) {
            c.gridheight = GridBagConstraints.REMAINDER;
        } else {
            c.gridheight = gridheight;
        }


        c.fill = GridBagConstraints.BOTH;

        if (position.equals("NORTH") || position.equals("north")) {
            c.anchor = GridBagConstraints.NORTH;
        } else if (position.equals("SOUTH") || position.equals("south")) {
            c.anchor = GridBagConstraints.SOUTH;
        } else if (position.equals("WEST") || position.equals("west")) {
            c.anchor = GridBagConstraints.WEST;
        } else if (position.equals("EAST") || position.equals("east")) {
            c.anchor = GridBagConstraints.EAST;
        }

        c.weightx = weigthx;
        c.weighty = weighty;

        return c;
    }


    public T1_Configuration getT1_configuration() {
        return t1_configuration;
    }

    public T2h_Configuration getT2h_configuration() {
        return t2h_configuration;
    }

    public HistogramManager getHistogramManager() {
        return histogramManager;
    }

    public ScatterPlotPanel getScatterPlotPanel() {
        return scatterPlotPanel;
    }


    public String getFileName() {
        return fileName;
    }

}

