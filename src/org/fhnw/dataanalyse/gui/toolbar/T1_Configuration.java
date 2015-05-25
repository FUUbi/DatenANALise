package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.gui.GuiApp;
import org.fhnw.dataanalyse.gui.histogram.HistogramManager;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;

import javax.swing.*;
import java.awt.*;
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
    JComboBox choiceList3 = new JComboBox();
    String[] dropDownBox;
    int xAxisIndex;
    int yAxisIndex;


    public T1_Configuration(DataModel dataModel,
                            final HistogramManager histogramManager,
                            final ScatterPlotPanel scatterPlotPanel,
                            String fileName,
                            final GuiApp guiApp) {

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createTitledBorder(fileName.substring(0,fileName.indexOf("."))));



        ArrayList<String> dropDownList = new ArrayList<String>();

        final JComboBox choiceList1 = new JComboBox();
        final JComboBox choiceList2 = new JComboBox();

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


        if (n == 0) {
            for (String s : dropDownBox) {
                choiceList3.addItem(s);
            }
        } else {
            for (String s : dropDownList) {
                choiceList3.addItem(s);
            }
        }


        add(Box.createHorizontalGlue());
        add(new Label("X-Axis"));
        add(choiceList1);
        add(Box.createHorizontalGlue());
        add(new Label("Y-Axis"));
        add(choiceList2);
        add(choiceList3);
        add(Box.createHorizontalGlue());

        choiceList1.setActionCommand("ComboBox1");
        choiceList2.setActionCommand("ComboBox2");

        choiceList1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xAxisIndex = choiceList1.getSelectedIndex();

                histogramManager.setSelectedVariableIndex1(choiceList1.getSelectedIndex());
                histogramManager.actionPreformtUpdate("cbx1Changte");

                scatterPlotPanel.setSelectedVariableIndex1(choiceList1.getSelectedIndex());
                scatterPlotPanel.actionPerformedUpdate("cbx1Change");
                System.out.println(choiceList1.getSelectedIndex());
       //         t2h_configuration.setSelectedVariableIndex1(choiceList1.getSelectedIndex());
         //       t2h_configuration.actionPreformt();
                guiApp.actionPerformed(e);
            }
        });

        choiceList2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yAxisIndex = choiceList2.getSelectedIndex();
                guiApp.actionPerformed(e);
                histogramManager.actionPreformtUpdate("cbx2Changte");
                scatterPlotPanel.setSelectedVariableIndex2(choiceList1.getSelectedIndex());
                scatterPlotPanel.actionPerformedUpdate("cbx2Change");
            }
        });

        choiceList3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scatterPlotPanel.setSelectedVariableIndex3(choiceList3.getSelectedIndex());
                scatterPlotPanel.actionPerformedUpdate("cbx3Change");
            }
        });

    }

    public JPanel getPanel(){
        return this;
    }

    public int getxAxisIndex() {

        return xAxisIndex;
    }

    public int getyAxisIndex() {
        return yAxisIndex;
    }
}

