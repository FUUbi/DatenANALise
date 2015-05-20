package org.fhnw.dataanalyse.gui.toolbar;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Fabrizio on 19.05.2015.
 */
public class Toolbar1 {
    JPanel  panel;
    JButton loadBtn;
    JButton deleteFile;
    String[] dropDownBox = {"Fabri", "g", "Lise"};


    public Toolbar1(){
        panel = new JPanel();

        loadBtn = new JButton("Load File");
        deleteFile = new JButton("Delete File");


        JComboBox choiceList = new JComboBox(dropDownBox);
        choiceList.setEditable(true);


        panel.add(loadBtn);
        panel.add(Box.createHorizontalGlue());
        panel.add(deleteFile);
        panel.add(Box.createHorizontalGlue());
        panel.add(choiceList);
    }

    
    public void loadBtnAddActionListner(ActionListener aL){
        loadBtn.addActionListener(aL);
    }

    
    public JPanel getPanel(){
        return panel;
    }
}
