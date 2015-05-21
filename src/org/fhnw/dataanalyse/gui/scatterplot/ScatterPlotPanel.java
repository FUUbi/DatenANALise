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

            Float maxX = (float)0.0;
            for (Float f : x) if (f.compareTo(maxX) == 1) maxX = f;
            Float maxY = (float)0.0;
            for (Float f : y) if (f.compareTo(maxY) == 1) maxY = f;
            Float minY = (float)0.0;
            for (Float f : y) if (f.compareTo(minY) == 1) minY = f;


            ScatterPlotContent scatterPanel = new ScatterPlotContent(x,y,maxX,maxY,minY);
            setLayout(new BorderLayout());
            add(scatterPanel);
        }
    }

    public void updateScatterPlot (ArrayList<Variable> v){
        for (int index = 1; index < v.size(); index++)
        {
            ArrayList<Float> x = v.get(index-1).getData();
            ArrayList<Float> y = v.get(index).getData();

            Float maxX = (float)0.0;
            for (Float f : x) if (f.compareTo(maxX) == 1) maxX = f;
            Float maxY = (float)0.0;
            for (Float f : y) if (f.compareTo(maxY) == 1) maxY = f;
            Float minY = (float)0.0;
            for (Float f : y) if (f.compareTo(minY) == 1) minY = f;


            ScatterPlotContent scatterPanel = new ScatterPlotContent(x,y,maxX,maxY,minY);
            setLayout(new BorderLayout());
            add(scatterPanel);
        }
    }
}