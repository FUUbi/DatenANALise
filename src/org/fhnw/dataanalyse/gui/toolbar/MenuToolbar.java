package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.gui.GuiApp;
import org.fhnw.dataanalyse.gui.histogram.HistogramManager;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 19.05.2015.
 */
public class MenuToolbar extends JPanel {

    int xAxisIndex;
    int yAxisIndex;
    int comboxLastIndex = 0;

    public MenuToolbar(DataModel dataModel,
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
                choiceList1.addItem("-");
            }
         else {
            for (String s : dropDownList) {
                choiceList1.addItem(s);
            }
        }

        if (n == 0) {

                choiceList2.addItem("-");
            }
         else {
            for (String s : dropDownList) {
                choiceList2.addItem(s);
            }
        }


        add(Box.createHorizontalGlue());
        add(new Label("X-Axis"));
        add(choiceList1);
        add(Box.createHorizontalGlue());
        add(new Label("Y-Axis"));
        add(choiceList2);
        add(Box.createHorizontalGlue());

        choiceList1.setActionCommand("ComboBox1");
        choiceList2.setActionCommand("ComboBox2");

        choiceList1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if((e.getStateChange() == ItemEvent.SELECTED)){
                    xAxisIndex = choiceList1.getSelectedIndex();

                    guiApp.getHistogramManager().setSelectedVariableIndex0(xAxisIndex);
                    guiApp.getHistogramManager().updateHisto0();

                    guiApp.getScatterPlotPanel().setSelectedVariableIndex1(xAxisIndex);
                    guiApp.getScatterPlotPanel().actionPerformedUpdate("cbx1Change");

                    guiApp.getHistoToolbar().setHisto1CheckBoxText();
                    revalidate();
                    guiApp.repaint();
                }
            }
        });


        choiceList2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                yAxisIndex = choiceList2.getSelectedIndex();
                histogramManager.setSelectedVariableIndex1(yAxisIndex);
                histogramManager.updateHisto1();

                scatterPlotPanel.setSelectedVariableIndex2(choiceList1.getSelectedIndex());
                scatterPlotPanel.actionPerformedUpdate("cbx2Change");
                guiApp.getHistoToolbar().setHisto2CheckboxText();

                revalidate();
                guiApp.repaint();
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

