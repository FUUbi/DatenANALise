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
    private final ArrayList<Float> y;

    public ScatterPlotContent(ArrayList<Float> x, ArrayList<Float> y) {
        this.x = x;
        this.y = y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i < x.size(); i++) {
            double valueX = x.get(i);
            double valueY = y.get(i);

            int x = (int) valueX;
            int y = (int) (getHeight()-valueY);

            //de wert muess ver�ndert werde, wenn me e slider f�r d gr�ssi vo de p�nkt macht
            int diameter = 10;

            g.setColor(Color.ORANGE);
            g.fillOval(x, y, diameter, diameter);
            g.setColor(Color.YELLOW);
            g.drawOval(x, y, diameter, diameter);

        }
    }

}
