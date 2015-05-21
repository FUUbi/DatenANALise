package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.DataModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 19.05.2015.
 */
public class T1_Configuration {
    JPanel  panel = new JPanel();
    JButton loadFile = new JButton("Load File");
    JComboBox choiceList1= new JComboBox();
    JLabel versusLabel = new JLabel("versus");
    JComboBox choiceList2= new JComboBox();
    String[] dropDownBox = {"Fabri", "g", "Lise"};
    ArrayList<String> dropDownList = new ArrayList<String>();
    //choiceList1.setMaximumSize



    public T1_Configuration(DataModel dataModel){

        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));

        int n = dataModel.getVariableList().size();
        for (int i=0; i<n;i++) {dropDownList.add(dataModel.getVariableList().get(i).getName());}

        if (n==0) {for (String s : dropDownBox) {choiceList1.addItem(s);}}
        else {for (String s : dropDownList) {choiceList1.addItem(s);}}


        if (n==0) {for (String s : dropDownBox){choiceList2.addItem(s);}}
        else {for (String s:dropDownList) {choiceList2.addItem(s);}}



        panel.add(loadFile);
        panel.add(Box.createHorizontalGlue());
        panel.add(choiceList1);
        panel.add(versusLabel);
        panel.add(choiceList2);
        panel.add(Box.createHorizontalGlue());

    }

    public void loadBtnAddActionListner(ActionListener aL){
        loadFile.addActionListener(aL);
    }

    public JPanel getPanel(){
        return panel;
    }
}
