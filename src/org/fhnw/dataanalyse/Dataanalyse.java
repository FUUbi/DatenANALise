package org.fhnw.dataanalyse;

import org.fhnw.dataanalyse.datamodell.Variable;
import org.fhnw.dataanalyse.datamodell.VariableContainer;
import org.fhnw.dataanalyse.gui.GuiApp;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 13.05.2015.
 *
 */

public class Dataanalyse {
    public static void main(String[] args){
        VariableContainer VariablenConainer = new VariableContainer();
        VariablenConainer.loadVariables();

        //hier wird das Array das sich im container befindet der dem array zugewiesen
        ArrayList<Variable> actuelleVariablen = VariablenConainer.getVariables();

        System.out.println(actuelleVariablen.size()); // anzahl Variablen
        System.out.println(actuelleVariablen.get(0).getName());
        System.out.println(actuelleVariablen.get(0).getData());

        System.out.println(actuelleVariablen.get(1).getName());
        System.out.println(actuelleVariablen.get(1).getData());


        // mann kann auch direkt darauf zugreiffen
        System.out.println( VariablenConainer.getVariables().get(1).getName());


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiApp().setVisible(true);
            }
        });

    }
}
