package org.fhnw.dataanalyse.gui.scatterplot;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.scatterplotdata.ScatterValues;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 */
public class ScatterPlotPanel extends JPanel {

    private int selectedVariableIndex1;
    private int selectedVariableIndex2;
    private int selectedVariableIndex3;
    private int diameter;
    private boolean isSelected;
    private boolean relativeSize;

    ScatterValues scatterValuesIndex1 = new ScatterValues();
    ScatterValues scatterValuesIndex2 = new ScatterValues();
    ScatterPlotContent scatterPlotContent = new ScatterPlotContent();

    DataModel dataModel;

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
        ArrayList<Double> index1Values = dataModel.getVariableList().get(selectedVariableIndex1).getData();
        ArrayList<Double> index2Values = dataModel.getVariableList().get(selectedVariableIndex2).getData();
        ArrayList<Double> index3Values = dataModel.getVariableList().get(selectedVariableIndex3).getData();
        scatterValuesIndex1.setScatterValuesX(index1Values);
        scatterValuesIndex2.setScatterValuesY(index2Values);
        boolean checked = isSelected;
        int sliderValue = diameter;
        scatterPlotContent.setScatterPlotContent(scatterValuesIndex1.getMinX(),scatterValuesIndex1.getMaxX(),
                scatterValuesIndex2.getMinY(),scatterValuesIndex2.getMaxY(),index1Values,index2Values,index3Values,checked,sliderValue,relativeSize);

    }

}