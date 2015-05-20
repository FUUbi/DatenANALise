package org.fhnw.dataanalyse.gui.scatterplot;

import org.fhnw.dataanalyse.datamodell.Variable;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Sven on 17.05.2015.
 */
public class ScatterPlotPanel extends JPanel {

    public ScatterPlotPanel(ArrayList<Variable> v) {

        for (int index = 1; index < v.size(); index++)
        {
            ArrayList<Float> x = v.get(index-1).getData();
            ArrayList<Float> y = v.get(index).getData();

            ScatterPlotContent scatterPanel = new ScatterPlotContent(x,y);
            setLayout(new BorderLayout());
            add(scatterPanel);
        }
    }
}