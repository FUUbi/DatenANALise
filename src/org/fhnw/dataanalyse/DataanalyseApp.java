package org.fhnw.dataanalyse;

import org.fhnw.dataanalyse.datamodell.Variable;
import org.fhnw.dataanalyse.datamodell.VariableContainer;
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
import java.util.ArrayList;

/**
 * Created by Fabrizio on 13.05.2015.
 *
 */

public class DataanalyseApp {
    VariableContainer variableContainer;
    ArrayList<Variable> variableArrayList;
    HistoPlot histPlot;
    T1_Configuration tb;
    T2sp_Configuration tb2;

    public DataanalyseApp(){
        variableContainer = new VariableContainer();
        variableContainer.chooseFile();
        variableContainer.loadVariables();
        variableArrayList = variableContainer.getVariables();



        GuiApp gA = new GuiApp();

        tb = new T1_Configuration();
        gA.toolbar1.add(tb.getPanel(), BorderLayout.CENTER);

        tb2 = new T2sp_Configuration();
        gA.toolbar2_plot.add(tb2.getPanel2(), BorderLayout.CENTER);


        ScatterPlotPanel splot = new ScatterPlotPanel(variableArrayList);
        gA.plot.add(splot);

        histPlot = new HistoPlot(variableArrayList);
        gA.histo.add(histPlot);


        createActionListner();

    }


    public void createActionListner(){
        /*
        this Method will create all Actionlist

        tb.loadBtnAddActionListner(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                variableContainer.chooseFile();
                variableContainer.loadVariables();
                histPlot.updateHistoData(variableContainer.getVariables());
            }
        });

        */

        tb.loadBtnAddActionListner(new ActionLoadFile(variableContainer, histPlot));


    }


    public static void main(String[] args){
        new DataanalyseApp();
    }
}
