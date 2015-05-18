package org.fhnw.dataanalyse.gui.toolbar;

import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.scene.control.ComboBox;
import org.fhnw.dataanalyse.datamodell.Variable;
import org.fhnw.dataanalyse.datamodell.VariableContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Created by Vallat on 16.05.2015.
 */
public class T1_Configuration extends JPanel {

    public JPanel T1_Configuration( /*ArrayList<Variable> container*/)

    {
        int column = 15;
        int hgap = 200;

        JPanel toolbar1Content = new JPanel(new GridLayout(1,column,hgap,1));
        JButton loadFile = new JButton("Load File");
        JButton deleteFile = new JButton("Delete File");

        String[] dropDownBox = {"Fabri", "g", "Lise"};

        JComboBox choiceList = new JComboBox(dropDownBox);
        choiceList.setEditable(true);

        toolbar1Content.add(loadFile);
        toolbar1Content.add(deleteFile);
        toolbar1Content.add(choiceList);


        loadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //container.chooseFile();
                //container.loadVariables();
                System.out.println("ActionListenerLoadFile");
            }
        });

        deleteFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //container.chooseFile();
                //container.loadVariables();
                System.out.println("ActionListenerDeleteFile");
            }
        });




        // name der variable

/*
        int anzahl = container.size();

        for (Variable v : container) System.out.println(v.getName());

        String name =  container.get(anzahl).getName();
*/
        return toolbar1Content;

    }




}
