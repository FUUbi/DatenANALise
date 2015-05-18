package org.fhnw.dataanalyse;

import org.fhnw.dataanalyse.datamodell.Variable;
import org.fhnw.dataanalyse.datamodell.VariableContainer;
import org.fhnw.dataanalyse.gui.GuiApp;
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

            System.out.println(v.getName());
            System.out.println(v.getData());
            System.out.println("");
        }


        System.out.println(actuelleVariablen.get(1).getName());
        System.out.println(actuelleVariablen.get(1).getData());


        // add panelConfiguration to GuiApp
        T1_Configuration t = new T1_Configuration();
        GuiApp gA = new GuiApp();
        ScatterPlotPanel splot = new ScatterPlotPanel();
        //gA.GuiApp(panelwoniwett).add(t.T1Config());

        /// wichtig isch das du ins frame toolbar addisch vorher hesch ins gA
        /// darum hets au ade sitte ane do
        // mitem borderlayout seisch was söll aschloh
        gA.toolbar1.add(t.T1Config(), BorderLayout.WEST);
        gA.plot.add(splot, BorderLayout.CENTER);




        // mann kann auch direkt darauf zugreiffen
        System.out.println(VariablenConainer.getVariables().get(1).getName());
/*

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiApp().setVisible(true);
            }
        });
*/
    }
}
