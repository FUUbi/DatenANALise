package org.fhnw.dataanalyse;

import org.fhnw.dataanalyse.datamodell.*;
import org.fhnw.dataanalyse.gui.GuiApp;
import org.fhnw.dataanalyse.gui.histogram.HistoPlot;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;
import org.fhnw.dataanalyse.gui.toolbar.ActionLoadFile;
import org.fhnw.dataanalyse.gui.toolbar.T1_Configuration;
import org.fhnw.dataanalyse.gui.toolbar.T2sp_Configuration;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 13.05.2015.
 *
 */

public class DataanalyseApp {
    ArrayList<Variable> variableArrayList;
    THEVariableContainer theVariableContainer;

    HistoPlot histPlot;
    T1_Configuration tb;
    T2sp_Configuration tb2;


    public DataanalyseApp(){

//        theVariableContainer.setVariableList(new VariableLoader(new FileChooser().getNewFile()).loadVariables());
        //variableArrayList = theVariableContainer.getVariableList();

        File file = new FileChooser().getNewFile();
        IVariableLoader loader = new VariableLoader(file).loadVariables();
        theVariableContainer =  loader.loadVariable(file);

        variableArrayList = theVariableContainer.getVariableList();


        // Ausso lise dini Gui Klass und ihri unterkalsse wend irgendwie wüsse was mini so für
        // variable iglse hend darum gämmer ihre variableArraylist mit

        /*
       wemmer obe luge gehmer, das das es Array isch wo alli variable beinhaltet
        ArrayList<Variable> variableArrayList;

        Wie viel variable sind igläse worde?? --> variableArrayList.size()  --> git en int zrung

        wie heis die erschi variable?? --> variableArrayList.get(0).getName() ---> git en string zrung


        Hans dir scho mol ine do, du gsehsch au im GuiApp und Im T1_Configuration en Pfil denn weisch wonis witter geh
        han ;D

         */


        GuiApp  gA = new GuiApp(variableArrayList);



        JPanel toolbar2Plot = gA.getToolbar2Left();
        tb2 = new T2sp_Configuration(toolbar2Plot);
        gA.getToolbar2Left().add(tb2.getPanel2(), BorderLayout.WEST);


        ScatterPlotPanel splot = new ScatterPlotPanel(variableArrayList);
        gA.getPlot().add(splot);

        histPlot = new HistoPlot(variableArrayList);
        gA.getHisto().add(histPlot);

        createActionListner();


    }



    public void createActionListner(){


        tb.loadBtnAddActionListner(new ActionLoadFile(theVariableContainer, histPlot));

    }




    public static void main(String[] args){

        new DataanalyseApp();







    }
}
