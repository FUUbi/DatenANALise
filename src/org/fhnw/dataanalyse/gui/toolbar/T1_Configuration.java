package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.gui.histogram.HistogramManager;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 19.05.2015.
 */
public class T1_Configuration extends JPanel {

    JComboBox choiceList1 = new JComboBox();
    JLabel versusLabel = new JLabel("versus");
    JComboBox choiceList2 = new JComboBox();
    String[] dropDownBox;
    ArrayList<String> dropDownList = new ArrayList<String>();
    //choiceList1.setMaximumSize

    int xAxisIndex;
    int yAxisIndex;


    public T1_Configuration(DataModel dataModel, final HistogramManager histogramManager, final ScatterPlotPanel scatterPlotPanel) {

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        int n = dataModel.getVariableList().size();
        for (int i = 0; i < n; i++) {
            dropDownList.add(dataModel.getVariableList().get(i).getName());
        }

        if (n == 0) {
            for (String s : dropDownBox) {
                choiceList1.addItem(s);
            }
        } else {
            for (String s : dropDownList) {
                choiceList1.addItem(s);
            }
        }


        if (n == 0) {
            for (String s : dropDownBox) {
                choiceList2.addItem(s);
            }
        } else {
            for (String s : dropDownList) {
                choiceList2.addItem(s);
            }
        }


        add(Box.createHorizontalGlue());
        add(choiceList1);
        add(versusLabel);
        add(choiceList2);
        add(Box.createHorizontalGlue());


        choiceList1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                histogramManager.setSelectedVariableIndex1(choiceList1.getSelectedIndex());
                histogramManager.actionPreformtUpdate("cbx1Changte");
                scatterPlotPanel.setSelectedVariableIndex1(choiceList1.getSelectedIndex());
                scatterPlotPanel.actionPerformedUpdate("cbx1Change");
            }
        });

        choiceList2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                histogramManager.actionPreformtUpdate("cbx2Changte");
                scatterPlotPanel.setSelectedVariableIndex2(choiceList2.getSelectedIndex());
                scatterPlotPanel.actionPerformedUpdate("cbx2Change");
            }
        });

    }

    public int getxAxisIndex() {
        return xAxisIndex;
    }
}

