package org.fhnw.dataanalyse.gui.scatterplot;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.datamodell.Variable;
import org.fhnw.dataanalyse.scatterplotdata.ScatterValues;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Sven on 17.05.2015.
 */
public class ScatterPlotPanel extends JPanel {

    DataModel dataModel;

    int selectedVariableIndex1;
    int selectedVariableIndex2;

    ScatterValues scatterValuesIndex1 = new ScatterValues();
    ScatterValues scatterValuesIndex2 = new ScatterValues();


    ScatterPlotContent scatterPlotContent = new ScatterPlotContent();

    public ScatterPlotPanel(DataModel dataModel){
        this.dataModel = dataModel;
        updateScatterPlotContent();
    }

    public void colorChanged(Color color){
        getScatterPlotContent().setColor(color);
    }

    public void actionPerformedUpdate(String action){
        if(action.equals("cbx1Changte")){
            updateScatterPlotContent();
        }
        else if (action.equals("cbx2Change")){
            updateScatterPlotContent();
        }
    }

    public void setSelectedVariableIndex1(int selectedVariableIndex1) {
        this.selectedVariableIndex1 = selectedVariableIndex1;
    }

    public void setSelectedVariableIndex2(int selectedVariableIndex2) {
        this.selectedVariableIndex2 = selectedVariableIndex2;
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

    public ScatterPlotContent getScatterPlotContent(){
        return scatterPlotContent;
    }

    private void updateScatterPlotContent(){
        ArrayList<Float> index1Values = dataModel.getVariableList().get(selectedVariableIndex1).getData();
        ArrayList<Float> index2Values = dataModel.getVariableList().get(selectedVariableIndex2).getData();
        scatterValuesIndex1.setScatterValuesX(index1Values);
        scatterValuesIndex2.setScatterValuesY(index2Values);
        scatterPlotContent.setScatterPlotContent(scatterValuesIndex1.getMinX(),scatterValuesIndex1.getMaxX(),
                scatterValuesIndex2.getMinY(),scatterValuesIndex2.getMaxY(),index1Values,index2Values);

    }
}