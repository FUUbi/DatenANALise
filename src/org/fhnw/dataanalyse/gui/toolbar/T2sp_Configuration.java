package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.VariableContainer;
import org.fhnw.dataanalyse.gui.histogram.HistoPlot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vallat on 19.05.2015.
 */
public class T2sp_Configuration {

    public JPanel T2sp_Configuration()

    {

        JPanel t2spContent = new JPanel();

        /*t2spContent.setLayout(new BoxLayout(t2spContent, BoxLayout.LINE_AXIS));
        JButton loadBtn = new JButton("Load File");
        JButton deleteFile = new JButton("Delete File");

        String[] dropDownBox = {"Fabri", "g", "Lise"};

        JComboBox choiceList = new JComboBox(dropDownBox);
        choiceList.setEditable(true);

        t2spContent.add(loadBtn);
        t2spContent.add(Box.createHorizontalGlue());
        t2spContent.add(deleteFile);
        t2spContent.add(Box.createHorizontalGlue());
        t2spContent.add(choiceList);



        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                variableContainer.chooseFile();
                variableContainer.loadVariables();
                variableContainer.getVariables();
                histoPlot.updateHistoData(variableContainer.getVariables());
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

    */
        return t2spContent;


    }



}
