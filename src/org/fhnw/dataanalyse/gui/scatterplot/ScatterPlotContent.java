package org.fhnw.dataanalyse.gui.scatterplot;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.*;

/**
 * ScatterPlotContent provides a Panel which contains all Element too show a ScatterPlot
 * ScatterPlotContent contains setScatterPlotContent Method, setColor Method and paintComponent Method
 */
public class ScatterPlotContent extends JPanel {

    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private ArrayList<Double> xData;
    private ArrayList<Integer> xCord = null;
    private ArrayList<Double> yData;
    private ArrayList<Integer> yCord = null;
    private ArrayList<Double> diameterRaw;
    private ArrayList<Integer> diameterValues;
    boolean drawLine;
    private int sliderDiameter;
    private boolean relativeSize;
    private Color bgColor = Color.white;


    Color  color = Color.ORANGE;

    public ScatterPlotContent() {
        setBorder(BorderFactory.createTitledBorder("Scatter Plot"));
        setBackground(bgColor);
    }

    public void setScatterPlotContent(double minX, double maxX, double minY, double maxY,
                                      ArrayList<Double> index1Values, ArrayList<Double> index2Values,
                                      ArrayList<Double> index3Values, boolean checked, int sliderValue, boolean relativeSize) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.xData = index1Values;
        this.yData = index2Values;
        this.diameterRaw = index3Values;
        this.drawLine = checked;
        this.sliderDiameter = sliderValue;
        this.relativeSize = relativeSize;
        revalidate();  /* ensures the dynamism of the ScatterPlot on the GUI */
        repaint();
    }


    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        setXCord();
        setYCord();
        setDiameterValues();
        for (int i = 0; i < xCord.size(); i++) {
            int valueX1 = xCord.get(i);
            int valueY1 = yCord.get(i);
            int diameter = diameterValues.get(i);

            /*if(relativeSize){

            }
            else{diameter = sliderDiameter;}*/



            /* Initialisation of values' coordinate */
            int a = valueX1;
            a -= (diameter / 2);

            int b = valueY1;
            b = (getHeight() - b);
            b += (diameter / 2);


            g.setColor(color);
            g.fillOval(a, b, diameter, diameter);

        }
        for (int i = 1; i < xCord.size(); i++) {
            if (drawLine) {
                int valueX1 = xCord.get(i - 1);
                int valueY1 = yCord.get(i - 1);
                int valueX2 = xCord.get(i);
                int valueY2 = yCord.get(i);
                int diameter = 5;

            /*if(relativeSize){

            }
            else{diameter = sliderDiameter;}*/



            /* Initialisation of values' coordinate */
                int a = valueX1;
                a -= (diameter / 2);

                int b = valueY1;
                b = (getHeight() - b);
                b += (diameter / 2);

                int c = valueX2;
                c -= (diameter / 2);

                int d = valueY2;
                d = (getHeight() - d);
                d += (diameter / 2);
                g.setColor(Color.black);
                g.drawLine(a + diameter / 2, b + diameter / 2, c + diameter / 2, d + diameter / 2);
            }
        }
    }

    public void setXCord() {
        for (int i = 0; i < xData.size(); i++) {
            double xVal = xData.get(i);
            int x = (int) ((xVal-minX)/(maxX-minX)*getWidth());
            xCord.add(x);
        }
    }

    public void setYCord(){
        for (int i = 0; i < yData.size(); i++) {
            double yVal = yData.get(i);
            int y = (int) ((yVal - minY) / (maxY - minY) * getWidth());
            yCord.add(y);
        }
    }

    public void setDiameterValues(){

        double max = diameterRaw.get(0);
        for (double d : diameterRaw) {
            if(d > max) max = d;
        }
        for (double d : diameterValues) {
        diameterValues.add((int) (50 * d/max));
        }
    }
}
