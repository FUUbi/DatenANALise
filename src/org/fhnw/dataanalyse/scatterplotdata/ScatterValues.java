package org.fhnw.dataanalyse.scatterplotdata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sven on 24.05.2015.
 */
public class ScatterValues {
    float minX = (float)0.0;
    float minY = (float)0.0;
    float maxX = (float)0.0;
    float maxY = (float)0.0;
    ArrayList<Float> scatterValuesX = new ArrayList<Float>();
    ArrayList<Float> scatterValuesY = new ArrayList<Float>();


    public ScatterValues() {
    }

    public void setScatterValuesX(ArrayList<Float> data) {

        scatterValuesX.clear();

        minX = (float)0.0;
        for (Float f : data) if (f.compareTo(minX) == -1) minX = f;
        maxX = (float)0.0;
        for (Float f : data) if (f.compareTo(maxX) == 1) maxX = f;

        }


    public void setScatterValuesY(ArrayList<Float> data){

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

    /*public ScatterPlotPanel(ArrayList<Variable> v) {

        for (int index = 1; index < v.size(); index++)
        {
            ArrayList<Float> x = v.get(index-1).getData();
            ArrayList<Float> y = v.get(index).getData();

            Float maxX = (float)0.0;
            for (Float f : x) if (f.compareTo(maxX) == 1) maxX = f;
            Float maxY = (float)0.0;
            for (Float f : y) if (f.compareTo(maxY) == 1) maxY = f;
            Float minX = (float)0.0;
            for (Float f : x) if (f.compareTo(minX) == -1) minX = f;
            Float minY = (float)0.0;
            for (Float f : y) if (f.compareTo(minY) == -1) minY = f;


            ScatterPlotContent scatterPanel = new ScatterPlotContent(x,y,maxX,maxY,minY,minX);
            setLayout(new BorderLayout());
            add(scatterPanel);
        }
    }*/

}
