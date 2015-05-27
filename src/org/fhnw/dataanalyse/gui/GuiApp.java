package org.fhnw.dataanalyse.gui;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.gui.histogram.HistogramManager;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;
import org.fhnw.dataanalyse.gui.toolbar.MenuToolbar;
import org.fhnw.dataanalyse.gui.toolbar.HistoToolbar;
import org.fhnw.dataanalyse.gui.toolbar.ScatterPlotToolbar;

import java.awt.*;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;


/**
 * GuiApp defines the main frame for the Programm's GUI
 * blabla --- i wart jez uf euch 2 ! =P
 *
 */

public class GuiApp extends JFrame {
    private HistoToolbar histoToolbar;
    private MenuToolbar menuToolbar;
    private HistogramManager histogramManager;
    private ScatterPlotPanel scatterPlotPanel;
    private String fileName;


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

        /*menuToolbar Layout */
        menuToolbar = new MenuToolbar(dataModel, histogramManager, scatterPlotPanel, fileName, this);
        JPanel toolbar1 = menuToolbar.getPanel();
        c = setConstraintParameters(0, 0, 2, 1, "NORTH", 1, 0);
        distributor.setConstraints(toolbar1, c);
        surface.add(toolbar1);


        /*plotingToolbar Layout */
        JPanel toolbar2 = new JPanel(new GridLayout(0, 2));
        c = setConstraintParameters(0, 1, 2, 1, "NORTH", 1, 0);
        distributor.setConstraints(toolbar2, c);
        surface.add(toolbar2);


        JPanel toolbar2_left = new ScatterPlotToolbar(dataModel, this);
        histoToolbar = new HistoToolbar(dataModel, this);
        JPanel toolbar2_right = histoToolbar.getPanel();
        toolbar2.add(toolbar2_left);
        toolbar2.add(toolbar2_right);


        /*plotingArea Layout*/
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
     *
     *
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

/*                                                                                <------------ //ok be vllt blöd abr ich schaff ke switch wege dene equals scheiss...*/
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


    public MenuToolbar getMenuToolbar() {
        return menuToolbar;
    }

    public HistoToolbar getHistoToolbar() {
        return histoToolbar;
    }

    public HistogramManager getHistogramManager() {
        return histogramManager;
    }

    public ScatterPlotPanel getScatterPlotPanel() {
        return scatterPlotPanel;
    }


}

