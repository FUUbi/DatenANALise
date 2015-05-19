package org.fhnw.dataanalyse.gui.scatterplot;

import org.fhnw.dataanalyse.datamodell.Variable;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Sven on 17.05.2015.
 */
public class ScatterPlotPanel extends JPanel {

    private static int index = 1;

    public ScatterPlotPanel(ArrayList<Variable> v) {

        ArrayList<Float> x = v.get(index).getData();

        ScatterPlotContent scatterPanel = new ScatterPlotContent(x);
        setLayout(new BorderLayout());
        add(scatterPanel);
    }

}