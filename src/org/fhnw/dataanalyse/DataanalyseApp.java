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
    ScatterPlotPanel splot;
    T1_Configuration tb;
    T2sp_Configuration tb2;


    public DataanalyseApp(){

//        dataModel.setVariableList(new VariableLoader(new FileChooser().getNewFile()).loadVariables());
        //variableArrayList = dataModel.getVariableList();

        File file = new FileChooser().getNewFile();
        IVariableLoader loader = new VariableLoader(file).loadVariables();
        dataModel =  loader.loadVariable(file);

        variableArrayList = dataModel.getVariableList();



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


        GuiApp  gA = new GuiApp(dataModel);



        JPanel toolbar2Plot = gA.getToolbar2Left();
  //      tb2 = new T2sp_Configuration(toolbar2Plot);
  //      gA.getToolbar2Left().add(tb2.getPanel2(), BorderLayout.WEST);


        splot = new ScatterPlotPanel(variableArrayList);
        gA.getPlot().add(splot);

        histPlot = new HistoPlot(variableArrayList);
        gA.getHisto().add(histPlot);

        createActionListner();


    }



    public void createActionListner(){


        tb.loadBtnAddActionListner(new ActionLoadFile(dataModel, histPlot, splot));

    }




    public static void main(String[] args){

        new DataanalyseApp();







    }
}
