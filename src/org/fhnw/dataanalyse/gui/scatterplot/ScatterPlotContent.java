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
    private final Float maxX;
    private final Float maxY;
    private final Float minY;

    public ScatterPlotContent(ArrayList<Float> x, ArrayList<Float> y, Float maxX, Float maxY, Float minY) {
        this.x = x;
        this.y = y;
        this.maxX = maxX;
        this.maxY = maxY;
        this.minY = minY;
    }

    boolean drawLine = true;


    @Override
    protected void paintComponent(Graphics g) {
    int distance = getWidth()/x.size();
        for (int i = 1; i < x.size(); i++) {
            double valueX1 = x.get(i-1);
            double valueY1 = y.get(i-1);
            double valueX2 = x.get(i);
            double valueY2 = y.get(i);

            /*Initialiserung der Koordinatenwerte*/
            int a = (int) ((valueX1/maxX)*getWidth()/1.25);
            int b = (int) ((valueY1/maxY)*getHeight()/1.25);
            b = (getHeight() - b);
            int c = (int) ((valueX2/maxX)*getWidth()/1.25);
            int d = (int) ((valueY2/maxY)*getHeight()/1.25);
            d = (getHeight() - d);

            //de wert muess verändert werde, wenn me e slider für d grössi vo de pünkt macht
            int diameter = 10;

            g.setColor(Color.ORANGE);
            g.fillOval(a, b, diameter, diameter);

            if(i==x.size()-1)
            {
                g.setColor(Color.ORANGE);
                g.fillOval(c,d,diameter,diameter);
            }

            if (drawLine)
            {
                g.setColor(Color.black);
                g.drawLine(a + diameter / 2, b + diameter / 2, c + diameter / 2, d + diameter / 2);
            }
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
            System.out.println(getWidth());
        }
    }
}
