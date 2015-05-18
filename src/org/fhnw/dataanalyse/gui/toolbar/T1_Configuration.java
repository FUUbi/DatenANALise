package org.fhnw.dataanalyse.gui.toolbar;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.fhnw.dataanalyse.datamodell.Variable;
import org.fhnw.dataanalyse.datamodell.VariableContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Vallat on 16.05.2015.
 */
public class T1_Configuration extends JPanel {

    public JPanel T1_Configuration( ArrayList<Variable> container)

    {
        JPanel toolbar1Content = new JPanel();
        JButton loadFileButton = new JButton("Load File");
        toolbar1Content.add(loadFileButton);

        loadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                container.chooseFile();
                container.loadVariables();

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
