package org.fhnw.dataanalyse.gui.toolbar;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Fabrizio on 19.05.2015.
 */
public class T1_Configuration {
    JPanel  panel;
    JButton loadFile;
    JButton deleteFile;
    String[] dropDownBox = {"Fabri", "g", "Lise"};



    public T1_Configuration(){
        panel = new JPanel();
      // panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));


        loadFile = new JButton("Load File");
        deleteFile = new JButton("Delete File");


        JComboBox choiceList = new JComboBox(dropDownBox);
        choiceList.setEditable(true);


        panel.add(loadFile);
        panel.add(Box.createHorizontalGlue());
        panel.add(deleteFile);
        panel.add(Box.createHorizontalGlue());
        panel.add(choiceList);
    }

    public void loadBtnAddActionListner(ActionListener aL){
        loadFile.addActionListener(aL);
    }

    public JPanel getPanel(){
        return panel;
    }
}
