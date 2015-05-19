package org.fhnw.dataanalyse;

import org.DrawHisto;
import org.fhnw.dataanalyse.datamodell.Variable;
import org.fhnw.dataanalyse.datamodell.VariableContainer;
import org.fhnw.dataanalyse.gui.GuiApp;
import org.fhnw.dataanalyse.gui.histogram.HistoPlot;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;
import org.fhnw.dataanalyse.gui.toolbar.T1_Configuration;


import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 13.05.2015.
 *
 */

public class Dataanalyse {
    public static void main(String[] args){

        VariableContainer VariablenConainer = new VariableContainer();


        VariablenConainer.chooseFile();

        VariablenConainer.loadVariables();


        //hier wird das Array das sich im container befindet der dem array zugewiesen
        ArrayList<Variable> actuelleVariablen = VariablenConainer.getVariables();

        for (Variable v : actuelleVariablen) {
            for (Float aFloat : v.getData()) {
                if (aFloat == null){
                    System.out.printf("ksdfjl");
                }
            }


            System.out.println(v.getName());
            System.out.println(v.getData());
            System.out.println("");
        }


        System.out.println(actuelleVariablen.get(1).getName());
        System.out.println(actuelleVariablen.get(1).getData());


        // add panelConfiguration to GuiApp
        T1_Configuration t = new T1_Configuration(/*VariablenConainer*/);
        GuiApp gA = new GuiApp();
        gA.toolbar1.add(t.T1_Configuration(/*VariablenConainer*/), BorderLayout.WEST);
        ScatterPlotPanel splot = new ScatterPlotPanel(actuelleVariablen);
        gA.plot.add(splot, BorderLayout.CENTER);
        //gA.GuiApp(panelwoniwett).add(t.T1Config());

        /// wichtig isch das du ins frame toolbar addisch vorher hesch ins gA
        /// darum hets au ade sitte ane do
        // mitem borderlayout seisch was söll aschloh
        gA.toolbar1.add(t.T1_Configuration(), BorderLayout.WEST);

        HistoPlot hitog = new HistoPlot(actuelleVariablen);
        /* ohne klasse DrawHisto
        gA.histo.add(hitog);
        VariablenConainer.chooseFile();
        VariablenConainer.loadVariables();
        actuelleVariablen = VariablenConainer.getVariables();
        hitog.updateHistoData(actuelleVariablen);

        */

        /* mit klasse DrawHisto*/
        DrawHisto dhisto = new DrawHisto(hitog);
        gA.histo.add(dhisto);

        VariablenConainer.chooseFile();
        VariablenConainer.loadVariables();
        actuelleVariablen = VariablenConainer.getVariables();
        hitog.updateHistoData(actuelleVariablen);
        dhisto.updatehist(hitog);

        System.out.println(actuelleVariablen.get(1).getData());

        System.out.println(hitog.getNumbersOfBin());

    }
}
