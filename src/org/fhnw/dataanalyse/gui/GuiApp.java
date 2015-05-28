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
 * GuiApp Class contains the GuiApp Method
 * GuiApp Class conains also setGridBagConstraints,getMenuToolbar(), getHistoToolbar(),
 * getHistogramManager(), getScatterPlotPanel()
 */

public class GuiApp extends JFrame {

    private MenuToolbar menuToolbar;
    private HistoToolbar histoToolbar;
    private HistogramManager histogramManager;
    private ScatterPlotPanel scatterPlotPanel;
    private String fileName;

    /**
     * GuiApp defines the main frame of the GUI and create all the required panels
     * Each Panel receive its content which have been defined in another Class
     * @param dataModel
     * @param histogramManager
     * @param scatterPlotPanel
     * @param fileName
     */
    public GuiApp(DataModel dataModel, HistogramManager histogramManager, ScatterPlotPanel scatterPlotPanel, String fileName) {
        this.histogramManager = histogramManager;
        this.scatterPlotPanel = scatterPlotPanel;
        this.fileName = fileName;

        /*Get Dimension of the Desktop*/
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();

        /* Frame Initialisaton*/
        setTitle("Dataanalyse");
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
        JPanel  plotArea = new JPanel();
        plotArea.setLayout(new BoxLayout(plotArea,BoxLayout.X_AXIS));
        c = setConstraintParameters(0, 2, 2, 100, "SOUTH", 1, 1);
        distributor.setConstraints(plotArea, c);
        surface.add(plotArea);

        plotArea.add(scatterPlotPanel.getScatterPlotContent());
        plotArea.add(histogramManager);


        setVisible(true);
        repaint();

    }

    public GridBagConstraints setConstraintParameters(int gridx, int gridy, int gridwidth, int gridheight, String position, int weigthx, int weighty) {

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;

        if (gridheight == 100) {
            c.gridheight = GridBagConstraints.REMAINDER;
        } else {
            c.gridheight = gridheight;
        }

        c.fill = GridBagConstraints.BOTH;

        switch (c.anchor){
            case 1: position.equals("NORTH");
                c.anchor = GridBagConstraints.NORTH;
                break;

            case 2: position.equals("SOUTH");
                c.anchor = GridBagConstraints.SOUTH;
                break;

            case 3: position.equals("WEST");
                c.anchor = GridBagConstraints.WEST;
                break;

            case 4: position.equals("EAST");
                c.anchor = GridBagConstraints.EAST;
                break;
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

