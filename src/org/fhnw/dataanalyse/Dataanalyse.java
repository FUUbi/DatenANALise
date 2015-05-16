package org.fhnw.dataanalyse;

import org.fhnw.dataanalyse.datamodell.Variable;
import org.fhnw.dataanalyse.datamodell.VariableContainer;
import org.fhnw.dataanalyse.gui.GuiApp;
import org.fhnw.dataanalyse.gui.toolbar.T1_Configuration;


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
        //gA.GuiApp(panelwoniwett).add(t.T1Config());
        gA.add(t.T1Config());//funktioniert so nur in dem, dass dem PanelConfiguration iwo im Frame plaziert sein wird....


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
