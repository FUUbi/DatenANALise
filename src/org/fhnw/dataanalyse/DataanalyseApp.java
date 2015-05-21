package org.fhnw.dataanalyse;

import org.fhnw.dataanalyse.datamodell.*;
import org.fhnw.dataanalyse.gui.GuiApp;
import org.fhnw.dataanalyse.gui.histogram.HistoPlot;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;
import org.fhnw.dataanalyse.gui.toolbar.ActionLoadFile;
import org.fhnw.dataanalyse.gui.toolbar.T1_Configuration;
import org.fhnw.dataanalyse.gui.toolbar.T2sp_Configuration;


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

    HistoPlot histPlot;
    T1_Configuration tb;
    T2sp_Configuration tb2;


    public DataanalyseApp(){

//        dataModel.setVariableList(new VariableLoader(new FileChooser().getNewFile()).loadVariables());
        //variableArrayList = dataModel.getVariableList();

        File file = new FileChooser().getNewFile();
        IVariableLoader loader = new VariableLoader(file).loadVariables();
        dataModel =  loader.loadVariable(file);

        variableArrayList = dataModel.getVariableList();



        GuiApp  gA = new GuiApp(dataModel);



        JPanel toolbar2Plot = gA.getToolbar2Left();
  //      tb2 = new T2sp_Configuration(toolbar2Plot);
  //      gA.getToolbar2Left().add(tb2.getPanel2(), BorderLayout.WEST);


        ScatterPlotPanel splot = new ScatterPlotPanel(variableArrayList);
        gA.getPlot().add(splot);

        histPlot = new HistoPlot(variableArrayList);
        gA.getHisto().add(histPlot);

        createActionListner();


    }



    public void createActionListner(){

        tb.loadBtnAddActionListner(new ActionLoadFile(dataModel, histPlot));
    }




    public static void main(String[] args){

        new DataanalyseApp();

    }
}
