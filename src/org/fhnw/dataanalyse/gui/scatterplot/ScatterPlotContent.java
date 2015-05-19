package org.fhnw.dataanalyse.gui.scatterplot;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by Sven on 17.05.2015.
 */
public class ScatterPlotContent extends JPanel {

    private final ArrayList<Float> x;

    public ScatterPlotContent(ArrayList<Float> x) {
        this.x = x;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int distance = getWidth() / x.size();
        for (int i = 0; i < x.size(); i++) {
            double value = x.get(i);
            //int barHeight = (int) (value / 100 * getHeight());

            int x = i * distance;
            int y = (int) value;

            int diameter = 10;


            g.setColor(Color.ORANGE);
            g.fillOval(x, y, diameter, diameter);
            g.setColor(Color.YELLOW);
            g.drawOval(x, y, diameter, diameter);

        }
    }

}
