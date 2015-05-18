package org.fhnw.dataanalyse.gui.scatterplot;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by Sven on 17.05.2015.
 */
public class ScatterPlotContent extends JPanel {

    private final java.util.List<Integer> values;

    public ScatterPlotContent(java.util.List<Integer> values) {
        this.values = values;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int distance = getWidth() / values.size();
        for (int i = 0; i < values.size(); i++) {
            double value = values.get(i);
            int barHeight = (int) (value / 100 * getHeight());

            int x = i * distance;
            int y = getHeight() - barHeight;

            int diameter = 10;


            g.setColor(Color.ORANGE);
            g.fillOval(x, y, diameter, diameter);
            g.setColor(Color.YELLOW);
            g.drawOval(x, y, diameter, diameter);

            System.out.println(getWidth());
        }
    }

}
