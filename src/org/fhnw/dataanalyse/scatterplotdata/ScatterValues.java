package org.fhnw.dataanalyse.scatterplotdata;

import java.util.ArrayList;

/**
 * ScatterValues contains setScatterValuesX (minX and maxX) and setScatterValuesY(minY and maxY)
 * ScatterValues provides the different methods to access to the min and max values : getMinX(), getMaxX(), getMinY(), getMaxY()
 */

public class ScatterValues {

    private double minX = 0.d;
    private double minY = 0.d;
    private double maxX = 0.d;
    private double maxY = 0.d;
    private ArrayList<Double> scatterValuesX = new ArrayList<Double>();
    private ArrayList<Double> scatterValuesY = new ArrayList<Double>();

    public void setScatterValuesX(ArrayList<Double> data) {

        scatterValuesX.clear();
        minX = data.get(0);
        for (Double d : data) if (d.compareTo(minX) == -1) minX = d;

        maxX = data.get(0);
        for (Double d : data) if (d.compareTo(maxX) == 1) maxX = d;

        }

    public void setScatterValuesY(ArrayList<Double> data) {

        scatterValuesY.clear();
        minY = data.get(0);
        for (Double d : data) if (d.compareTo(minY) == -1) minY = d;

        maxY = data.get(0);
        for (Double d : data) if (d.compareTo(maxY) == 1) maxY = d;

    }

    public double getMinX(){
        return minX;
    }
    public double getMaxX(){
        return maxX;
    }

    public double getMinY(){
        return minY;
    }
    public double getMaxY(){
        return maxY;
    }
}
