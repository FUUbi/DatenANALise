package org.fhnw.dataanalyse.gui.histogram;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.histogramdata.BinRanges;
import org.fhnw.dataanalyse.histogramdata.Bins;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 21.05.2015.
 */
public class HistogramManager {
    DataModel dataModel;

    int selectedVariableIndex1;
    int selectedVariableIndex2;

    BinRanges binRanges1 = new BinRanges();
    Bins bins1 = new Bins();


    DrawHisto drawHisto1 = new DrawHisto();
    DrawHisto drawHisto2;





    public HistogramManager(DataModel dataModel){
        this.dataModel = dataModel;
        updateHist1();

    }


    public void actionPreformtUpdate(String action){
        if(action.equals("cbx1Changte")){
            updateHist1();
        }

    }
    public void colorChanged(Color color){
        drawHisto1.setColor(color);
    }


    public void setSelectedVariableIndex1(int selectedVariableIndex1) {
        this.selectedVariableIndex1 = selectedVariableIndex1;
    }

    public DrawHisto getDrawHisto1() {
        return drawHisto1;
    }

    private void updateHist1(){
        ArrayList<Float> variableValues = dataModel.getVariableList().get(selectedVariableIndex1).getData();
        binRanges1.setbinRanges(variableValues);
        bins1.setBinQuantity(variableValues, binRanges1.getBinRanges());
        drawHisto1.updateHistoValues(bins1.getBinRelativQuantity());
    }


}
