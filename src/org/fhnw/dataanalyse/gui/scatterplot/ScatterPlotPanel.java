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
    private int selectedVariableIndex3;
    private boolean isSelected;
    private int diameter;
    private boolean relativeSize;


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
        if(action.equals("cbx1Change")){
            updateScatterPlotContent();
        }
        else if (action.equals("cbx2Change")){
            updateScatterPlotContent();
        }
        else if (action.equals("cbx3Change")){
            updateScatterPlotContent();
        }
        else if (action.equals("drawChecked")){
            updateScatterPlotContent();
        }
        else if (action.equals("drawUnChecked")){
            updateScatterPlotContent();
        }
        else if (action.equals("sliderValue")){
            updateScatterPlotContent();
        }
    }

    public void setSelectedVariableIndex1(int selectedVariableIndex1) {
        this.selectedVariableIndex1 = selectedVariableIndex1;
    }

    public void setSelectedVariableIndex2(int selectedVariableIndex2) {
        this.selectedVariableIndex2 = selectedVariableIndex2;
    }

    public void setSelectedVariableIndex3(int selectedVariableIndex3, boolean relativeSize){
        this.selectedVariableIndex3 = selectedVariableIndex3;
        this.relativeSize = relativeSize;
    }

    public void setLineDrawingChecked(boolean isSelected){
        this.isSelected = isSelected;
    }

    public void setDiameter(int diameter, boolean relativeSize){
        this.diameter = diameter;
        this.relativeSize = relativeSize;
    }


    public ScatterPlotContent getScatterPlotContent(){
        return scatterPlotContent;
    }

    private void updateScatterPlotContent(){
        ArrayList<Float> index1Values = dataModel.getVariableList().get(selectedVariableIndex1).getData();
        ArrayList<Float> index2Values = dataModel.getVariableList().get(selectedVariableIndex2).getData();
        ArrayList<Float> index3Values = dataModel.getVariableList().get(selectedVariableIndex3).getData();
        scatterValuesIndex1.setScatterValuesX(index1Values);
        scatterValuesIndex2.setScatterValuesY(index2Values);
        boolean checked = isSelected;
        int sliderValue = diameter;
        scatterPlotContent.setScatterPlotContent(scatterValuesIndex1.getMinX(),scatterValuesIndex1.getMaxX(),
                scatterValuesIndex2.getMinY(),scatterValuesIndex2.getMaxY(),index1Values,index2Values,index3Values,checked,sliderValue,relativeSize);

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