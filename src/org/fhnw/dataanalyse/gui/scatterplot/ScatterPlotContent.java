package org.fhnw.dataanalyse.gui.scatterplot;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
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
    private ArrayList<Integer> xCord = new ArrayList<Integer>();
    private ArrayList<Double> yData;
    private ArrayList<Integer> yCord = new ArrayList<Integer>();
    private ArrayList<Double> diameterRaw;
    private ArrayList<Integer> diameterValues = new ArrayList<Integer>();
    private int lastVariableIndex3;
    boolean drawLine;
    private int sliderDiameter;
    private boolean relativeSize;
    private int border = 200;
    private String xName;
    private String yName;
    private Color bgColor = Color.white;
    Color  color = Color.ORANGE;



    public ScatterPlotContent() {
        setBorder(BorderFactory.createTitledBorder("Scatter Plot"));
        setBackground(bgColor);
    }

    public void setScatterPlotContent(double minX, double maxX, double minY, double maxY,
                                      ArrayList<Double> index1Values, ArrayList<Double> index2Values,
                                      boolean checked, int sliderValue,
                                      boolean relativeSize, String xName, String yName) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.xData = index1Values;
        this.yData = index2Values;
        this.drawLine = checked;
        this.sliderDiameter = sliderValue;
        this.relativeSize = relativeSize;
        this.xName = xName;
        this.yName = yName ;


        revalidate();  /* ensures the dynamism of the ScatterPlot on the GUI */
        repaint();
    }


    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        setXCord();
        setYCord();

        for (int i = 0; i < xCord.size(); i++) {
            int valueX1 = xCord.get(i);
            int valueY1 = yCord.get(i);
            int diameter;

            if(relativeSize){
                diameter = diameterValues.get(i);
            }
            else{
                diameter = sliderDiameter;}


            /* Initialisation of values' coordinate */
            int a = valueX1;

            int b = valueY1;
            b += diameter/2;
            b = (getHeight() - b);

            g.setColor(color);
            g.fillOval(a, b, diameter, diameter);

        }
        for (int i = 1; i < xCord.size(); i++) {
            if (drawLine) {
                int valueX1 = xCord.get(i - 1);
                int valueY1 = yCord.get(i - 1);
                int valueX2 = xCord.get(i);
                int valueY2 = yCord.get(i);
                int diameter;

                if(relativeSize){
                    diameter = diameterValues.get(i);
                }
                else{
                    diameter = sliderDiameter;}

                /* Initialisation of values' coordinate */
                int a = valueX1;
                a += diameter/2;


                int b = valueY1;
                b = (getHeight() - b);


                int c = valueX2;
                c += diameter/2;


                int d = valueY2;
                d = (getHeight() - d);

                g.setColor(Color.black);
                g.drawLine(a, b, c, d);
            }
            g.setColor(Color.BLACK);
            g.drawString("X-Axis: " + xName, getWidth() / 2, getHeight() - border / 10);
            AffineTransform orig = g2.getTransform();
            AffineTransform at = new AffineTransform();
            at.rotate(Math.toRadians(-90), border/6, getHeight()/2);
            g2.setTransform(at);
            g2.drawString("Y-Axis: " + yName, -getWidth()/10, getHeight()/2);
            g2.setTransform(orig);
        }
    }

    public void setXCord() {
        xCord.clear();
        int diameter = 50;
        if(!relativeSize) diameter = sliderDiameter;

        for (int i = 0; i < xData.size(); i++) {
            double xVal = xData.get(i);
            int width = getWidth() - diameter - border;

            int x;

            if(((Double)minX).compareTo(0.d) == -1){
                x = (int) ((xVal + Math.abs(minX)) / (maxX - minX) * width);
            }
            else{
                x = (int) ((xVal - minX)/(maxX - minX) * width);
            }

            x += (border/2);
            xCord.add(x);
        }
    }

    public void setYCord(){
        yCord.clear();
        int diameter = 50;
        if(!relativeSize) diameter = sliderDiameter;

        for (int i = 0; i < yData.size(); i++) {
            double yVal = yData.get(i);
            int height = getHeight() - diameter - border;

            int y;

            if(((Double)minY).compareTo(0.d) == -1){
                y = (int) ((yVal + Math.abs(minY)) / (maxY - minY) * height);
            }
            else{
                y = (int) ((yVal - minY)/(maxY - minY) * height);
            }

            y += (border/2);
            yCord.add(y);
        }
    }


    public void setDiameterRaw(ArrayList<Double> diameterRawValues) {
        this.diameterRaw = diameterRawValues;
    }

    public void setDiameterValues(){
        diameterValues.clear();
        double max = diameterRaw.get(0);
        for (double d : diameterRaw) {
            if(d > max) max = d;
        }
        diameterValues.clear();
        for (double d : diameterRaw) {
        diameterValues.add((int) (50 * d/max));
        }

    }


}
