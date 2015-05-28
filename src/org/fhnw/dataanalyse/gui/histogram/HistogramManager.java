package org.fhnw.dataanalyse.gui.histogram;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.histogramdata.BinRanges;
import org.fhnw.dataanalyse.histogramdata.Bins;


import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 21.05
 * .2015.
 */

public class HistogramManager extends JPanel{
    DataModel dataModel;

    int selectedVariableIndex0 = 0;
    int selectedVariableIndex1 = 0;

    BinRanges binRanges0 = new BinRanges();
    BinRanges binRanges1 = new BinRanges();
    Bins bins0 = new Bins();
    Bins bins1 = new Bins();

    private DrawHisto drawHisto0 = new DrawHisto();
    private DrawHisto drawHisto1 = new DrawHisto();

    boolean histo0State = false;
    boolean histo1State = false;


    public HistogramManager(DataModel dataModel){
        this.dataModel = dataModel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        }


    public void setSelectedVariableIndex0(int selectedVariableIndex0) {
        this.selectedVariableIndex0 = selectedVariableIndex0;
        System.out.println(selectedVariableIndex0);
    }

    public void setSelectedVariableIndex1(int selectedVariableIndex1) {
        this.selectedVariableIndex1 = selectedVariableIndex1;
    }

    public void updateHisto0(){
        if (histo0State) {
            ArrayList<Double> variableValues = dataModel.getVariableList().get(selectedVariableIndex0).getData();
            binRanges0.setbinRanges(variableValues);
            bins0.setBinQuantity(variableValues, binRanges0.getBinRanges());
            drawHisto0.updateHistoValues(bins0.getBinAbsolteQuantity());

            String title = dataModel.getVariableList().get(selectedVariableIndex0).getName();
            drawHisto0.setBorder(BorderFactory.createTitledBorder(title));

        }
    }

    public void updateHisto1(){
        if (histo1State) {
            ArrayList<Double> variableValues = dataModel.getVariableList().get(selectedVariableIndex1).getData();
            binRanges1.setbinRanges(variableValues);
            bins1.setBinQuantity(variableValues, binRanges1.getBinRanges());
            drawHisto1.updateHistoValues(bins1.getBinAbsolteQuantity());

            String title = dataModel.getVariableList().get(selectedVariableIndex1).getName();
            drawHisto1.setBorder(BorderFactory.createTitledBorder(title));

        }
    }

    public void setHisto0State(boolean histo0State) {
        this.histo0State = histo0State;
        stageChanged();

    }

    public void setHisto1State(boolean histo1State) {
        this.histo1State = histo1State;
        stageChanged();
    }

    private void stageChanged(){
        removeAll();

        if(histo0State) {
            String title = dataModel.getVariableList().get(selectedVariableIndex0).getName();
            drawHisto0.setBorder(BorderFactory.createTitledBorder(title));
            updateHisto0();
            add(drawHisto0);
        }

        if (histo1State){
            String title = dataModel.getVariableList().get(selectedVariableIndex1).getName();
            drawHisto1.setBorder(BorderFactory.createTitledBorder(title));
            updateHisto1();
            add(drawHisto1);
        }

    }


}
