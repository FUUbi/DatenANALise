package org.fhnw.dataanalyse;

import org.fhnw.dataanalyse.datamodell.Variable;
import org.fhnw.dataanalyse.datamodell.VariableContainer;
import org.fhnw.dataanalyse.gui.GuiApp;
import org.fhnw.dataanalyse.gui.histogram.HistoPlot;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;
import org.fhnw.dataanalyse.gui.toolbar.T1_Configuration;
import org.fhnw.dataanalyse.gui.toolbar.Toolbar1;


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


    public DataanalyseApp(){
        variableContainer = new VariableContainer();
        variableContainer.chooseFile();
        variableContainer.loadVariables();
        variableArrayList = variableContainer.getVariables();



        GuiApp gA = new GuiApp();

        tb = new T1_Configuration();
        gA.toolbar1.add(tb.getPanel(), BorderLayout.WEST);

        ScatterPlotPanel splot = new ScatterPlotPanel(variableArrayList);
        gA.plot.add(splot, BorderLayout.CENTER);

        histPlot = new HistoPlot(variableArrayList);
        gA.histo.add(histPlot);

        createActionListner();

    }


    public void createActionListner(){
        /*
        this Method will create all Actionlist
         */
        tb.test(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                variableContainer.chooseFile();
                variableContainer.loadVariables();
                histPlot.updateHistoData(variableContainer.getVariables());
            }
        });


    }


    public static void main(String[] args){
        new DataanalyseApp();
    }
}
