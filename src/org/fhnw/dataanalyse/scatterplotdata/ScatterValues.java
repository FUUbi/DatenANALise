package org.fhnw.dataanalyse.scatterplotdata;

import java.util.ArrayList;

/**
 *
 */

public class ScatterValues {

    private float minX = (float)0.0;
    private float minY = (float)0.0;
    private float maxX = (float)0.0;
    private float maxY = (float)0.0;
    private ArrayList<Float> scatterValuesX = new ArrayList<Float>();
    private ArrayList<Float> scatterValuesY = new ArrayList<Float>();

    public void setScatterValuesX(ArrayList<Float> data) {

        scatterValuesX.clear();
        minX = (float)0.0;
        for (Float f : data) if (f.compareTo(minX) == -1) minX = f;
        maxX = (float)0.0;
        for (Float f : data) if (f.compareTo(maxX) == 1) maxX = f;

        }

    public void setScatterValuesY(ArrayList<Float> data) {

        scatterValuesY.clear();
        minY = (float)0.0;
        for (Float f : data) if (f.compareTo(minY) == -1) minY = f;
        maxY = (float)0.0;
        for (Float f : data) if (f.compareTo(maxY) == 1) maxY = f;

    }

    public float getMinX(){
        return minX;
    }
    public float getMaxX(){
        return maxX;
    }
    public float getMinY(){
        return minY;
    }
    public float getMaxY(){
        return maxY;
    }


}
