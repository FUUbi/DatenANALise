package org.fhnw.dataanalyse.gui.scatterplot;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Sven on 17.05.2015.
 */
public class ScatterPlotPanel extends JPanel {

    public ScatterPlotPanel() {
        java.util.List<Integer> values = Arrays.asList(20, 33, 60, 10);
        ScatterPlotContent scatterPanel = new ScatterPlotContent(values);
        setLayout(new BorderLayout());
        add(scatterPanel);
    }

}