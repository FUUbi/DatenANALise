package org.fhnw.dataanalyse.scatterplotdata;

import java.util.ArrayList;

/**
 *
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
        minX = 0.d;
        for (Double f : data) if (f.compareTo(minX) == -1) minX = f;

        maxX = 0.d;
        for (Double f : data) if (f.compareTo(maxX) == 1) maxX = f;

        }

    public void setScatterValuesY(ArrayList<Double> data) {


        scatterValuesY.clear();
        minY = 0.d;
        for (Double f : data) if (f.compareTo(minY) == -1) minY = f;

        maxY = 0.d;
        for (Double f : data) if (f.compareTo(maxY) == 1) maxY = f;

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
