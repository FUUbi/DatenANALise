package org.fhnw.dataanalyse;

import org.fhnw.dataanalyse.datamodell.*;
import org.fhnw.dataanalyse.gui.GuiApp;
import org.fhnw.dataanalyse.gui.histogram.DrawHisto;
import org.fhnw.dataanalyse.gui.histogram.HistogramManager;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;
import org.fhnw.dataanalyse.gui.toolbar.ActionLoadFile;
import org.fhnw.dataanalyse.gui.toolbar.T1_Configuration;
import org.fhnw.dataanalyse.gui.toolbar.T2sp_Configuration;
import org.fhnw.dataanalyse.histogramdata.BinRanges;
import org.fhnw.dataanalyse.histogramdata.Bins;


import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 13.05.2015.
 *
 */

public class DataanalyseApp {
    ArrayList<Variable> variableArrayList;
    DataModel dataModel;
    GuiApp gA;

    ScatterPlotPanel splot;

    T1_Configuration tb;
    T2sp_Configuration tb2;


    public DataanalyseApp(){

//        dataModel.setVariableList(new VariableLoader(new FileChooser().getNewFile()).loadVariables());
        //variableArrayList = dataModel.getVariableList();


        loadDataModel();
        variableArrayList = dataModel.getVariableList();

        HistogramManager histogramManager = new HistogramManager(dataModel);


        // Ausso lise dini Gui Klass und ihri unterkalsse wend irgendwie wüsse was mini so für
        // variable iglse hend darum gämmer ihre variableArraylist mit

        /*
       wemmer obe luge gehmer, das das es Array isch wo alli variable beinhaltet
        ArrayList<Variable> variableArrayList;

        Wie viel variable sind igläse worde?? --> dataModel.getVariableList().size()  --> git en int zrung

        wie heis die erschi variable?? --> dataModel.getVariableList().get(0).getName() ---> git en string zrung


        Hans dir scho mol ine do, du gsehsch au im GuiApp und Im T1_Configuration en Pfil denn weisch wonis witter geh
        han ;D

         */


        gA = new GuiApp(dataModel, histogramManager);


        JPanel toolbar2Plot = gA.getToolbar2Left();


        splot = new ScatterPlotPanel(variableArrayList);
        gA.getPlot().add(splot);



        gA.repaint();

    }



    public void loadDataModel(){

        File file = new FileChooser().getNewFile();
        IVariableLoader loader = new VariableLoader(file).loadVariables();
        dataModel =  loader.loadVariable(file);

    }




    public static void main(String[] args){

        new DataanalyseApp();







    }
}
