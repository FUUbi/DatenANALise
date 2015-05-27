package org.fhnw.dataanalyse.gui.scatterplot;

import org.fhnw.dataanalyse.scatterplotdata.ScatterValues;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by Sven on 17.05.2015.
 */
public class ScatterPlotContent extends JPanel {

    private float minX;
    private float maxX;
    private float minY;
    private float maxY;
    private ArrayList<Float> x;
    private ArrayList<Float> y;
    private ArrayList<Float> diameterValues;
    boolean drawLine;
    Color  color = Color.ORANGE;
    private int sliderDiameter;
    private boolean relativeSize;


    public ScatterPlotContent() {
        setBorder(BorderFactory.createTitledBorder("Scatter Plot"));
    }

    public void setScatterPlotContent(float minX, float maxX, float minY, float maxY,
                                      ArrayList<Float> index1Values, ArrayList<Float> index2Values,
                                      ArrayList<Float> index3Values, boolean checked, int sliderValue, boolean relativeSize) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.x = index1Values;
        this.y = index2Values;
        this.diameterValues = index3Values;
        this.drawLine = checked;
        this.sliderDiameter = sliderValue;
        this.relativeSize = relativeSize;
        revalidate();
        repaint();
    }




    public void setColor(Color color) {
        this.color = color;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
    //int distance = getWidth()/x.size();
        for (int i = 1; i < x.size(); i++) {
            double valueX1 = x.get(i-1);
            double valueY1 = y.get(i-1);
            double valueX2 = x.get(i);
            double valueY2 = y.get(i);
            int diameter;

            if(relativeSize){
                double diameterVal = diameterValues.get(i);
                diameter = (int) diameterVal/100;
            }
            else{
                diameter = sliderDiameter;
            }

            /*Initialiserung der Koordinatenwerte*/
            int a = (int) ((valueX1-minX)/(maxX-minX)*getWidth());
            a -= 50;
            /*int a = (int) ((valueX1/maxX)*getWidth()/1.25);*/
            int b = (int) ((valueY1-minY)/(maxY-minY)*getHeight());
            /*int b = (int) ((valueY1/maxY)*getHeight()/1.25);*/
            b = (getHeight() - b);
            b += 50;
            //int c = (int) ((valueX2/maxX)*getWidth()/1.25);
            int c = (int) ((valueX2-minX)/(maxX-minX)*getWidth());
            c -= 50;
            int d = (int) ((valueY2-minY)/(maxY-minY)*getHeight());
            d = (getHeight() - d);
            d += 50;

            g.setColor(color);
            g.fillOval(a, b, diameter, diameter);

            if(i==x.size()-1) {
                g.setColor(color);
                g.fillOval(c, d, diameter, diameter);
            }

            if (drawLine) {
                g.setColor(Color.black);
                g.drawLine(a + diameter / 2, b + diameter / 2, c + diameter / 2, d + diameter / 2);
            }
        }
    }
}
