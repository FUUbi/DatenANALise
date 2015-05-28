package org.fhnw.dataanalyse.gui.histogram;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.histogramdata.BinRanges;
import org.fhnw.dataanalyse.histogramdata.Bins;
import javax.swing.*;
import java.util.ArrayList;

/**
 * HistogramManager provides the entire content of the HistogramPanel and update it by each call
 * and user's changes
 */

public class HistogramManager extends JPanel{

    private int selectedVariableIndex0 = 0;
    private int selectedVariableIndex1 = 0;

    private boolean histo0State = false;
    private boolean histo1State = false;

    private DrawHisto drawHisto0 = new DrawHisto();
    private DrawHisto drawHisto1 = new DrawHisto();

    private BinRanges binRanges0 = new BinRanges();
    private BinRanges binRanges1 = new BinRanges();
    private Bins bins0 = new Bins();
    private Bins bins1 = new Bins();

    private DataModel dataModel;


    public HistogramManager(DataModel dataModel){
        this.dataModel = dataModel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        }

    public void setSelectedVariableIndex0(int selectedVariableIndex0) {
        this.selectedVariableIndex0 = selectedVariableIndex0;
    }

    public void setSelectedVariableIndex1(int selectedVariableIndex1) {
        this.selectedVariableIndex1 = selectedVariableIndex1;
    }

    /**
     * updateHisto0 updates the first Histogram if the User changed it (histo_x_State)
     */
    public void updateHisto0(){
        if (histo0State) {
            ArrayList<Double> variableValues = dataModel.getVariableList().get(selectedVariableIndex0).getData();
            binRanges0.setBinRanges(variableValues);
            bins0.setBinQuantity(variableValues, binRanges0.getBinRanges());
            drawHisto0.updateHistoValues(bins0.getBinAbsoluteQuantity());

            String title = dataModel.getVariableList().get(selectedVariableIndex0).getName();
            drawHisto0.setBorder(BorderFactory.createTitledBorder(title));

        }
    }

    public void updateHisto1(){
        if (histo1State) {
            ArrayList<Double> variableValues = dataModel.getVariableList().get(selectedVariableIndex1).getData();
            binRanges1.setBinRanges(variableValues);
            bins1.setBinQuantity(variableValues, binRanges1.getBinRanges());
            drawHisto1.updateHistoValues(bins1.getBinAbsoluteQuantity());

            String title = dataModel.getVariableList().get(selectedVariableIndex1).getName();
            drawHisto1.setBorder(BorderFactory.createTitledBorder(title));

        }
    }

    /**
     * setHisto_x_State set the Stage of the histogram and call changeStage
     * @param histo0State which describes the state of the CheckBoxState on the GUI for the Histogram
     */
    public void setHisto0State(boolean histo0State) {
        this.histo0State = histo0State;
        changeStage();

    }

    public void setHisto1State(boolean histo1State) {
        this.histo1State = histo1State;
        changeStage();
    }

    /**
     * changeStage remove all old parameters and set the new ones
     * changeStage also call updateHisto_x_ to update the content
     */
    private void changeStage(){
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
