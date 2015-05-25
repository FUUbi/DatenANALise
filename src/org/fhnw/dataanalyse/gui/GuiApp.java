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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by Vallat on 14.05.2015.
 *
 */

public class GuiApp extends JFrame implements ActionListener{
    private T2h_Configuration t2h_configuration;
    private T1_Configuration t1_configuration;


    public GuiApp(DataModel dataModel, HistogramManager histogramManager, ScatterPlotPanel scatterPlotPanel, String fileName) {
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
        t1_configuration = new T1_Configuration(dataModel, histogramManager, scatterPlotPanel, fileName,this);
        JPanel toolbar1 = t1_configuration.getPanel();
        c = setConstraintParameters(0, 0, 2, 1, "NORTH", 1, 0);
        distributor.setConstraints(toolbar1, c);
        surface.add(toolbar1);

        /*toolbar2 */
        JPanel toolbar2 = new JPanel(new GridLayout(0, 2));
        c = setConstraintParameters(0, 1, 2, 1, "NORTH", 1, 0);
        distributor.setConstraints(toolbar2, c);
        surface.add(toolbar2);

        t2h_configuration = new T2h_Configuration(dataModel, histogramManager);

        JPanel toolbar2_left = new T2sp_Configuration(dataModel, scatterPlotPanel);
        JPanel toolbar2_right = t2h_configuration.getPanel();
        toolbar2.add(toolbar2_left);
        toolbar2.add(toolbar2_right);

        /*ScatterPlot */
        JPanel  splot = scatterPlotPanel.getScatterPlotContent();
        c = setConstraintParameters(0, 2, 1, 100, "SOUTH", 1, 1);
        distributor.setConstraints(splot, c);
        surface.add(splot);
        //splot.setBackground(Color.orange);

        /*histogramm Layout*/
        JPanel histo = histogramManager.getDrawHisto1();
        c = setConstraintParameters(1, 2, 1, 100, "SOUTH", 1, 1);
        distributor.setConstraints(histo, c);
        surface.add(histo);

        setVisible(true);

        while (true) {
            repaint();
        }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ComboBox1")){
            int index = t1_configuration.getxAxisIndex();
            t2h_configuration.updateHisto1(index);
        }

        if(e.getActionCommand().equals("ComboBox2")){
            int index = t1_configuration.getyAxisIndex();
            t2h_configuration.updateHisto2(index);
        }
    }
}
